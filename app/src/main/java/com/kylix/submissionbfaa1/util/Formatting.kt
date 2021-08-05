package com.kylix.submissionbfaa1.util

object Formatting {

    fun shortenNumber(value: String): String {

        var result = ""
        if (value.length > 3) {
            val separatedValue = value.toCharArray()
            val length = value.length

            if (length >= 4 || length <= 6) {
                val decimal = separatedValue[length - 3]
                val nonDecimalLength = length - 4

                for (index in 0..(nonDecimalLength)) {
                    result = String.format("$result${separatedValue[index]}")
                }

                result = String.format("$result.${decimal}K")
            }

        } else {
            result = String.format(value)
        }
        return result
    }
}