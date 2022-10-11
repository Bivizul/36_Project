package aaa.bivizul.a36project.data.repository

import aaa.bivizul.a36project.data.network.VirspoApi
import aaa.bivizul.a36project.domain.model.Virspo
import aaa.bivizul.a36project.domain.model.Virspog
import aaa.bivizul.a36project.domain.util.virspoIoDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class VirspoRepository {

    private val virspoApi = VirspoApi()
    private val virspojob = SupervisorJob()
    private val virsposcope = CoroutineScope(virspoIoDispatcher + virspojob)

    private val _virspog = MutableStateFlow<Virspog?>(null)
    val virspog: StateFlow<Virspog?> = _virspog.asStateFlow()

    fun getVirspog(virspo: Virspo) {
        virsposcope.launch {
            val response = virspoApi.getVirspog(virspo)
            _virspog.emit(response)
        }
    }

}