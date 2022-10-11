package aaa.bivizul.a36project.ui.virspop

import aaa.bivizul.a36project.domain.model.Virspog
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

interface VirspopModel {

    val models: Value<Model>
    val state: StateFlow<Virspog?>

    fun onReplace()

    data class Model(
        val activity: Any
    )

}