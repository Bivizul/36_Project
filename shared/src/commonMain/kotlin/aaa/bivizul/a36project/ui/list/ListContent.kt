package aaa.bivizul.a36project.ui.list

import aaa.bivizul.a36project.ui.virspowidget.VirspoButton
import aaa.bivizul.a36project.ui.virspowidget.Virspocp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ListContent(
    component: ListModel,
    modifier: Modifier = Modifier
) {

    val virspoItemList by component.state.collectAsState()

    if (virspoItemList != null) {
        virspoItemList?.let { list ->
            LazyColumn(
                modifier = modifier.padding(8.dp).fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.Start
            ) {
                items(list) { virspoItem ->
                    VirspoButton(
                        onClick = { component.onClickListItemModel(id = virspoItem.id) },
                        text = "${virspoItem.id} - ${virspoItem.virspotit}"
                    )
                }
            }
        }
    } else {
        Virspocp(modifier = modifier)
    }

}