package com.sh4rp3r.lab1mobile

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview()
@Composable
fun Card() {
    val conf = LocalConfiguration.current
    val scale = conf.densityDpi / 300.0f
    if (conf.orientation == Configuration.ORIENTATION_LANDSCAPE){
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Profile(
                modifier = Modifier.weight(1f),
                scaler = scale
            )
            Contacts(
                modifier = Modifier.weight(1f),
                scaler = scale
            )
        }
    }
    else{
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Profile(
                modifier = Modifier.weight(1f),
                scaler = scale
            )
            Contacts(
                modifier = Modifier,
                scaler = scale
            )
        }
    }
}

@Composable
fun Profile(modifier: Modifier, scaler: Float) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.mipmap.android_logo),
            contentDescription = stringResource(R.string.image_description),
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .background(MaterialTheme.colorScheme.primary)
        )
        Text(
            text = stringResource(R.string.name),
            modifier = Modifier.wrapContentHeight(),
            fontSize = dimensionResource(R.dimen.name).value.sp  * scaler
        )
        Text(
            text = stringResource(R.string.group),
            modifier = Modifier.wrapContentHeight(),
            fontSize = dimensionResource(R.dimen.group).value.sp  * scaler
        )
    }
}

@Composable
fun Contacts(modifier: Modifier, scaler: Float){
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(if(isSystemInDarkTheme()) R.mipmap.telegram_light else R.mipmap.telegram),
            contentDescription = stringResource(R.string.image_description),
            modifier = Modifier.fillMaxSize(0.05f)
        )
        Spacer(
            modifier = Modifier.width(dimensionResource(R.dimen.spacing).value.dp * scaler)
        )
        Text(
            text = stringResource(R.string.telegram),
            modifier = Modifier,
            fontSize = dimensionResource(R.dimen.contact).value.sp * scaler
        )
    }
}