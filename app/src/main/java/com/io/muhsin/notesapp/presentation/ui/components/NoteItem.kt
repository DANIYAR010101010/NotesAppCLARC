package com.io.muhsin.notesapp.presentation.ui.components

import android.text.Layout
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.lang.reflect.Modifier


@Composable
fun NoteItem(title: String, backgroundColor: Color, modifier: Modifier) {
    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(backgroundColor)
        ) {
            Text(
                text = title,
                fontSize = 25.sp,
                color = Color(0xFF303030),
                modifier = Modifier
                    .align(Layout.Alignment.Center)
                    .padding(vertical = 22.dp)
                    .padding(horizontal = 45.dp)
            )
        }
    }
}