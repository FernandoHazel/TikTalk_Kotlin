package com.Fhazel.TikTalk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.Fhazel.TikTalk.ui.theme.TikTalkTheme
import androidx.compose.foundation.Image
import androidx.compose.material3.Button
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TikTalkTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    TikTalkMainLayout()
                }
            }
        }
    }
}

@Composable
fun TikTalkMainLayout() {
    Column(
        modifier = Modifier
            .padding(horizontal = 30.dp, vertical = 30.dp)
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ){
        // Remember the state of the user input
        var userInput by remember { mutableStateOf("") }

        CameraImageComponent()
        NameComponent(userInput, {userInput = it})
        TextComponent()
        ActionButtonComponent()
    }
}

// Component who decides what to put un camera view
@Composable
fun CameraImageComponent(){
    Image(
        painter = painterResource(id = R.drawable.unknown_person),
        contentDescription = "Unknown person",
        modifier = Modifier
            .size( 160.dp )
    )
}

// Component who decides what to put on the name field
@Composable
fun NameComponent(
    value: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier
){
    TextField(
        value = value,
        onValueChange = onValueChanged,
        label = {Text(stringResource(R.string.name))},
        singleLine = true,
        modifier = modifier
    )
}

@Composable
fun TextComponent(){
    Text(
        text = stringResource(R.string.Take_Picture)
    )
}

@Composable
fun ActionButtonComponent(){
    Button(
        onClick = { /*TODO*/ }
    ) {
        Text(stringResource(R.string.Scan_Qr))
    }
}

@Preview(showBackground = true)
@Composable
fun TilTalkPreview() {
    TikTalkTheme {
        TikTalkMainLayout()
    }
}