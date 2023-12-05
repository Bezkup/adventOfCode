package main.kotlin._2022

import readInput

fun main() {
    fun part1(input : List<String>) : Int {
        val listOfCaloriesElf = mutableListOf<Int>()
        var countCalories = 0
        input.iterator().forEach {
            x -> if (x != "") {countCalories += Integer.parseInt(x)} else {listOfCaloriesElf.add(countCalories); countCalories = 0}
        }
        return listOfCaloriesElf.max()
    }

    fun part2(input : List<String>) : Int {
        val listOfCaloriesElf = mutableListOf<Int>()
        var countCalories = 0
        input.forEach {
                x -> if (x != "") {countCalories += Integer.parseInt(x) } else { listOfCaloriesElf.add(countCalories); countCalories = 0 }
        }
        var firstElf = 0
        var secondElf = 0
        var thirdElf = 0
        listOfCaloriesElf.forEach {
            x -> run {
                if (x > firstElf)
                    firstElf = x
                else if (x > secondElf)
                    secondElf = x
                else if (x > thirdElf)
                    thirdElf = x
            }
        }
        return firstElf + secondElf + thirdElf
    }

    val input = readInput("day1")
    println(part1(input))
    println(part2(input))
}