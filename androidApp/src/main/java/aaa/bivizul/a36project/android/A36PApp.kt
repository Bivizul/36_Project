package aaa.bivizul.a36project.android

import aaa.bivizul.a36project.domain.util.Virspocon.VIRSPOOSAI
import android.app.Application
import com.onesignal.OneSignal

class A36PApp : Application() {

    override fun onCreate() {
        super.onCreate()

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(VIRSPOOSAI)

    }

}