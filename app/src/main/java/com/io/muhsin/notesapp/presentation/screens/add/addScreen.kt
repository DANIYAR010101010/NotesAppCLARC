package com.io.muhsin.notesapp.presentation.screens.add

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import java.lang.reflect.Modifier


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AddScreen(
    navController: NavController
) {
    val viewModel = hiltViewModel<AddViewModel>()
    var title by rememberSaveable { mutableStateOf("") }
    var description by rememberSaveable { mutableStateOf("") }

    Scaffold(
        topBar = {
            Row(
                verticalAlignment = LineHeightStyle.Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(top = 52.dp)
                    .fillMaxWidth()
                    .height(48.dp)
                    .padding(horizontal = 24.dp)
            ) {
                Box(
                    modifier = Modifier
                        .width(48.dp)
                        .height(48.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .background(Color(0xFF3B3B3B))
                        .clickable { navController.popBackStack() }
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        tint = Color.White,
                        contentDescription = "nav back",
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
                Box(
                    modifier = Modifier
                        .width(48.dp)
                        .height(48.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .background(Color(0xFF3B3B3B))
                        .clickable {
                            val color: Int = Color(
                                Random().nextInt(256),
                                Random().nextInt(256),
                                Random().nextInt(256),
                            ).toArgb()
                            viewModel.addNote(
                                Note(
                                    title = title,
                                    content = description,
                                    backgroundColor = color
                                )
                            ) {
                                navController.navigate(Screens.MainScreen.rout)
                            }
                        }
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Add,
                        tint = Color.White,
                        contentDescription = "add note",
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                value = title,
                onValueChange = { title = it },
                label = { Text(text = "Title") }
            )
            TextField(
                value = description,
                onValueChange = { description = it },
                label = { Text(text = "Description") },
                modifier = Modifier.padding(top = 24.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewAddScreen() {
    MyNotesTheme {
        AddScreen(rememberNavController())
    }
}