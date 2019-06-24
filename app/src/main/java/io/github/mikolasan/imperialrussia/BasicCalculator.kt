package io.github.mikolasan.imperialrussia

import java.lang.RuntimeException

/*
 It does addition, subtraction, multiplication, division
 and it gets the operator precedence and associativity rules correct.

 https://stackoverflow.com/questions/3422673/how-to-evaluate-a-math-expression-given-in-string-form
 */

class BasicCalculator(val expression: String) {
    var char: Char? = null
    var pos = -1
    fun eval(): Double {
        return parse()
    }


    fun nextChar() {
        char = expression.elementAtOrNull(++pos)
    }

    fun eat(charToEat: Char): Boolean {
        while (char == ' ') nextChar()
        return when (char) {
            charToEat -> {
                nextChar()
                true
            }
            else -> false
        }
    }

    fun parse(): Double{
        nextChar()
        return parseExpression() ?: throw RuntimeException("Unexpected ${char}")
    }

    // Grammar:
    // expression = term | expression `+` term | expression `-` term
    // term = factor | term `*` factor | term `/` factor
    // factor = `+` factor | `-` factor | `(` expression `)`
    //        | number | functionName factor | factor `^` factor

    fun parseExpression(): Double {
        var x = parseTerm()
        while (true) {
            when {
                eat('+') -> x += parseTerm()
                eat('-') -> x -= parseTerm()
                else -> return x
            }
        }
    }

    fun parseTerm(): Double {
        var x = parseFactor()
        while (true) {
            when {
                eat('*') -> x *= parseFactor()
                eat('/') -> x /= parseFactor()
                else -> return x
            }
        }
    }

    fun parseFactor(): Double {
        if (eat('+')) return parseFactor()
        if (eat('-')) return parseFactor()
        val startPos = pos
        var x = .0
        while (char in '0'..'9' || char == '.') {
            nextChar()
            x = expression.substring(startPos, pos).toDouble()
        }

        return x
    }
}