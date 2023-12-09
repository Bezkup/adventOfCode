package main.kotlin._2022

import readInput

fun main(){

    fun part1(input: List<String>): Int {
        var count = 0
        input.forEach {
            val sectors = it.split(",")
            val range1 = sectors[0].split("-")
            val range2 = sectors[1].split("-")
            if ((range1[0].toInt() >= range2[0].toInt() && range1[1].toInt() <= range2[1].toInt())
                || (range2[0].toInt() >= range1[0].toInt() && range2[1].toInt() <= range1[1].toInt())) {
                count += 1
            }
        }
        return count
    }

    fun part2(input: List<String>) : Int {
        return input.map {
                val sectors = it.split(",")
                val range1 = sectors[0].split("-")
                val range2 = sectors[1].split("-")
                range1[0].toInt()..range1[1].toInt() to range2[0].toInt()..range2[1].toInt()
            }
            .map { it.first.toSet() to it.second.toSet() }
            .count { it.first.intersect(it.second).isNotEmpty() }
    }

    val input = readInput("_2022/day4")
    val inputTest = readInput("test")
//    check(part1(inputTest) == 2)
    println(part1(input))
    println(part2(input))
}