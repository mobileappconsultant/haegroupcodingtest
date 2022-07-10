package com.haehome.data.network

import android.util.Log
import com.haehome.data.model.WeatherInfo
import com.haehome.data.model.WeatherInfo.Companion.toWeatherInfo
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

private const val TAG = "HttpNetworkConnection"

class HttpConnection {
    suspend fun performHttpConnection(httpUrl : String) = suspendCoroutine<NetworkResult<WeatherInfo>> {
        val readTextBuf = StringBuffer()

        // Maintain http url connection.
        var httpConn: HttpURLConnection? = null

        // Read text input stream.
        var inputStreamReader: InputStreamReader? = null

        // Read text into buffer.
        var bufferedReader: BufferedReader? = null


        try {
            val url: URL = URL(httpUrl)
            httpConn = url.openConnection() as HttpURLConnection
            httpConn.requestMethod = "GET";
            val inputStream: InputStream = httpConn.inputStream
            inputStreamReader = InputStreamReader(inputStream)
            bufferedReader = BufferedReader(inputStreamReader)
            var line: String? = bufferedReader.readLine()
            while(line != null)
            {
                // Append the text to string buffer.
                readTextBuf.append(line);
                // Continue to read text line.
                line = bufferedReader.readLine();
            }
            val jsonResponse = JSONObject(readTextBuf.toString())
            it.resume(NetworkResult.Success(jsonResponse.toWeatherInfo()))
        } catch (exception : MalformedURLException) {
            Log.e(TAG, exception.message, exception)
            it.resume(NetworkResult.Failure("Malformed URL Exception", exception))
        } catch (exception: IOException) {
            it.resume(NetworkResult.Failure("An Error occurred", exception))
        } finally {
            try {
                bufferedReader?.close()
                bufferedReader = null

                inputStreamReader?.close()
                inputStreamReader = null

                httpConn?.disconnect()
                httpConn = null
            } catch (ex: IOException) {
                Log.e(TAG, ex.message, ex)
                it.resume(NetworkResult.Failure("An Error occurred", ex))
            }
        }

    }
}