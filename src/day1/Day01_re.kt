package day1
import readInput

fun main() {
    print(Day01_re(readInput("Day01_test")).part1())
}
class Day01_re(private val input: List<String> ){
    fun part1(): Int = input.sumOf{
        calibrationValue(it)
    }
    private fun calibrationValue(row: String):Int{
        val firstDigit = row.first(){it.isDigit()}.digitToInt()
        val secondDigit = row.last(){it.isDigit()}.digitToInt()
        return firstDigit*10 + secondDigit

    }
}