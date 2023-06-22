package com.example.simplecalculator.main.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    symbol: String,
    textStyle: TextStyle = TextStyle(),
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(36))
            .clickable {
                onClick()
            }
            .then(modifier),
    ) {
        Text(
            text = symbol,
            style = textStyle,
            fontSize = 36.sp,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.onPrimary
        )
    }


}


@Preview(
    showBackground = true
)
@Composable
fun PrimaryButtonPreview() {

}
