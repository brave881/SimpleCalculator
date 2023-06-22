package com.example.simplecalculator.domain

sealed interface CalculatorButtonType {
    object Operator : CalculatorButtonType
    object Operand : CalculatorButtonType
    object Functions : CalculatorButtonType
    object ExtraFunction : CalculatorButtonType
}
