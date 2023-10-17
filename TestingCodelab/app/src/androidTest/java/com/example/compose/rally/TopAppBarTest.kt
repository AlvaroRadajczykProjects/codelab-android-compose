package com.example.compose.rally

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsSelectable
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.hasParent
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import com.example.compose.rally.ui.components.RallyTopAppBar
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TopAppBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    //val composeTestRule = createAndroidComposeRule(RallyActivity::class.java)

    @Before
    fun init(){
        val allScreens = RallyScreen.entries //RallyScreen.values().toList()

        composeTestRule.setContent {
            RallyTopAppBar(
                allScreens = allScreens,
                onTabSelected = {},
                currentScreen = RallyScreen.Accounts
            )
        }
    }

    @After
    fun tearDown() {

    }

    @Test
    fun myTest() {
        //Thread.sleep(5000)
        composeTestRule
            .onNodeWithContentDescription(RallyScreen.Accounts.name)
            .assertIsSelected()
    }

    @Test
    fun accountsButtonExists(){

        composeTestRule.onRoot().printToLog("currentLabelExists")

        composeTestRule
            //.onNodeWithContentDescription("Accounts_BUTTON")
            //.onNodeWithText(RallyScreen.Accounts.name.uppercase())
            .onNodeWithContentDescription(RallyScreen.Accounts.name)
            .assertExists()
    }


    @Test
    fun accountsIsUpperCase(){

        composeTestRule.onRoot(useUnmergedTree = true).printToLog("currentLabelExists")

        composeTestRule
            .onNode(
        hasText(RallyScreen.Accounts.name.uppercase()) and
                hasParent( hasContentDescription(RallyScreen.Accounts.name) ),
                useUnmergedTree = true
            )
            .assertExists()
    }

}