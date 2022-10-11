package aaa.bivizul.a36project.ui.list

import aaa.bivizul.a36project.data.repository.VirsposRepository
import aaa.bivizul.a36project.domain.model.Virspos
import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.StateFlow

class ListComponent(
    componentContext: ComponentContext,
    virsposRepository: VirsposRepository,
    private val onClickListItem: (id: Int) -> Unit,
) : ListModel, ComponentContext by componentContext {

    override val state: StateFlow<List<Virspos>?> = virsposRepository.virsposList

    override fun onClickListItemModel(id: Int) {
        onClickListItem(id)
    }
}