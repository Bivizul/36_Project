package aaa.bivizul.a36project.ui.main

import aaa.bivizul.a36project.domain.util.Virspocon.VIRSPOAN
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
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
                .align(Alignment.TopEnd),
        )
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = VIRSPOAN,
                modifier = modifier,
                style = MaterialTheme.typography.h3,
                textAlign = TextAlign.Center
            )
            Row(
                modifier = modifier
                    .clickable { component.onClickListModel() }
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(48.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Begin",
                    modifier = modifier,
                    style = MaterialTheme.typography.h4,
                    textAlign = TextAlign.Center
                )
                Icon(
                    imageVector = Icons.Filled.ArrowForward,
                    contentDescription = null,
                    modifier = modifier
                        .scale(2f)
                )
            }
        }
    }
}