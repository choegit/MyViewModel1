package com.example.myviewmodel1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CounterScreen()
        }
    }
}

@Composable
fun CounterScreen(
    viewModel: CounterViewModel = viewModel()
) {
    val counter by viewModel.counter.observeAsState(initial = 0)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = counter.toString(), style = MaterialTheme.typography.headlineLarge)

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { viewModel.increment() }) {
            Text("Increment")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { viewModel.decrement() }) {
            Text("Decrement")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { viewModel.reset() }) {
            Text("Reset")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun CounterScreenPreview() {
    CounterScreen()
}
