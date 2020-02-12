plugins {
    java
    kotlin("jvm") version "1.3.21"
    kotlin("kapt") version "1.3.21"
}

group = "net.oxspring.zally.ruleset.sample"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    val zallyVersion = "feat~gh-964-jitpack-support-SNAPSHOT"

    kapt("com.github.zalando.zally:zally-core:$zallyVersion")

    compileOnly(kotlin("stdlib-jdk8"))
    compileOnly("com.github.zalando.zally:zally-core:$zallyVersion")

    testCompile("com.github.zalando.zally:zally-core:$zallyVersion")
    testCompile("com.github.zalando.zally:zally-test:$zallyVersion")
}

kapt {
    includeCompileClasspath = false
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}
