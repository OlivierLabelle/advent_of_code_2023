package day0to9

import println
import readInput

fun main() {
    fun part1(input: List<String>): Int {
        var totalCalibration = 0
        input.forEach{
            val digits = it.replace("[a-z]".toRegex(), "")
            val numberToAdd = (digits.first().toString() + digits.last().toString()).toInt()
            totalCalibration += numberToAdd
        }
        return totalCalibration
    }

    fun part2(input: List<String>) = input.sumOf {
        val firstNumberDigitOrLetterRegex = ".*?(\\d|one|two|three|four|five|six|seven|eight|nine).*".toRegex()
        val lastNumberDigitOrLetterRegex = ".*(\\d|one|two|three|four|five|six|seven|eight|nine).*".toRegex()
        val first = firstNumberDigitOrLetterRegex.find(it)?.groupValues?.get(1) ?: return@sumOf 0
        val last = lastNumberDigitOrLetterRegex.find(it)?.groupValues?.get(1) ?: return@sumOf 0
        "${first.toNumber()}${last.toNumber()}".toLong()
    }

    val input = readInput("Day01", "day0to9")
    part1(input).println()
    part2(input).println()
}

fun String.toNumber() = toIntOrNull() ?: when (this) {
    "one" -> 1
    "two" -> 2
    "three" -> 3
    "four" -> 4
    "five" -> 5
    "six" -> 6
    "seven" -> 7
    "eight" -> 8
    else -> 9
}
