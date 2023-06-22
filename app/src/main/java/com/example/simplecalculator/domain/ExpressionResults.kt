package com.example.simplecalculator.domain

import com.example.simplecalculator.domain.Expression

data class ExpressionResult(
    val remaining: List<Expression>,
    val value: Double
)
