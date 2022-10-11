package aaa.bivizul.a36project.ui.root

import aaa.bivizul.a36project.data.repository.VirspoRepository
import aaa.bivizul.a36project.data.repository.VirsposRepository
import aaa.bivizul.a36project.ui.item.ItemComponent
import aaa.bivizul.a36project.ui.item.ItemModel
import aaa.bivizul.a36project.ui.list.ListComponent
import aaa.bivizul.a36project.ui.list.ListModel
import aaa.bivizul.a36project.ui.main.MainComponent
import aaa.bivizul.a36project.ui.main.MainModel
import aaa.bivizul.a36project.ui.settings.SettingsComponent
import aaa.bivizul.a36project.ui.settings.SettingsModel
import aaa.bivizul.a36project.ui.virspop.VirspopComponent
import aaa.bivizul.a36project.ui.virspop.VirspopModel
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.*
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize

class RootComponent constructor(
    componentContext: ComponentContext,
    private val context: Any
) : RootModel, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()
    val virspoRepository = VirspoRepository()
    val virsposRepository = VirsposRepository()

    private val stack =
        childStack(
            source = navigation,
            initialConfiguration = Config.VirspopConfig,
            handleBackButton = true,
            childFactory = ::createChild,
        )

    override val childStack: Value<ChildStack<*, RootModel.Child>> get() = stack

    private fun createChild(config: Config, componentContext: ComponentContext): RootModel.Child =
        when (config) {
            is Config.VirspopConfig -> RootModel.Child.VirspopChild(
                setVirspop(componentContext)
            )
            is Config.MainConfig -> RootModel.Child.MainChild(
                setMain(componentContext)
            )
            is Config.ListConfig -> RootModel.Child.ListChild(
                setList(componentContext)
            )
            is Config.ItemConfig -> RootModel.Child.ItemChild(
                setItem(componentContext, config)
            )
            is Config.SettingsConfig -> RootModel.Child.SettingsChild(
                setSettings(componentContext)
            )
        }

    private fun setVirspop(
        componentContext: ComponentContext
    ): VirspopModel = VirspopComponent(
        componentContext = componentContext,
        context = context,
        virspoRepository = virspoRepository,
        onReplaceToMain = {
            navigation.replaceCurrent(Config.MainConfig)
        }
    )

    private fun setMain(
        componentContext: ComponentContext
    ): MainModel = MainComponent(
        componentContext = componentContext,
        onClickList = {
            navigation.push(Config.ListConfig)
        },
        onClickSettings = {
            navigation.push(Config.SettingsConfig)
        }
    )

    private fun setList(
        componentContext: ComponentContext
    ): ListModel = ListComponent(
        componentContext = componentContext,
        virsposRepository = virsposRepository,
        onClickListItem = { itemId ->
            navigation.push(Config.ItemConfig(itemId = itemId))
        },
    )

    private fun setItem(
        componentContext: ComponentContext,
        config: Config.ItemConfig
    ): ItemModel = ItemComponent(
        componentContext = componentContext,
        virsposRepository = virsposRepository,
        virspoItemId = config.itemId
    )

    private fun setSettings(
        componentContext: ComponentContext
    ): SettingsModel = SettingsComponent(
        componentContext = componentContext,
    )

    private sealed class Config : Parcelable {
        @Parcelize
        object VirspopConfig : Config()

        @Parcelize
        object MainConfig : Config()

        @Parcelize
        object ListConfig : Config()

        @Parcelize
        data class ItemConfig(val itemId: Int) : Config()

        @Parcelize
        object SettingsConfig : Config()
    }
}