plugins {
    alias(libs.plugins.blossom)
    alias(libs.plugins.shadowJar)
    java
}

group = "net.bitbylogic"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.minestom)
    implementation(libs.bundles.polar)
}

tasks {
    shadowJar {
        manifest {
            attributes("Main-Class" to "net.bitbylogic.polarconverter.PolarConverter")
        }
        archiveBaseName.set(rootProject.name)
        archiveClassifier.set("")
        archiveVersion.set(project.version.toString())
        mergeServiceFiles()
    }

    build {
        dependsOn("shadowJar")
    }
}
