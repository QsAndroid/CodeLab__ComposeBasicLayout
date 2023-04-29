package com.example.codelab____composebasiclayout

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codelab____composebasiclayout.model.AlignYourBody
import com.example.codelab____composebasiclayout.model.FavoriteCollections
import com.example.codelab____composebasiclayout.ui.theme.CodeLab____ComposeBasicLayoutTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContent {


            CodeLab____ComposeBasicLayoutTheme {


            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CBLApp () {

    CodeLab____ComposeBasicLayoutTheme {

        androidx.compose.material.Scaffold(
            bottomBar = { CBLBottomNavigation() }
        ) {  paddingValues ->

            HomeScreen(Modifier.padding(paddingValues))

        }

    }
}

@Composable
fun HomeScreen (modifier: Modifier = Modifier) {

    Column(modifier) {

        val list : MutableList<AlignYourBody> = mutableListOf()

        list.add(AlignYourBody(R.drawable.ab1_inversions, R.string.ab1_inversions))
        list.add(AlignYourBody(R.drawable.ab2_quick_yoga, R.string.ab2_quick_yoga))
        list.add(AlignYourBody(R.drawable.ab3_stretching, R.string.ab3_stretching))
        list.add(AlignYourBody(R.drawable.ab4_tabata, R.string.ab4_tabata))
        list.add(AlignYourBody(R.drawable.ab5_hiit, R.string.ab5_hiit))
        list.add(AlignYourBody(R.drawable.ab6_pre_natal_yoga, R.string.ab6_pre_natal_yoga))



        val listOfFC = mutableListOf<FavoriteCollections>()

        listOfFC.add(FavoriteCollections(R.drawable.fc1_short_mantras, R.string.fc1_short_mantras))
        listOfFC.add(FavoriteCollections(R.drawable.fc2_nature_meditations, R.string.fc2_nature_meditations))
        listOfFC.add(FavoriteCollections(R.drawable.fc3_stress_and_anxiety, R.string.fc3_stress_and_anxiety))
        listOfFC.add(FavoriteCollections(R.drawable.fc4_self_massage, R.string.fc4_self_massage))
        listOfFC.add(FavoriteCollections(R.drawable.fc5_overwhelmed, R.string.fc5_overwhelmed))
        listOfFC.add(FavoriteCollections(R.drawable.fc6_nightly_wind_down, R.string.fc6_nightly_wind_down))

        Spacer(modifier = Modifier.height(16.dp))

        SearchBar(modifier = Modifier.padding(horizontal = 16.dp))

        HomeSection(title =R.string.align_your_body ) {
            AlignYourBodyRow(alignYourBodyList = list)
        }

        HomeSection(title = R.string.favorite_collections) {
            FavoriteCollectionsGrid(favoriteCollectionsList = listOfFC )
        }

        Spacer(modifier = Modifier.height(16.dp))



    }
}

@Composable
fun HomeSection (

    @StringRes title : Int,
    modifier: Modifier = Modifier,
    content : @Composable () -> Unit
) {

    Column(modifier) {

        Text(
            text = stringResource(title).uppercase(java.util.Locale.getDefault()),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                .padding(horizontal = 16.dp)
        )


        content()
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
    @DrawableRes drawable : Int,
    @StringRes text : Int,
    modifier: Modifier = Modifier
) {

    Column(

        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Image(
            painter = painterResource(id = drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
            
        )
        
        Text(

            text = stringResource(id = text),
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.paddingFromBaseline(
                top = 24.dp,
                bottom = 8.dp
            )

        )

    }
}

@Composable
fun AlignYourBodyRow (
    modifier: Modifier = Modifier,
    alignYourBodyList : List<AlignYourBody>
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        
        items(items = alignYourBodyList) { item ->

            AlignYourBodyElement(drawable = item.drawable, text =item.text )
        }
    }
}

@Composable
fun FavoriteCollectionCard (

    @DrawableRes drawable : Int,
    @StringRes text : Int,
    modifier: Modifier = Modifier
) {

    androidx.compose.material3.Surface(
        modifier = modifier
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(192.dp)
        ) {

            Image(
                painter = painterResource(id = drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(56.dp)
            )
            Text(
                text = stringResource(id = text) ,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(horizontal = 16.dp))

        }

    }
}

@Composable
fun FavoriteCollectionsGrid(
    modifier: Modifier = Modifier,
    favoriteCollectionsList : List<FavoriteCollections>
) {
    
    LazyHorizontalGrid(

        rows = GridCells.Fixed(2),
        modifier = modifier.height(120.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)

    ) {
        
        items(favoriteCollectionsList) { item ->
            FavoriteCollectionCard(drawable = item.drawable, text = item.text)
        }
    }
}

@Composable
private fun CBLBottomNavigation(modifier: Modifier = Modifier) {

    BottomNavigation(
        backgroundColor = MaterialTheme.colorScheme.surface,
        modifier= modifier) {

        BottomNavigationItem(
            icon = {
                Icon(imageVector = Icons.Default.Home,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(id = R.string.bottom_navigation_home))
            },
            selected = true,
            onClick = { }
        )

        BottomNavigationItem(
            icon = {
                Icon(imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(id = R.string.bottom_navigation_profile))
            },
            selected = false,
            onClick = { }
        )

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CodeLab____ComposeBasicLayoutTheme {

        CBLApp()
    }
}