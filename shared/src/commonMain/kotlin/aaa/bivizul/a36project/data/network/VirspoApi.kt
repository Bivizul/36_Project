package aaa.bivizul.a36project.data.network

import aaa.bivizul.a36project.domain.model.Virspo
import aaa.bivizul.a36project.domain.model.Virspog
import aaa.bivizul.a36project.domain.model.Virspos
import aaa.bivizul.a36project.domain.util.Virspocon.VIRSPOBASEURL
import aaa.bivizul.a36project.domain.util.Virspocon.VIRSPOGURL
import aaa.bivizul.a36project.domain.util.Virspocon.VIRSPOITEMURL
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.http.ContentType.Application.Json
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class VirspoApi {

    val virspohc = HttpClient(CIO) {
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.INFO
        }
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    private fun HttpRequestBuilder.virspobase(path: String) {
        url {
            takeFrom(VIRSPOBASEURL)
            encodedPath = path
        }
    }

    suspend fun getVirspoItem(): List<Virspos> {
        val getvirspoitemurl = VIRSPOITEMURL
        val virspohr = virspohc.get { virspobase(getvirspoitemurl) }
        val getvirspoitembody = virspohr.body<List<Virspos>>()
        return getvirspoitembody
    }

    suspend fun getVirspog(virspo: Virspo): Virspog {
        val getvirspourl = VIRSPOGURL
        val virspohr = virspohc.post {
            virspobase(getvirspourl)
            contentType(Json)
            setBody(virspo)
        }
        val getvirspobody = virspohr.body<Virspog>()
        return getvirspobody
    }

}