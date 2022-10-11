package aaa.bivizul.a36project.ui.item

import aaa.bivizul.a36project.domain.model.Virspos
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

interface ItemModel {

    val models: Value<Model>

    val state: StateFlow<List<Virspos>?>

    data class Model(
        val selectedVirspoItemId: Int
    )

}