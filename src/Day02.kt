fun main() {
    fun part1(input: List<String>): Int {
        var gameId = 1
        var total = 0
        val possibleRedCube = 12
        val possibleGreenCube = 13
        val possibleBlueCube = 14
        input.forEach { input ->

            var redChecker = 0
            var greenChecker = 0
            var blueChecker = 0

            val pattern = "\\s+".toRegex()
            val cleanedList = input.replace(":".toRegex(), "").replace(",".toRegex(), "").replace(";".toRegex(), "")
            val stringOnly = cleanedList.replace("[0-9]".toRegex(), " ")
            val ssss = pattern.split(stringOnly)
            val digitOnly = cleanedList.replace("[a-z, A-Z]".toRegex(), " ")
            val dddd = pattern.split(digitOnly).drop(1)
            val pairedList = ssss.zip(dddd)
            pairedList.forEach {
                val (key, value) = it
                when (key) {
                    "red" -> {
                        if (value.toInt() > possibleRedCube) {
                            redChecker += 1
                        }
                    }

                    "green" -> {
                        if (value.toInt() > possibleGreenCube) {
                            greenChecker += 1
                        }
                    }

                    "blue" -> {
                        if (value.toInt() > possibleBlueCube) {
                            blueChecker += 1
                        }
                    }
                    "Game" -> {
                        gameId = value.toInt()
                    }
                }
            }
            if (redChecker == 0 && greenChecker == 0 && blueChecker == 0) {
                println("$total $gameId")
                total += gameId
            }
        }
        return total
    }


    fun part2(input: List<String>): Int {
        var total = 0
        input.forEach { input ->

            var redChecker = 0
            var greenChecker = 0
            var blueChecker = 0

            val pattern = "\\s+".toRegex()
            val cleanedList = input.replace(":".toRegex(), "").replace(",".toRegex(), "").replace(";".toRegex(), "")
            val stringOnly = cleanedList.replace("[0-9]".toRegex(), " ")
            val ssss = pattern.split(stringOnly)
            val digitOnly = cleanedList.replace("[a-z, A-Z]".toRegex(), " ")
            val dddd = pattern.split(digitOnly).drop(1)
            val pairedList = ssss.zip(dddd)
            pairedList.forEach {
                val (key, value) = it
                when (key) {
                    "red" -> {
                        if (value.toInt() > redChecker) {
                            redChecker = value.toInt()
                        }
                    }

                    "green" -> {
                        if (value.toInt() > greenChecker) {
                            greenChecker = value.toInt()
                        }
                    }

                    "blue" -> {
                        if (value.toInt() > blueChecker) {
                            blueChecker = value.toInt()
                        }
                    }
                }
            }
            total += (redChecker * greenChecker * blueChecker)
        }
        return total
    }


    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
