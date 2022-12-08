package main.kotlin

import readInput

fun main(){

    fun part1(input: List<String>): Int {
        var count = 0
        input.forEach{
            x -> run {
                val sectors = x.split(",")
                val range1 = sectors[0].split("-")
                val range2 = sectors[1].split("-")
                if ((range1[0].toInt() >= range2[0].toInt() && range1[1].toInt() <= range2[1].toInt())
                    || (range2[0].toInt() >= range1[0].toInt() && range2[1].toInt() <= range1[1].toInt())) {
                    count += 1
                }
            }
        }
        return count
    }

    val input = readInput("day4")
    val inputTest = readInput("test")
    check(part1(inputTest) == 2)
    println(part1(input))
//    println(part2(input))
}