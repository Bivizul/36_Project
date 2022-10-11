package aaa.bivizul.a36project.ui.virspop

import aaa.bivizul.a36project.domain.model.Virspovar
import aaa.bivizul.a36project.domain.util.getVirspoactoff
import aaa.bivizul.a36project.domain.util.sigVirspooff
import aaa.bivizul.a36project.domain.util.virspoct
import aaa.bivizul.a36project.ui.virspowidget.Virspocp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import kotlinx.coroutines.delay

@Composable
fun VirspopContent(
    component: VirspopModel,
    modifier: Modifier = Modifier
) {

    val virspog by component.state.collectAsState()
    val model by component.models.subscribeAsState()

    LaunchedEffect(key1 = true) {
        delay(3000)
        virspog?.virspog?.let {
            if (it == Virspovar.VSNO.vs) {
                component.onReplace()
            } else if (it == Virspovar.VSNP.vs) {
                sigVirspooff()
                component.onReplace()
            } else {
                virspoct(model.activity, it)
                getVirspoactoff(model.activity)
            }
        }
    }
    Virspocp(modifier = modifier)
}