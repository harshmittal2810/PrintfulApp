package com.harsh.printfulapp.ui.repo

import kotlinx.coroutines.flow.MutableStateFlow
import java.io.*
import java.net.InetAddress
import java.net.Socket

class TcpClient {
    private var running = false
    private var bufferOut: PrintWriter? = null
    private var bufferIn: BufferedReader? = null

    private fun sendMessage(message: String) {
        if (bufferOut != null && !bufferOut!!.checkError()) {
            bufferOut?.println(message)
            bufferOut?.flush()
        }
    }

    fun run(messageStateFlow: MutableStateFlow<String>) {
        running = true
        try {
            val serverAddress = InetAddress.getByName(SERVER_IP)
            val socket = Socket(serverAddress, SERVER_PORT)

            try {
                bufferOut =
                    PrintWriter(BufferedWriter(OutputStreamWriter(socket.getOutputStream())), true)
                bufferIn = BufferedReader(InputStreamReader(socket.getInputStream()))
                sendMessage(AUTH_MSG)

                while (running) {
                    messageStateFlow.value = bufferIn!!.readLine()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                socket.close()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    companion object {
        const val SERVER_IP = "ios-test.printful.lv"
        const val SERVER_PORT = 6111
        const val AUTH_MSG = "AUTHORIZE <mittalharsh2810@gmail.com>"
    }
}