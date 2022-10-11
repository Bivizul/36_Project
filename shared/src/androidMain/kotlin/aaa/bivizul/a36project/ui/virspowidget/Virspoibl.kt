package aaa.bivizul.a36project.ui.virspowidget

import aaa.bivizul.a36project.domain.util.Virspocon
import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
actual fun Virspoibl() {

    val virspoorient = LocalConfiguration.current.orientation
    val virspoImgModel = when (virspoorient) {
        Configuration.ORIENTATION_PORTRAIT -> Virspocon.VIRSPOBV
        else -> Virspocon.VIRSPOBH
    }

    GlideImage(
        imageModel = virspoImgModel,
        imageOptions = ImageOptions(
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center
        )
    )

}