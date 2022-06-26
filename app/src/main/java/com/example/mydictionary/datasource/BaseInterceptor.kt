package com.example.mydictionary.datasource

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

private const val STATUS_CODE_ONE = 1
private const val STATUS_CODE_TWO = 2
private const val STATUS_CODE_THREE = 3
private const val STATUS_CODE_FOUR = 4
private const val STATUS_CODE_FIVE = 5

class BaseInterceptor private constructor():Interceptor {
    private var responseCode: Int = 0

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        responseCode = response.code()
        return response
    }

    fun getResponseCode(): ServerResponseStatusCode {
        var statusCode = ServerResponseStatusCode.UNDEFINED_ERROR
        when (responseCode / 100) {
            STATUS_CODE_ONE -> statusCode = ServerResponseStatusCode.INFO
            STATUS_CODE_TWO -> statusCode = ServerResponseStatusCode.SUCCESS
            STATUS_CODE_THREE -> statusCode = ServerResponseStatusCode.REDIRECTION
            STATUS_CODE_FOUR -> statusCode = ServerResponseStatusCode.CLIENT_ERROR
            STATUS_CODE_FIVE -> statusCode = ServerResponseStatusCode.SERVER_ERROR
        }
        return statusCode
    }


    enum class ServerResponseStatusCode {
        INFO,
        SUCCESS,
        REDIRECTION,
        CLIENT_ERROR,
        SERVER_ERROR,
        UNDEFINED_ERROR
    }

    companion object {

        val interceptor: BaseInterceptor
            get() = BaseInterceptor()
    }

}
