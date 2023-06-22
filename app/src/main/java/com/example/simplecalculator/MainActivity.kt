package com.example.simplecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.simplecalculator.domain.Operators
import com.example.simplecalculator.main.components.PrimaryButton
import com.example.simplecalculator.ui.theme.SimpleCalculatorTheme
import com.example.simplecalculator.ui.theme.orange
import com.example.simplecalculator.util.CalculatorEvents

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleCalculatorTheme {
                val viewModel by viewModels<CalculatorViewModel>()
                val expression by viewModel.expression.collectAsStateWithLifecycle()
                val result by viewModel.result.collectAsStateWithLifecycle()
                Extracted(viewModel, expression, result)
            }
        }
    }

    @Composable
    private fun Extracted(
        viewModel: CalculatorViewModel, expression: String, result: String
    ) {
        val buttonSpec = 8.dp
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.background)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .align(Alignment.BottomCenter),
                verticalArrangement = Arrangement.spacedBy(buttonSpec)
            ) {

                CalculatorResultDisplay(
                    expression = expression,
                    result = result,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .clip(RoundedCornerShape(bottomEnd = 25.dp, bottomStart = 25.dp))

                )

////////////////////////////////////////////////////////////////////////////////////////////
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpec)
                ) {
                    PrimaryButton(
                        symbol = "Ac",
                        modifier = Modifier
                            .weight(2f)
                            .aspectRatio(2f)
                            .background(orange)
                    ) {
                        viewModel.onCalculatorEvent(CalculatorEvents.ClearAll)
                    }
                    PrimaryButton(
                        symbol = "del",
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f).background(orange)
                    ) {
                        viewModel.onCalculatorEvent(CalculatorEvents.Clear)
                    }

                    PrimaryButton(
                        symbol = "/",
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f).background(orange)

                    ) {
                        viewModel.onCalculatorEvent(CalculatorEvents.Operation(Operators.DIVIDE))

                    }

                }
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpec)
                ) {
                    PrimaryButton(
                        symbol = "7",
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f).background(MaterialTheme.colors.surface)
                    ) {
                        viewModel.onCalculatorEvent(CalculatorEvents.Number(7))
                    }
                    PrimaryButton(
                        symbol = "8",
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f).background(MaterialTheme.colors.surface)
                    ) {
                        viewModel.onCalculatorEvent(CalculatorEvents.Number(8))
                    }

                    PrimaryButton(
                        symbol = "9",
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f).background(MaterialTheme.colors.surface)
                    ) {
                        viewModel.onCalculatorEvent(CalculatorEvents.Number(9))
                    }
                    PrimaryButton(
                        symbol = "x",
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f).background(orange)
                    ) {
                        viewModel.onCalculatorEvent(CalculatorEvents.Operation(Operators.MULTIPLY))
                    }

                }


//--------------------------------------------------------------------------------
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpec)
                ) {
                    PrimaryButton(
                        symbol = "4",
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f).background(MaterialTheme.colors.surface)
                    ) {
                        viewModel.onCalculatorEvent(CalculatorEvents.Number(4))
                    }
                    PrimaryButton(
                        symbol = "5",
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f).background(MaterialTheme.colors.surface)
                    ) {
                        viewModel.onCalculatorEvent(CalculatorEvents.Number(5))
                    }

                    PrimaryButton(
                        symbol = "6",
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f).background(MaterialTheme.colors.surface)
                    ) {
                        viewModel.onCalculatorEvent(CalculatorEvents.Number(6))
                    }
                    PrimaryButton(
                        symbol = "-",
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f).background(orange)
                    ) {
                        viewModel.onCalculatorEvent(CalculatorEvents.Operation(Operators.SUBTRACT))
                    }

                }


//////////////////////////++++++++++++++++++++++++++++++++++++++++++++++++++++++
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpec)
                ) {
                    PrimaryButton(
                        symbol = "1",
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f).background(MaterialTheme.colors.surface)
                    ) {
                        viewModel.onCalculatorEvent(CalculatorEvents.Number(1))
                    }
                    PrimaryButton(
                        symbol = "2",
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f).background(MaterialTheme.colors.surface)
                    ) {
                        viewModel.onCalculatorEvent(CalculatorEvents.Number(2))
                    }

                    PrimaryButton(
                        symbol = "3",
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f).background(MaterialTheme.colors.surface)
                    ) {
                        viewModel.onCalculatorEvent(CalculatorEvents.Number(3))
                    }
                    PrimaryButton(
                        symbol = "+",
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f).background(orange)
                    ) {
                        viewModel.onCalculatorEvent(CalculatorEvents.Operation(Operators.ADD))

                    }

                }


//===================================================================================
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpec)
                ) {
                    PrimaryButton(
                        symbol = "0",
                        modifier = Modifier
                            .weight(2f)
                            .aspectRatio(2f).background(MaterialTheme.colors.surface)
                    ) {
                        viewModel.onCalculatorEvent(CalculatorEvents.Number(0))

                    }


                    PrimaryButton(
                        symbol = ".",
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f).background(MaterialTheme.colors.surface)
                    ) {
                        viewModel.onCalculatorEvent(CalculatorEvents.Decimal)

                    }
                    PrimaryButton(
                        symbol = "=",
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f).background(orange)
                    ) {
                        viewModel.onCalculatorEvent(CalculatorEvents.Evaluate)

                    }

                }


            }
        }
    }
}
