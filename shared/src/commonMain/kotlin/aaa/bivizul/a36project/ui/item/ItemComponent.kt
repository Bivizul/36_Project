package aaa.bivizul.a36project.ui.item

import aaa.bivizul.a36project.data.repository.VirsposRepository
import aaa.bivizul.a36project.domain.model.Virspos
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

class ItemComponent(
    componentContext: ComponentContext,
    virsposRepository: VirsposRepository,
    virspoItemId: Int,
) : ItemModel, ComponentContext by componentContext {

    private val _models = MutableValue(ItemModel.Model(selectedVirspoItemId = virspoItemId))
    override val models: Value<ItemModel.Model> = _models

    override val state: StateFlow<List<Virspos>?> =
        virsposRepository.virsposList

}