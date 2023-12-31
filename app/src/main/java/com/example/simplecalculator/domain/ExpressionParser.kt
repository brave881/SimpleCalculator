package com.example.simplecalculator.domain

import com.example.simplecalculator.domain.Expression
import com.example.simplecalculator.domain.ParenthesisType


class ExpressionParser {

    private val numbers = "1234567890."

    fun parse(expression: String): List<Expression> {
        val result = mutableListOf<Expression>()
        var i = 0
        while (i < expression.length) {
            when (val currentChar = expression[i]) {
                in Operators.allOperatorSymbols -> result.add(parseOperator(currentChar))
                in numbers -> {
                    val pair = parseNumbers(i, expression)
                    i = pair.first
                    result.add(pair.second)
                    continue
                }

                MathsSymbols.PI_SYMBOL -> result.addAll(processPi(expression))

                MathsSymbols.FACTORIAL_SYMBOL -> {
                    val last = result.last()
                    result.remove(last)
                    result.add(parseFactorial(expression, last))
                }

                MathsSymbols.SQRT_SYMBOL -> {
                    val last = result.lastOrNull()
                    val pair = parseSqrt(expression, i + 1)
                    if (last is Expression.Number) result.add(Expression.Operation(Operators.MULTIPLY))
                    result.add(pair.second)
                    i = pair.first
                    continue
                }

                in "()" -> result.add(parseParenthesis(currentChar))
            }
            i++
        }
        return result
    }

    private fun processPi(expression: String): List<Expression> {
        val isLast = expression.lastOrNull() == MathsSymbols.PI_SYMBOL
        val isFirst = expression.firstOrNull() == MathsSymbols.PI_SYMBOL
        return buildList {
            if (isFirst) add(Expression.Number(1.0))
            add(Expression.PI)
            if (isLast) add(Expression.Number(1.0))
        }
    }

    private fun parseSqrt(expression: String, nextIdx: Int): Pair<Int, Expression.Sqrt> {
        if (expression.last() == MathsSymbols.SQRT_SYMBOL) throw IllegalArgumentException("Format Error")
        val number = parseNumbers(nextIdx, expression)
        return Pair(number.first, Expression.Sqrt(number.second.number))
    }

    private fun parseFactorial(expression: String, last: Expression): Expression.Factorial {
        if (expression.first() == MathsSymbols.FACTORIAL_SYMBOL) throw IllegalArgumentException("Format Error")
        if (last !is Expression.Number) throw IllegalArgumentException("Invalid format")
        return Expression.Factorial(last.number)
    }

    private fun parseNumbers(begin: Int, expression: String): Pair<Int, Expression.Number> {
        var start = begin
        val strNumber = buildString {
            while (start < expression.length && expression[start] in numbers) {
                append(expression[start])
                start++
            }
        }
        val strNumberIntoDouble = strNumber.toDouble()
        return Pair(start, Expression.Number(strNumberIntoDouble))
    }

    private fun parseOperator(currentChar: Char): Expression.Operation =
        Expression.Operation(Operators.operatorFromSymbol(currentChar))


    private fun parseParenthesis(currentChar: Char): Expression.Parenthesis =
        Expression.Parenthesis(
            type = when (currentChar) {
                MathsSymbols.PARENTHESIS_OPEN -> ParenthesisType.Opening
                MathsSymbols.PARENTHESIS_CLOSE -> ParenthesisType.Closing
                else -> throw IllegalArgumentException("Invalid parenthesis type")
            }
        )

}
