package com.example.myviewmodel1

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.*
import org.junit.Rule
import org.junit.Test

class CounterScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun counterScreen_incrementButton_updatesCounter() {
        composeTestRule.setContent {
            CounterScreen()
        }

        composeTestRule.onNodeWithText("0").assertExists()

        composeTestRule.onNodeWithText("Increment").performClick()

        composeTestRule.onNodeWithText("1").assertExists()
    }

    @Test
    fun counterScreen_decrementButton_updatesCounter() {
        composeTestRule.setContent {
            CounterScreen()
        }

        // Click Decrement button
        composeTestRule.onNodeWithText("Decrement").performClick()

        // Now counter should show -1
        composeTestRule.onNodeWithText("-1").assertExists()
    }

    @Test
    fun counterScreen_resetButton_setsCounterToZero() {
        composeTestRule.setContent {
            CounterScreen()
        }

        // First increment
        composeTestRule.onNodeWithText("Increment").performClick()
        composeTestRule.onNodeWithText("1").assertExists()

        // Then reset
        composeTestRule.onNodeWithText("Reset").performClick()
        composeTestRule.onNodeWithText("0").assertExists()
    }
}