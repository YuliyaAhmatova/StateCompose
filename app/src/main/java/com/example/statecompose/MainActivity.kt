package com.example.statecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isClick by rememberSaveable {
                mutableStateOf(false)
            }

            val listRus = listOf("Бананы", "Яйца", "Курица", "Творог", "Йогурт", "Огурцы")
            val listUSA = listOf("Banana", "Eggs", "Chicken", "Curd", "Yogurt", "Cucumbers")
            var list = rememberSaveable { mutableStateOf(listRus) }

            val titleRus = "Список продуктов"
            val titleUSA = "List of products"
            var title = rememberSaveable { mutableStateOf(titleRus) }

            val langRus = "Switch language"
            val langUSA = "Переключить язык"
            var lang = rememberSaveable { mutableStateOf(langRus) }

            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.DarkGray)
                        .padding(8.dp),
                    text = title.value,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
                LazyColumn(
                    contentPadding = PaddingValues(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .background(Color.LightGray)
                        .padding(4.dp)
                ) {
                    items(list.value) { item ->
                        Text(
                            modifier = Modifier
                                .padding(2.dp)
                                .fillMaxWidth()
                                .background(Color.White, shape = CircleShape),
                            textAlign = TextAlign.Center,
                            text = item,
                            fontSize = 22.sp
                        )
                    }
                }
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable {
                            isClick = !isClick
                        },
                    text = lang.value,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                if (isClick) {
                    list.value = listUSA
                    title.value = titleUSA
                    lang.value = langUSA
                } else {
                    list.value = listRus
                    title.value = titleRus
                    lang.value = langRus
                }
            }
        }
    }
}