package com.leonov.calculate

import androidx.compose.runtime.mutableStateOf

class CalculatorViewModel {
    val state = mutableStateOf(
        Display(
            expression= "46x8",
            result= "360"
        )
    )
    fun processUserInput(input: String) {
        when(input) {
            "AC" ->state.value = Display("", "")
        }
    }
}
data class Display(
    var expression: String,
    var result: String
)