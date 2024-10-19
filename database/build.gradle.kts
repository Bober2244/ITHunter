plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.androidX.room)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "dev.bober.database"

    compileSdk = libs.versions.compileSdk.get().toInt()

    kotlinOptions {
        jvmTarget = "11"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    room {
        schemaDirectory("$projectDir/schemas")
    }
}
dependencies {
    //Room
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    annotationProcessor(libs.androidx.room.compiler)
    ksp(libs.androidx.room.compiler)
    //Koin
    implementation(libs.koin.android)
    //Features
    implementation(projects.domain)
    //Serialization
    implementation(libs.kotlinx.serialization.json)
}