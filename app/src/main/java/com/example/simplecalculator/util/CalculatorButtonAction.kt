package com.example.simplecalculator.domain

import com.example.simplecalculator.util.CalculatorEvents

data class CalculatorButtonAction(
    val action: String,
    val type: CalculatorButtonType,
    val onPress: CalculatorEvents
)
