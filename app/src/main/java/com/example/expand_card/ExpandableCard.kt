package com.example.expand_card

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.expand_card.ui.theme.Shapes


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExpandableCard(){
    var expandedState by remember {
        mutableStateOf(false)
    }
    val rotationState by animateFloatAsState(targetValue = if(expandedState) 180f else 0f)
    Card(
        modifier= Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    delayMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape =Shapes.medium,
        onClick = {
            expandedState =!expandedState
        }
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
           Row (verticalAlignment = Alignment.CenterVertically){

               Text(
                   modifier = Modifier.weight(weight = 6f),
                   text = "My Title",
                   fontSize = MaterialTheme.typography.h6.fontSize,
                   fontWeight = FontWeight.Bold,
                   maxLines = 1,
                   overflow = TextOverflow.Ellipsis
               )
               IconButton(
                   modifier = Modifier
                       .alpha(ContentAlpha.medium)
                       .weight(weight = 1f)
                       .rotate(rotationState),
                   onClick = {
                       expandedState =!expandedState
                   }) {

                   Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription ="Drop-Down" )
               }

           }
            if(expandedState){
                Text(text = "Lorem ipsum is Latin text,but to today's reader,it's seen as gibberish Lorem ipsum is Latin text,but to today's reader,it's seen as gibberish Lorem ipsum is Latin text,but to today's reader,it's seen as gibberishLorem ipsum is Latin text,but to today's reader,it's seen as gibberishv Lorem ipsum is Latin text,but to today's reader,it's seen as gibberish Lorem ipsum is Latin text,but to today's reader,it's seen as gibberish"
                , fontSize = MaterialTheme.typography.subtitle1.fontSize,
                fontWeight = FontWeight.Normal,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis)
            }
        }

    }
}

@Composable
@Preview
fun ExpandableCardPreview(){
    ExpandableCard()
}