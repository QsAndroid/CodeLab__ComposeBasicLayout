package com.example.codelab____composebasiclayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codelab____composebasiclayout.ui.theme.CodeLab____ComposeBasicLayoutTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContent {


            CodeLab____ComposeBasicLayoutTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun SearchBar (
    modifier: Modifier = Modifier
) {

    TextField(
        value =" " ,
        onValueChange = { },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colorScheme.surface
        ),
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp),
        placeholder = { Text(text = "Search", color = MaterialTheme.colorScheme.primary)},
        leadingIcon = { 
            Icon(imageVector = Icons.Default.Search , contentDescription =null )
        }
    ) 


}

@Composable
fun AlignYourBodyElement (
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier) {


        Image(
            painter = painterResource(id = R.drawable.ab1_inversions),
            contentDescription = null,
            
        )
        
        Text(text = stringResource(id = R.string.ab1_inversions))

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CodeLab____ComposeBasicLayoutTheme {
        
        Column() {

            SearchBar()
            Spacer(modifier = Modifier.height(16.dp))
            AlignYourBodyElement()
            
        }
       
    }
}