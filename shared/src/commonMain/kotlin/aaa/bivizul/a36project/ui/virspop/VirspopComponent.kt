package aaa.bivizul.a36project.ui.virspop

import aaa.bivizul.a36project.data.repository.VirspoRepository
import aaa.bivizul.a36project.domain.model.Virspo
import aaa.bivizul.a36project.domain.model.Virspog
import aaa.bivizul.a36project.domain.util.*
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

class VirspopComponent(
    componentContext: ComponentContext,
    context: Any,
    virspoRepository: VirspoRepository,
    private val onReplaceToMain: () -> Unit
) : VirspopModel, ComponentContext by componentContext {

    private val _models = MutableValue(VirspopModel.Model(activity = context))
    override val models: Value<VirspopModel.Model> = _models
    override val state: StateFlow<Virspog?> = virspoRepository.virspog

    init {
        try {
            virspoRepository.getVirspog(
                Virspo(
                    getVirspomm(),
                    getVirsposim(context),
                    getVirspoid(context),
                    getVirspol(),
                    getVirspot()
                )
            )
        } catch (e: Exception) {
            getVirspodlg(context)
        }
    }

    override fun onReplace() {
        onReplaceToMain()
    }

}