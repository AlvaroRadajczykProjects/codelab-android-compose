package com.example.compose.rally

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SelectTopAppBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup() {
        composeTestRule.setContent {
            RallyApp()
        }
    }

    @Test
    fun canGoToAccounts() {

        //composeTestRule.onRoot(useUnmergedTree=true).printToLog("currentLabelExists")

        /*composeTestRule
            .onNode(
                hasContentDescription(RallyScreen.Overview.name) and
                        hasClickAction(),
                useUnmergedTree = true
            )
            .assertExists()*/

        composeTestRule
            .onNode(
                hasContentDescription(RallyScreen.Accounts.name) and
                        hasClickAction(),
                useUnmergedTree = true
            )
            .performClick()

        composeTestRule
            .onNodeWithContentDescription(RallyScreen.Accounts.name)
            .assertIsDisplayed()

    }

    @Test
    fun canGoToBills() {

        composeTestRule
            .onNode(
                hasContentDescription(RallyScreen.Bills.name) and
                        hasClickAction(),
                useUnmergedTree = true
            )
            .performClick()

        composeTestRule
            .onNodeWithContentDescription(RallyScreen.Accounts.name)
            .assertIsDisplayed()

    }

}