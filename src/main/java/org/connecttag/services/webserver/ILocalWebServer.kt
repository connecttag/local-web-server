package org.connecttag.services.webserver

public interface ILocalWebServer {
    public fun start()
    public fun stop()
    public fun isRunning(): Boolean
}
