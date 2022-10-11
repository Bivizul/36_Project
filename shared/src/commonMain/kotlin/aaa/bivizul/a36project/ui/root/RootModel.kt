package aaa.bivizul.a36project.ui.root

import aaa.bivizul.a36project.ui.item.ItemModel
import aaa.bivizul.a36project.ui.list.ListModel
import aaa.bivizul.a36project.ui.main.MainModel
import aaa.bivizul.a36project.ui.settings.SettingsModel
import aaa.bivizul.a36project.ui.virspop.VirspopModel
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

interface RootModel {

    val childStack: Value<ChildStack<*, Child>>

    sealed class Child {
        class VirspopChild(val component: VirspopModel) : Child()
        class MainChild(val component: MainModel) : Child()
        class ListChild(val component: ListModel) : Child()
        class ItemChild(val component: ItemModel) : Child()
        class SettingsChild(val component: SettingsModel) : Child()
    }

}