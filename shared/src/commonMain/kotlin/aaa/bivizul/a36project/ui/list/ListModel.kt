package aaa.bivizul.a36project.ui.list

import aaa.bivizul.a36project.domain.model.Virspos
import kotlinx.coroutines.flow.StateFlow

interface ListModel {

    val state: StateFlow<List<Virspos>?>

    fun onClickListItemModel(id: Int)

}