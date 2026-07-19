package com.leonov.calculate

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.random.Random

class CalculatorViewModel: ViewModel() {
    private val _state: MutableStateFlow<CalculatorState> = MutableStateFlow(
        CalculatorState.Initial
    )
    val state = _state.asStateFlow()
    private var expression = ""

    fun processCommand(command: CalculatorCommand) {
        Log.d("CalculatorViewModel","Command: $command")
        when(command) {
            CalculatorCommand.Clear -> {
                expression = ""
                _state.value = CalculatorState.Initial
            }
            CalculatorCommand.Evaluate -> {
                val isError = Random.nextBoolean()
                _state.value = if(isError) {
                    CalculatorState.Error("100/0")
                } else {
                    CalculatorState.Success("100")
                }
            }
            is CalculatorCommand.Input -> {
                val symbol= if(command.symbol != Symbol.PARENTHESIS) {
                    command.symbol.value
                } else {
                    getCorrectParenthesis()
                }
                expression += symbol

                _state.value = CalculatorState.Input(
                    expension = expression,
                    result = "100"
                )
            }
        }
    }
    private fun getCorrectParenthesis(): String {
        val openCount = expression.count{it == '('}
        val closeCount = expression.count{it == ')'}

        return when {
            expression.isEmpty() -> "("
            expression.last().let { !it.isDigit() && it != ')' && it != 'π'} -> "("
            openCount > closeCount -> ")"
            else -> "("
        }
    }
}
sealed interface CalculatorState {
    data object Initial: CalculatorState

    data class Input(
        val expension: String,
        val result: String
    ): CalculatorState

    data class Success(
        val result: String
    ): CalculatorState

    data class Error(val expression: String): CalculatorState
}
sealed interface CalculatorCommand {
    data object Clear: CalculatorCommand
    data object Evaluate: CalculatorCommand
    data class Input(val symbol: Symbol): CalculatorCommand
}

enum class Symbol(val value: String) {
    DIGIT_0("0"),
    DIGIT_1("1"),
    DIGIT_2("2"),
    DIGIT_3("3"),
    DIGIT_4("4"),
    DIGIT_5("5"),
    DIGIT_6("6"),
    DIGIT_7("7"),
    DIGIT_8("8") ,
    DIGIT_9("9")     ,
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    PERCENT("%"),
    POWER("^"),
    FACTORIAL("!"),
    SQRT("√"),
    PI("π") ,
    DOT("."),
    PARENTHESIS("()"),
}
data class Display(
    var expression: String,
    var result: String
)