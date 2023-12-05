package main.kotlin._2022

import readInput
import java.util.stream.IntStream

fun main(){

    fun part1(input : List<String>) : Int {
        val listOfChars = mutableListOf<Char>()
        var count = 0
        input.forEach {
            x -> run {
                listOfChars.clear()
                val stringSplitted : List<String> = x.chunked(x.length/2)
                stringSplitted[0].forEach {
                    y -> if(stringSplitted[1].contains(y) && !listOfChars.contains(y)) {
                        count +=
                            if (y.code <= 90) y.code - 38
                            else y.code - 96
                        listOfChars.add(y)
                    }
                }
            }
        }
        return count
    }

    fun part2(input : List<String>) : Int{
        var count = 0
        val listOfChars = mutableListOf<Char>()
        IntStream.range(0, input.size / 3).map{x -> x * 3}.forEach{
            listOfChars.clear()
            input[it].forEach {
                y -> if (input[it+1].contains(y) && input[it+2].contains(y) && !listOfChars.contains(y)){
                    count +=
                        if (y.code <= 90) y.code - 38
                        else y.code - 96
                    listOfChars.add(y)
                }
            }
        }
        return count
    }

    val input = readInput("day3")
    println(part1(input))
    println(part2(input))
}