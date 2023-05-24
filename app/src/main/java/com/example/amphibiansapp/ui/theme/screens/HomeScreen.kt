package com.example.amphibiansapp.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.amphibiansapp.R
import com.example.amphibiansapp.model.Amphibians
import com.example.amphibiansapp.ui.theme.AmphibiansAppTheme

@Composable
fun HomeScreen(
    amphibiansUiState: AmphibiansUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    when (amphibiansUiState) {
        is AmphibiansUiState.Loading -> LoadingScreen(modifier)
        is AmphibiansUiState.Success -> ListScreen(amphibiansUiState.data, modifier)
        is AmphibiansUiState.Error -> ErrorScreen(modifier)
    }

}

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = modifier
                .size(200.dp),
            painter = painterResource(id = R.drawable.loading_img),
            contentDescription = null
        )
    }
}

@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = modifier
                .size(200.dp),
            painter = painterResource(id = R.drawable.ic_broken_image),
            contentDescription = null
        )
    }
}

@Composable
fun AmphibianCard(
    amphibians: Amphibians,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(4.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = modifier
                .padding(4.dp)
        ) {
            Text(
                text = amphibians.name
            )
            Text(
                text = "(${amphibians.type})"
            )
            Text(text = amphibians.description)
        }

        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(amphibians.imgSrc)
                .crossfade(true)
                .build(),
            contentDescription = amphibians.type,
            contentScale = ContentScale.FillBounds,
            error = painterResource(id = R.drawable.ic_broken_image),
            placeholder = painterResource(id = R.drawable.loading_img)
        )
    }
}

@Composable
fun ListScreen(
    amphibians: List<Amphibians>,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        items(amphibians.size) { index ->
            AmphibianCard(amphibians = amphibians[index])
        }
    }
}

@Preview
@Composable
fun AmphibianCardPreview() {
    AmphibiansAppTheme {
    }
}