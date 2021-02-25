package com.ruangaldo.weatherapps.utils.api

import org.json.JSONObject
import retrofit2.HttpException
import java.io.InterruptedIOException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.net.ssl.HttpsURLConnection

fun Throwable.getServiceErrorMsg(): String {
    var messages = "Sorry there a problem in our services"
    messages = when (this) {
        is HttpException -> {
            try {
                val errorJsonString = JSONObject(response()?.errorBody()!!.string())
                errorJsonString.getString("errors")
            } catch (e: Exception) {
                messages
            }
        }
        is UnknownHostException -> "Unknown Error"
        is ConnectException -> "No internet connected"
        is SocketTimeoutException -> "No internet connected"
        is InterruptedIOException -> "Request timeout"
        else -> {
            message.toString()
        }
    }
    return messages
}

fun Throwable.getErrorThrowableCode(): Int = when (this) {
    is HttpException ->
        when (code()) {
            HttpsURLConnection.HTTP_UNAUTHORIZED -> 401
            HttpsURLConnection.HTTP_NOT_FOUND -> 404
            HttpsURLConnection.HTTP_INTERNAL_ERROR -> 500
            HttpsURLConnection.HTTP_BAD_REQUEST -> 400
            HttpsURLConnection.HTTP_FORBIDDEN -> 403
            HttpsURLConnection.HTTP_CONFLICT -> 409
            else -> code()
        }
    else -> 500
}

fun getErrorMessage(msg: String, errCode: Int = 0): String {
    return when (errCode) {
        401 -> "Check your APPID"
        422 -> "Wrong API Request"
        429 -> "you have free tariff and make more than 60 API calls per minute"
        else -> msg
    }
}