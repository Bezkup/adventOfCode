package main.kotlin._2022

import readInput

fun main() {

    fun getGames(input: List<String>): List<Pair<Char, Char>> {
        return input.map { it.split(" ") }
            .map { it[0][0] to it[1][0] }
    }

    fun part1(input: List<String>): Int {
        return getGames(input)
            .map { (it.first - 'A' + 1) to (it.second - 'X' + 1) }
            .sumOf {
                it.second +
                        (when {
                            it.second - it.first == 1 || it.second - it.first == -2 -> 6
                            it.second - it.first == 0 -> 3
                            else -> 0
                        })
            }
    }

    fun part2(input: List<String>): Int {
        return getGames(input)
            .map { (it.first - 'A' + 1) to ((it.second - 'X') * 3) }
            .sumOf {
                it.second +
                        (when (it.second) {
                            6 -> if (it.first + 1 > 3) 1 else it.first + 1
                            3 -> it.first
                            else -> if (it.first - 1 == 0) 3 else it.first - 1
                        })
            }
    }

    val input = readInput("_2022/day2")
    println(part1(input))
    println(part2(input))
}
