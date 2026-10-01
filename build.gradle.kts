plugins {
    alias(libs.plugins.fabric.loom)
}

base {
    archivesName = properties["archives_base_name"] as String
    version = libs.versions.mod.version.get()
    group = properties["maven_group"] as String
}

repositories {
    mavenLocal()
    maven("https://maven.fabricmc.net/") { name = "Fabric" }
    mavenCentral()
}

dependencies {
    minecraft(libs.minecraft)
    implementation(libs.fabric.loader)
    implementation(libs.fabric.api)
    implementation(libs.autism)
}

fun toMinecraftCompat(version: String): String {
    val match = Regex("""^(\\d+)\\.(\\d+)(?:\\.(\\d+))?$""").matchEntire(version)
        ?: return version
    val (year, drop, _) = match.destructured
    return "~$year.$drop"
}

tasks {
    processResources {
        val propertyMap = mapOf(
            "version" to project.version,
            "mc_compat" to toMinecraftCompat(libs.versions.minecraft.get()),
            "fabric_api_version" to libs.versions.fabric.api.get(),
            "autism_api_version" to libs.versions.autism.runtime.get()
        )
        inputs.properties(propertyMap)
        filteringCharset = "UTF-8"
        filesMatching("fabric.mod.json") { expand(propertyMap) }
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_25
        targetCompatibility = JavaVersion.VERSION_25
        toolchain { languageVersion.set(JavaLanguageVersion.of(25)) }
    }

    withType<JavaCompile> {
        options.encoding = "UTF-8"
        options.release.set(25)
    }
}
