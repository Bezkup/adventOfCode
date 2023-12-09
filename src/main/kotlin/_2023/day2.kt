package main.kotlin._2023

import readInput
val numberGames = Regex("\\d+(?=:)")
val regexGetAfterGame = Regex("(?<=\\d:).*")
val colorToMax = mapOf("red" to 12, "green" to 13, "blue" to 14)

fun main() {
    val input = readInput("_2023/day2")
    println(part1(input))
    println(part2(input))
}

fun part1(input : List<String>) : Int {
    var total = 0;
    input.forEach { row ->
        val game = numberGames.find(row)?.value?.toInt() ?: 0
        val afterGame = regexGetAfterGame.find(row)?.value ?: ""
        var isValid = true
        afterGame.split(";").forEach { round ->
            val gameCubes = getGameCubes(round)
            val map = mutableMapOf<String, Int>()
            gameCubes.forEach { cube ->
                val array : Array<String> = cube.trim().split("\\s+".toRegex()).toTypedArray()
                map[array[1]] = array[0].toInt()
            }

            map.forEach(){ (color, max) ->
                if (colorToMax[color]!! < max) {
                    isValid = false
                }
            }
        }
        if (isValid) {
            total += game
        }
    }
    return total
}

fun part2 (input: List<String>) : Int {
    var total = 0;
    input.forEach { row ->
        val afterGame = regexGetAfterGame.find(row)?.value ?: ""
        val maxCube = mutableMapOf<String, Int>()
        afterGame.split(";").forEach { round ->
            val gameCubes = getGameCubes(round)
            val map = mutableMapOf<String, Int>()
            gameCubes.forEach { cube ->
                val array : Array<String> = cube.trim().split("\\s+".toRegex()).toTypedArray()
                map[array[1]] = array[0].toInt()
            }
            map.forEach() { (color, max) ->
                if ((maxCube[color] ?: 0) < max) {
                    maxCube[color] = max
                }
            }
        }
        var tmp = 1
        for (color in maxCube.keys) {
            tmp *= maxCube[color]!!
        }
        total += tmp
    }
    return total
}

private fun getGameCubes(round: String): List<String> {
    return round.split(",").filter { it != "" }
}





