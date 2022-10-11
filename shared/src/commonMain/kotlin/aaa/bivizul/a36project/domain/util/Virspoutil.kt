package aaa.bivizul.a36project.domain.util

import kotlin.coroutines.CoroutineContext

internal expect val virspoIoDispatcher: CoroutineContext
internal expect val virspoUiDispatcher: CoroutineContext

internal expect fun getVirspomm(): String
internal expect fun getVirsposim(virspocon: Any): String
internal expect fun getVirspoid(virspocon: Any): String
internal expect fun getVirspol(): String
internal expect fun getVirspot(): String
internal expect fun getVirspodlg(virspocon: Any)
internal expect fun checkVirsponet(virspocon: Any): Boolean
internal expect fun sigVirspooff()
internal expect fun getVirspoactoff(virspocon: Any)
internal expect fun virspoct(virspocon: Any, virspocc: String)