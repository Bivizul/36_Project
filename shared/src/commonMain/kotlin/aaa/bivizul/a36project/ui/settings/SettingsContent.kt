package aaa.bivizul.a36project.ui.settings

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun SettingsContent(
    component: SettingsModel,
    modifier: Modifier = Modifier
) {

    val switchON = remember { mutableStateOf(true) }

    Column(
        modifier = modifier.padding(8.dp).fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Settings",
            style = MaterialTheme.typography.h3,
            textAlign = TextAlign.Center
        )
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = "Notifications",
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center
            )
            Switch(
                checked = switchON.value,
                onCheckedChange = { switchON.value = it },
                modifier = modifier.scale(2f),
                colors = SwitchDefaults.colors(
                    checkedThumbColor = MaterialTheme.colors.primary,
                    checkedTrackColor = MaterialTheme.colors.primary,
                    uncheckedThumbColor = MaterialTheme.colors.secondary,
                    uncheckedTrackColor = MaterialTheme.colors.secondary
                )
            )
        }
    }
}