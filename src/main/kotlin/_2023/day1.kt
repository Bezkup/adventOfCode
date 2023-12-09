package main.kotlin._2023

import readInput

fun main() {
    val map = (1..9).associateBy { it.toString() } + mapOf(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4,
        "five" to 5,
        "six" to 6,
        "seven" to 7,
        "eight" to 8,
        "nine" to 9,
    )
    fun part1(input : List<String>) : Int {
        var total = 0
        var num1 = ""
        var num2 = ""

        input.forEach {
            for (i in 0..it.length) {
                if (it[i].isDigit()) {
                    num1 = it[i].toString()
                    break
                }
            }
            for (i in it.length-1 downTo 0) {
                if (it[i].isDigit()) {
                    num2 = it[i].toString()
                    break
                }
            }
            total += "$num1$num2".toInt()
        }
        return total
    }

    fun part2(input : List<String>) : Int {
        return input.sumOf{ row ->

            val (_, firstDigit) = map
                .map { (key, value) -> row.indexOf(key) to value }
                .filter { (key) -> key != -1 }
                .minBy { (key) -> key }

            val (_, lastDigit) = map
                .map { (key, value) -> row.lastIndexOf(key) to value }
                .filter { (key) -> key != -1 }
                .maxBy { (key) -> key }

            "$firstDigit$lastDigit".toInt()
        }
    }

    val input = readInput("_2023/day1")
    println(part1(input))
    println(part2(input))
}