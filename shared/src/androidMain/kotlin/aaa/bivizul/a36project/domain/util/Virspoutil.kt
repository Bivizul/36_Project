@file:Suppress("DEPRECATION")

package aaa.bivizul.a36project.domain.util

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Uri
import android.telephony.TelephonyManager
import androidx.browser.customtabs.CustomTabsIntent
import com.onesignal.OneSignal
import kotlinx.coroutines.Dispatchers
import java.text.SimpleDateFormat
import java.util.*
import kotlin.coroutines.CoroutineContext

actual val virspoUiDispatcher: CoroutineContext = Dispatchers.Main

actual val virspoIoDispatcher: CoroutineContext = Dispatchers.IO

actual fun getVirspomm(): String {
    val manfacvirspo = android.os.Build.MANUFACTURER
    val modelvirspo = android.os.Build.MODEL
    return "$manfacvirspo $modelvirspo"
}

actual fun getVirsposim(virspocon: Any): String {
    val context = virspocon as Context
    val telmanvirspo = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    return telmanvirspo.simCountryIso
}

actual fun getVirspoid(virspocon: Any): String {
    val context = virspocon as Context
    val sharedPreferences = context.getSharedPreferences("appprefvirspo", Context.MODE_PRIVATE)
    var virspoid = sharedPreferences.getString("virspo_key", "novirspo") ?: "novirspo"
    if (virspoid == "novirspo") {
        val dateNow = Date()
        val simpleDateFormat = SimpleDateFormat("yyMMddhhmmssMs")
        val datetime = simpleDateFormat.format(dateNow)
        val randomNum = (10000 until 100000).random()
        virspoid = datetime + randomNum
        sharedPreferences.edit().putString("virspo_key", virspoid).apply()
    }
    return virspoid
}

actual fun getVirspol(): String {
    return Locale.getDefault().language
}

actual fun getVirspot(): String {
    val virspotz: String = SimpleDateFormat("z", Locale.getDefault()).format(
        Calendar.getInstance(
            TimeZone.getTimeZone("GMT"),
            Locale.getDefault()
        ).time
    ).replace("GMT", "")
    val virspozone = if (virspotz.contains(":")) virspotz else "default"
    return virspozone
}

actual fun getVirspodlg(virspocon: Any) {
    val context = virspocon as Context
    val activity = virspocon as Activity
    AlertDialog.Builder(context).apply {
        setTitle("Error connect complete")
        setMessage("Please try again later, push exit")
        setPositiveButton("Exit") { _, _ ->
            activity.finish()
            System.exit(0)
        }
        setCancelable(true)
    }.create().show()
}

@SuppressLint("MissingPermission")
actual fun checkVirsponet(virspocon: Any): Boolean {
    val context = virspocon as Context
    val conmanvirspo =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val netinfvirspo = conmanvirspo.activeNetworkInfo
    return netinfvirspo != null && netinfvirspo.isConnected
}

actual fun sigVirspooff() {
    OneSignal.disablePush(true)
}

internal actual fun getVirspoactoff(virspocon: Any) {
    val virspoa = virspocon as Activity
    virspoa.finish()
    System.exit(0)
}

internal actual fun virspoct(virspocon: Any, virspocc: String) {
    val context = virspocon as Context
    val virspoa = (context as? Activity)
    val virspopn = "com.android.chrome"
    val virspob = CustomTabsIntent.Builder()
        .setShowTitle(false)
        .setInstantAppsEnabled(true)
        .build()
    if (virspopn != null) {
        virspob.intent.setPackage(virspopn)
        virspob.launchUrl(context, Uri.parse(virspocc))
    } else {
        val i = Intent(Intent.ACTION_VIEW, Uri.parse(virspocc))
        virspoa?.startActivity(i)
    }
}