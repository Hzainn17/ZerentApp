package com.example.zerentapp.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material.icons.rounded.StarOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zerentapp.R
import com.example.zerentapp.model.dUlasan
import com.example.zerentapp.ui.theme.ZerentAppTheme


@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Double = 0.0,
    stars: Int = 5,
    onRatingChanged: (Double) -> Unit ,
    starsColor: Color = Color.Black
){
    var halfStar = (rating % 1) != 0.0

    Row {
        for (index in 1..stars) {
            Icon(
                imageVector =
                if (index <= rating) {
                    Icons.Rounded.Star
                } else {
                    if (halfStar) {
                        halfStar = false
                        Icons.Rounded.StarHalf
                    } else {
                        Icons.Rounded.StarOutline
                    }
                },
                contentDescription = null,
                tint = starsColor,
                modifier = modifier
                    .clickable{ onRatingChanged(index.toDouble()) }
            )
        }
    }
}

@Composable
fun UlasanScreen(
    ulasan: dUlasan,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
){

    var rating by remember { mutableStateOf(0.0) }

    Column(
        modifier = Modifier
            .size(width = 150.dp, height = 220.dp)
            .border(width = 1.dp, Color.Black, shape = RoundedCornerShape(7.dp))
            ,
    ) {
        Image(painter = painterResource(id = ulasan.foto),
            contentDescription = ulasan.nama, modifier = Modifier
                .clip(RectangleShape)
                .size(height = 90.dp, width = 200.dp)
        )
        Column (modifier = Modifier
            .padding(horizontal = 5.dp),){
            Text( modifier = Modifier
                .padding(top = 10.dp, bottom = 5.dp)
                ,
                text = ulasan.nama,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp
            )

            RatingBar(
                modifier = Modifier
                    .padding(bottom = 10.dp),
                rating = rating,
                stars = 5,
                onRatingChanged = { newRating ->
                    rating = newRating
                },
                starsColor = Color.Yellow
            )

            Text(
                modifier = Modifier,
                text = ulasan.pesan,
//            style = MaterialTheme.typography.titleSmall,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Start,
                maxLines = 3,
                fontSize = 8.sp,
                lineHeight = 12.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UlasanScreenPreview(){
    ZerentAppTheme {
        UlasanScreen(ulasan = dUlasan(id = 1, nama = "Hamdan", pesan = "Worth it bnget sewa nyaa, kualitas oke... juga masuk dikantong harganya", email = "mj@gmail.com" ,foto = R.drawable.img),
            ) {
        }
    }
}