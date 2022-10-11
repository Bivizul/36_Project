package aaa.bivizul.a36project.android

import aaa.bivizul.a36project.domain.util.checkVirsponet
import aaa.bivizul.a36project.domain.util.getVirspodlg
import aaa.bivizul.a36project.ui.root.RootComponent
import aaa.bivizul.a36project.ui.root.RootContent
import aaa.bivizul.a36project.ui.virspowidget.Virspoibl
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.defaultComponentContext

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColors(
            primary = Color(0xB211A700),
            background = Color(0xA4524B13),
            secondary = Color(0x9FFF0909),
            onPrimary = Color(0xFFCFCFCF),
            onBackground = Color(0xFFCFCFCF),
        )
    } else {
        lightColors(
            primary = Color(0xB21AFF00),
            background = Color(0xA4FFEB3B),
            secondary = Color(0x9FFF0909),
            onPrimary = Color(0xFFFFFFFF),
            onBackground = Color(0xFFFFFFFF),
        )
    }
    val typography = Typography(
        body1 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp
        )
    )
    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (checkVirsponet(this)) {
            val root = RootComponent(
                componentContext = defaultComponentContext(),
                context = this@MainActivity
            )
            setContent {
                MyApplicationTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background
                    ) {
                        Virspoibl()
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(MaterialTheme.colors.background)
                        )
                        RootContent(rootModel = root)
                    }
                }
            }
        } else {
            getVirspodlg(this)
        }
    }
}
