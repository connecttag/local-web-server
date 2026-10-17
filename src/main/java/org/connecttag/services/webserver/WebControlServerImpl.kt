package org.connecttag.services.webserver

import android.content.Context
import fi.iki.elonen.NanoHTTPD
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

public interface WebServerDelegate {
    public fun handleRequest(session: NanoHTTPD.IHTTPSession): NanoHTTPD.Response?
}

@Singleton
public class WebControlServerImpl @Inject constructor(
    private val delegate: WebServerDelegate
) : NanoHTTPD(8080), ILocalWebServer {

    override fun serve(session: IHTTPSession): Response {
        return delegate.handleRequest(session) ?: newFixedLengthResponse(Response.Status.NOT_FOUND, "text/plain", "Not Handled")
    }

    override fun start() {
        try {
            start(SOCKET_READ_TIMEOUT, false)
            Timber.d("WebControlServer started on port 8080")
        } catch (e: Exception) {
            Timber.e(e, "Failed to start WebControlServer")
        }
    }

    override fun stop() {
        super.stop()
        Timber.d("WebControlServer stopped")
    }

    override fun isRunning(): Boolean = wasStarted() && isAlive
}
