package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    StudentListScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

val students = listOf(
    "Alice", "Bob", "Charlie", "Dana", "Eric",
    "Fatima", "Grace", "Hiro", "Isabel", "Jack",
    "Karen", "Luis", "Maya", "Nate", "Olivia",
    "Priya", "Quinn", "Ravi", "Sara", "Tom"
)
@Composable
fun StudentListScreen(modifier: Modifier = Modifier) {
    LazyColumn(modifier =  modifier.padding(horizontal = 16.dp)) {
        items(students) { student ->
            StudentCard(name = student)
        }
    }
}

@Composable
fun StudentCard(name: String) {
    Card(
        modifier = Modifier
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Text(
            text = name,
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}