package day2

import readInput

fun main() {
    Day02().part1(readInput("day2/Day02_test"))


}


    data class Set(val red:Int, val green:Int, val blue:Int)
    data class  Game(val id: Int,val sets: List<Triple<Int,Int,Int>>)

class Day02{
    fun parse(input:List<String>) = input.map {
        val (game, sets) = it.split(":")
        val id = "Game (\\d+)".toRegex().find(game)!!.groupValues[1].toInt()
        sets.split(";").map {
            val red = "(\\d+) red".toRegex().find(it)?.groupValues?.get(1)?.toInt() ?: 0
            val blue = "(\\d+) blue".toRegex().find(it)?.groupValues?.get(1)?.toInt() ?: 0
            val green = "(\\d+) green".toRegex().find(it)?.groupValues?.get(1)?.toInt() ?: 0
            Triple(red,green,blue)
//            Set(red,green,blue)
        }.let { triples ->
            Game(id,triples)
        }
    }


    fun part1(input: List<String>):Int{
        val expectedRed = 12
        val expectedGreen = 13
        val expectedBlue = 14
        return parse(input).filter {
            it.sets.none { it.first > expectedRed || it.second > expectedGreen || it.third > expectedBlue }
        }.sumOf{ it.id }



    }

}