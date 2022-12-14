package aaa.bivizul.a36project.ui.item

import aaa.bivizul.a36project.ui.virspowidget.Virspocp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState

@Composable
fun ItemContent(
    component: ItemModel,
    modifier: Modifier = Modifier
) {

    val virspoItemList by component.state.collectAsState()
    val model by component.models.subscribeAsState()
    val scrollState = rememberScrollState()

    if (virspoItemList != null) {
        virspoItemList?.let { list ->
            list[model.selectedVirspoItemId - 1].let { item ->
                Column(
                    modifier = modifier
                        .verticalScroll(scrollState)
                        .padding(8.dp)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = item.virspotit,
                        style = MaterialTheme.typography.h5
                    )
                    Text(
                        text = item.virspodesc,
                        style = MaterialTheme.typography.body1
                    )
                }
            }
        }
    } else {
        Virspocp(modifier = modifier)
    }
}