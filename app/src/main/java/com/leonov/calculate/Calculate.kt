package com.leonov.calculate

import android.content.pm.ModuleInfo
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


// mutableStateOf указывает на то что значение может быть изменено
// State<String> указывает на то что значение будет строкой
var expression = mutableStateOf("46x8")
var expressionResult = mutableStateOf("360")

@Composable
fun Calculate(
    modifier: Modifier= Modifier,

) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .clip(RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                    bottomStart = 40.dp,
                    bottomEnd = 40.dp,
                ))
                .background(MaterialTheme.colorScheme.primaryContainer)
                .weight(1f)
                .padding(bottom = 16.dp, start = 40.dp, end = 40.dp),

            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End,
        ) {
            Text(
                // value нужен чтобы получить значение из State<String>
                text= expression.value,
                fontSize = 36.sp,
                fontWeight= FontWeight.SemiBold,
                color=MaterialTheme.colorScheme.onPrimaryContainer
            )
            Text(
                text=expressionResult.value,
                fontSize = 17.sp,
                fontWeight= FontWeight.SemiBold,
                color=MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
        Row(
            modifier= Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)

        ) {
            Text(
                text="√",
                fontSize = 40.sp,
                fontWeight = FontWeight.SemiBold,
                modifier= Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
            Text(
                text="π",
                fontSize = 40.sp,
                fontWeight = FontWeight.SemiBold,
                modifier= Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
            Text(
                text="^",
                fontSize = 40.sp,
                fontWeight = FontWeight.SemiBold,
                modifier= Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
            Text(
                text="!",
                fontSize = 40.sp,
                fontWeight = FontWeight.SemiBold,
                modifier= Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
        }
        Row(
            modifier= Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){
            Box(
                modifier= Modifier.weight(1f)
                // при нажатии на элемент нужно чтобы его фон тоже обрезался в круг, поэтому 
                //мы сначала обрезаем его в круг, а потом добавляем кнопку
                    .clip(CircleShape)
                    // код, который мы напишем в фигурных скобках будет выполняться
                    // при клике на данный элемент
                    .clickable{
                        // тэги нужны для того чтобы легко ориентироваться в журнале логирования
                        // первый тэг - это название приложения, второй тэг - это название элемента
                        // package:mine tag=:Calculator 
                        // tag=: означает что logТег должен в точности совпадать с этой строкой
                        // tag: будет содержать определённую строчку
                        Log.d("Calculator", "The AC Button is cliced ")
                        // обращаемся к свойству value и кладём в него новое значение
                        expression.value = ""
                        expressionResult.value = ""
                   
                    }
                    .background(MaterialTheme.colorScheme.secondary)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center,

            ) {
                Text(
                    text="AC",
                    fontSize = 40.sp,
                    color= MaterialTheme.colorScheme.onBackground
                )
            }
            Box(
                modifier= Modifier.weight(1f)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.tertiary)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text="( )",
                    fontSize = 40.sp,
                    color= MaterialTheme.colorScheme.onBackground
                )
            }
            Box(
                modifier= Modifier.weight(1f)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.tertiary)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text="%",
                    fontSize = 40.sp,
                    color= MaterialTheme.colorScheme.onBackground
                )
            }
            Box(
                modifier= Modifier.weight(1f)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.tertiary)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text="÷",
                    fontSize = 40.sp,
                    color= MaterialTheme.colorScheme.onBackground
                )
            }
        }
        Row(
            modifier= Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){
            Box(
                modifier= Modifier.weight(1f)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text="7",
                    fontSize = 40.sp,
                    color= MaterialTheme.colorScheme.onBackground
                )
            }
            Box(
                modifier= Modifier.weight(1f)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text="8",
                    fontSize = 40.sp,
                    color= MaterialTheme.colorScheme.onBackground
                )
            }
            Box(
                modifier= Modifier.weight(1f)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text="9",
                    fontSize = 40.sp,
                    color= MaterialTheme.colorScheme.onBackground
                )
            }
            Box(
                modifier= Modifier.weight(1f)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.tertiary)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text="X",
                    fontSize = 40.sp,
                    color= MaterialTheme.colorScheme.onBackground
                )
            }
        }
        Row(
            modifier= Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){
            Box(
                modifier= Modifier.weight(1f)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text="4",
                    fontSize = 40.sp,
                    color= MaterialTheme.colorScheme.onBackground
                )
            }
            Box(
                modifier= Modifier.weight(1f)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text="5",
                    fontSize = 40.sp,
                    color= MaterialTheme.colorScheme.onBackground
                )
            }
            Box(
                modifier= Modifier.weight(1f)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text="6",
                    fontSize = 40.sp,
                    color= MaterialTheme.colorScheme.onBackground
                )
            }
            Box(
                modifier= Modifier.weight(1f)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.tertiary)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text="-",
                    fontSize = 40.sp,
                    color= MaterialTheme.colorScheme.onBackground
                )
            }
        }
        Row(
            modifier= Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){
            Box(
                modifier= Modifier.weight(1f)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text="1",
                    fontSize = 40.sp,
                    color= MaterialTheme.colorScheme.onBackground
                )
            }
            Box(
                modifier= Modifier.weight(1f)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text="2",
                    fontSize = 40.sp,
                    color= MaterialTheme.colorScheme.onBackground
                )
            }
            Box(
                modifier= Modifier.weight(1f)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text="3",
                    fontSize = 40.sp,
                    color= MaterialTheme.colorScheme.onBackground
                )
            }
            Box(
                modifier= Modifier.weight(1f)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.tertiary)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text="+",
                    fontSize = 40.sp,
                    color= MaterialTheme.colorScheme.onBackground
                )
            }
        }
        Row(
            modifier= Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){
            Box(
                modifier= Modifier.weight(2f)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .aspectRatio(2/1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text="0",
                    fontSize = 40.sp,
                    color= MaterialTheme.colorScheme.onBackground
                )
            }
            Box(
                modifier= Modifier.weight(1f)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text=",",
                    fontSize = 40.sp,
                    color= MaterialTheme.colorScheme.onBackground
                )
            }
            Box(
                modifier= Modifier.weight(1f)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.tertiary)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text="=",
                    fontSize = 40.sp,
                    color= MaterialTheme.colorScheme.onBackground
                )
            }

        }
    }

}