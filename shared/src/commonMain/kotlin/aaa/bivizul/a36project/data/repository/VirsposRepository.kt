package aaa.bivizul.a36project.data.repository

import aaa.bivizul.a36project.data.network.VirspoApi
import aaa.bivizul.a36project.domain.model.Virspos
import aaa.bivizul.a36project.domain.util.virspoIoDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class VirsposRepository {

    private val virspoApi = VirspoApi()
    private val virspojob = SupervisorJob()
    private val virsposcope = CoroutineScope(virspoIoDispatcher + virspojob)

    private val _virspoItemList = MutableStateFlow<List<Virspos>?>(null)
    val virsposList: StateFlow<List<Virspos>?> = _virspoItemList.asStateFlow()

    init {
        getVirspoItem()
    }

    fun getVirspoItem() {
        virsposcope.launch {
            val response = virspoApi.getVirspoItem()
            _virspoItemList.emit(response)
        }
    }

}