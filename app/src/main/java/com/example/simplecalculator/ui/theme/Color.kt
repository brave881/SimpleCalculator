package com.example.simplecalculator.ui.theme

import androidx.compose.ui.graphics.Color


val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val clear_dark = Color(0xFFA05162)
val dark_btn = Color(0xFF222427)
val color3 = Color(0xFF17818A)
val green = Color(0xFF19C37D)
val orange = Color(0xFFD19018)

val light_btn = Color(android.graphics.Color.parseColor("#E9F0F4"))
val light_bg = Color(android.graphics.Color.parseColor("#F6F8F9"))
val clear_light = Color(0xFFF1C8D1)

sealed class ThemeColors(
    val bacground: Color,
    val surafce: Color,
    val primary: Color,
    val text: Color
)  {
    object Night: ThemeColors(
        bacground = Color.Black,
        surafce = dark_btn,
        primary = clear_dark,
        text = Color.White
    )
    object Day: ThemeColors(
        bacground = light_bg,
        surafce = light_btn,
        primary = clear_light,
        text = Color.Black
    )
}
