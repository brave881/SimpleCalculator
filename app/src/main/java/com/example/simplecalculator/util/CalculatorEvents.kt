package com.example.simplecalculator.util

import com.example.simplecalculator.domain.Operators

sealed interface CalculatorEvents {
    data class Number(val number: Int) : CalculatorEvents
    data class Operation(val operators: Operators) : CalculatorEvents
    object Parenthesis : CalculatorEvents
    object PI : CalculatorEvents
    object Sqrt : CalculatorEvents
    object Factorial : CalculatorEvents
    object Clear : CalculatorEvents
    object ClearAll : CalculatorEvents
    object Decimal : CalculatorEvents
    object Evaluate : CalculatorEvents

}
