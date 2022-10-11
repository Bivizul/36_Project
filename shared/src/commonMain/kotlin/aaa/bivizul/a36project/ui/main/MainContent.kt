package aaa.bivizul.a36project.ui.main

import aaa.bivizul.a36project.domain.util.Virspocon.VIRSPOAN
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun MainContent(
    component: MainModel,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.padding(16.dp).fillMaxSize(),
    ) {
        Icon(
            imageVector = Icons.Filled.Settings,
            contentDescription = "Settings",
            modifier = modifier
                .clickable { component.onClickSettingsModel() }
                .align(Alignment.TopStart),
        )
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = VIRSPOAN,
                modifier = modifier
                    .rotate(-30f),
                style = MaterialTheme.typography.h2,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Go Go Go",
                modifier = modifier
                    .clickable { component.onClickListModel() }
                    .rotate(-30f),
                style = MaterialTheme.typography.h3,
                textAlign = TextAlign.Center
            )
        }
    }
}