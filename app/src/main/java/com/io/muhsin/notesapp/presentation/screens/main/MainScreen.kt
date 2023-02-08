package com.io.muhsin.notesapp.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.io.muhsin.notesapp.domain.model.Note
import com.io.muhsin.notesapp.presentation.ui.theme.NotesAppTheme
import java.lang.reflect.Modifier

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController) {
    val notes= viewModel.notes.observeAsState(listOf()).value
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.Add, tint = Color.White, contentDescription = "add")
            }
        }
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = "Notes",
                fontSize = 42.sp,
                modifier = Modifier
                    .padding(top = 43.dp, start = 24.dp, bottom = 12.dp)
            )

            notes.forEach { note ->
                NoteItem(
                    title = note.title,
                    backgroundColor = Color(note.backgroundColor),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp)
                        .padding(horizontal = 24.dp)
                        .clickable { navController.navigate(Screens.DetailsScreen.rout + "/${note.id}") }
                )
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun previewMainScreen() {
    NotesAppTheme {
        MainScreen()
    }
}