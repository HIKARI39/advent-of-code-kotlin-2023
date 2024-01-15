package day1

import readInput

fun main() {
    val day01 = Day01(readInput("Day01_exam"))
    println(day01.part1())
//    println(Day01Part2().part2())



}

class Day01(private val input: List<String>) {
    fun part1(): Int = input.sumOf {
        calibrationValue(it)
    }

    private fun calibrationValue(row: String): Int {
        val firstDigit = row.first() { it.isDigit() }.digitToInt()
        val lastDigit = row.last() { it.isDigit() }.digitToInt()
        return "$firstDigit$lastDigit".toInt()
    }
}
class Day01Part2{
    fun part2(){
        val lines = readInput("Day01_exam")
        println(lines.sumOf { line: String ->
            getNumber(line, words) * 10 + getNumber(line.reversed(), rewords)
        })
    }

    //part2
    private val words = listOf("one","two","three","four","five","six","seven","eight","nine","ten")
    private val rewords = words.map { it.reversed() }
    val digit = List(10){ "$it" }
    enum class startFrom{BEGINIG, END}
    private fun getNumber(line:String, words:List<String>):Int {
        val (wordIdx,word) = line.findAnyOf(words) ?: (Int.MAX_VALUE to "not found")
        val (digitIdx,digit) = line.findAnyOf(digit) ?: (Int.MAX_VALUE to "not found")

        return if (digitIdx < wordIdx) {
            digit.toInt()
        } else {
            word.digitWordToInt(words)
        }
    }

    private fun String.digitWordToInt(wordList:List<String> = words):Int {
        val index = wordList.indexOf(this)
        if (index == -1) error("$this is not a digit word!")
        return index  + 1

    }


//    fun part2(input: List<String>): Int {
//        return input.size
//    }



//    val input = readInput("Day01_exam.txt")
//    part1(input).println()
//    part2(input).println()

}