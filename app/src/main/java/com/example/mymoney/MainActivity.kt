package com.example.mymoney

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
import androidx.room.Room
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.mymoney.ui.theme.MyMoneyTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.UUID

class MainActivity : ComponentActivity() {

    lateinit var database: DB


    override fun onCreate(savedInstanceState: Bundle?) {

        database = DB.getDB(this)

        GlobalScope.launch {
            database.expenseDao().insertExpense(Expense(UUID.randomUUID(), "Title", 100))
        }


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyMoneyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyMoneyTheme {
        Greeting("Android")
    }
}