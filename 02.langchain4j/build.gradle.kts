plugins {
    id("java")
}

group = "uce.edu.ec"
version = "unspecified"

repositories {
    mavenCentral()
}

val langchain4jVersion = "1.14.0"

dependencies {
    implementation("dev.langchain4j:langchain4j:$langchain4jVersion")
    implementation("dev.langchain4j:langchain4j-open-ai:$langchain4jVersion")
    //implementation("dev.langchain4j:langchain4j-google-ai-gemini:${langchain4jVersion}")
    implementation("org.slf4j:slf4j-simple:2.0.17")
}

tasks.test {
    useJUnitPlatform()
}