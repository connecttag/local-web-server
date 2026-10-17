plugins {
    alias(libs.plugins.android.library)
    `maven-publish`
}

group = "org.connecttag.libs.kotlin"
version = "1.0.0"

android {
    namespace = "org.connecttag.services.webserver"
    compileSdk = 36

    defaultConfig {
        minSdk = 26
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }
}

dependencies {
    implementation(libs.nanohttpd)
    implementation(libs.androidx.ktx)
    implementation(libs.javax.inject)
    implementation(libs.timber)
}

publishing {
    publications {
        create<MavenPublication>("release") {
            from(components["release"])
            groupId = "org.connecttag.libs.kotlin"
            artifactId = "local-web-server"
            version = "1.0.0"

            pom {
                name.set("ConnectTag Local Web Server")
                description.set("Lightweight embedded local HTTP web server abstraction for Android powered by NanoHTTPD")
                url.set("https://github.com/connecttag/local-web-server")
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("connecttagye")
                        name.set("Connect Tag")
                        email.set("connecttagye@gmail.com")
                    }
                }
                scm {
                    connection.set("scm:git:https://github.com/connecttag/local-web-server.git")
                    developerConnection.set("scm:git:ssh://git@github.com:connecttag/local-web-server.git")
                    url.set("https://github.com/connecttag/local-web-server/tree/main")
                }
            }
        }
    }
}
