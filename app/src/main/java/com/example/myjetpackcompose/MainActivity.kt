package com.example.myjetpackcompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.*
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Surface
import androidx.ui.res.imageResource
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.example.myjetpackcompose.ui.MyJetpackComposeTheme
import com.example.myjetpackcompose.ui.purple200
import com.example.myjetpackcompose.ui.typography

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MyJetpackComposeTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
          NewsStory()
        }
      }
    }
  }
}

@Composable
fun Greeting(name: String) {
  Text(text = "Hello $name!")
}

@Composable
fun ListTags() {
  val list: List<String> = listOf("tag", "two", "three")
  Row() {
    for (name in list) {
      Tag("#$name")
    }
  }
}

@Composable
fun Tag(name: String = "test") {
  Text(name, modifier = Modifier.padding(end = 4.dp), color = purple200)
}

@Composable
fun CounterButton() {
  val count = state { 0 }

  Button(onClick = { count.value++ }) {
    Text("I'ves been clicked ${count.value} times")
  }
}

@Composable
fun NewsStory() {
  val image = imageResource(R.drawable.header);
  val imageModifier = Modifier.preferredHeightIn(maxHeight = 180.dp)
    .fillMaxWidth()
    .clip(shape = RoundedCornerShape(8.dp))

  Column(modifier = Modifier.padding(16.dp)) {
    Image(
      image,
      modifier = imageModifier,
      contentScale = ContentScale.Crop
    )
    Spacer(Modifier.preferredHeight(16.dp))
    Text(
      "A day wandering through the sandhills " +
              "in Shark Fin Cove, and a few of the " +
              "sights we saw",
      style = typography.h6,
      maxLines = 2,
      overflow = TextOverflow.Ellipsis
    )
    Text(
      "Davenport, California",
      style = typography.body2,
      color = Color.Gray
    )
    Text(
      "December 2018",
      style = typography.body2,
      color = Color.Gray
    )
    ListTags()
    Spacer(Modifier.preferredHeight(16.dp))
    CounterButton()
  }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  MyJetpackComposeTheme {
    Column() {
      NewsStory()

    }
  }
}