# AUTISM Module Toggle Feedback

A small client-side addon for **AUTISM Client** that lets you control module toggle chat feedback individually.

For every registered AUTISM module, the addon adds a `Module Toggle Feedback` setting inside that module's existing settings screen.

### How it works

- **ON** — suppresses that module's enable/disable chat feedback.
- **OFF** — keeps that module's normal toggle feedback.
- The module itself continues to enable and disable normally.
- Each module has its own independent setting.
- Modules are discovered automatically through AUTISM Client's module registry.
- No module names are hardcoded.

## Download

[**Download the latest release →**](../../releases/latest)

Compiled JARs are provided through GitHub Releases.

## Requirements

- Minecraft 26.2
- Java 25+
- Fabric Loader
- Fabric API
- [AUTISM Client](https://github.com/AutismDevelopment/Autism-Client)
- Compatible AUTISM Client version

## Install

1. Download the latest JAR from [Releases](../../releases/latest).
2. Place the JAR in your Minecraft `mods` folder.
3. Make sure the compatible AUTISM Client version is also installed.
4. Launch Minecraft.
5. Open a module's settings to find `Module Toggle Feedback`.

## Build

This repository contains only the addon source. The AUTISM Client source is not included.

The compatible AUTISM Client API must be available in your local Maven repository before building.

### Publish the AUTISM Client API

From your local AUTISM Client source:

```powershell
.\gradlew.bat publishToMavenLocal --no-daemon
```

### Build the addon

From this repository:

```powershell
.\gradlew.bat clean build --no-daemon
```

The compiled JAR is generated in:

```text
build/libs/
```

The `build/` directory is ignored by Git and is not included in the source repository.

## Development

The addon uses the AUTISM Client module registry to automatically discover registered modules.

Each module receives its own independent feedback setting. New modules can be detected without manually adding their names to the addon.

The addon does not replace or modify the module's normal enable/disable behavior. It only controls whether the corresponding toggle feedback message is displayed.

## Releases

Release builds are published through the GitHub [Releases](../../releases) page.

The repository contains the source code, while compiled JARs are distributed as release assets.

## License

See [LICENSE](LICENSE).