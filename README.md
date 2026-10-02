# AUTISM Module Toggle Feedback

Small AUTISM Client addon that adds an independent `Module Toggle Feedback` boolean setting inside every registered module's existing settings screen.

Settings default to ON:

- **ON** — suppresses that module's enable/disable chat feedback.
- **OFF** — preserves that module's normal toggle feedback.

Module state changes, lifecycle callbacks, persistence, commands, errors, and other client messages remain unchanged.

## Build

This repository contains only the addon. The AUTISM Client source is not included.

The addon requires the AUTISM Client API to be published to your local Maven repository first.

If you have the AUTISM Client source available locally, run:

```powershell
.\gradlew.bat publishToMavenLocal --no-daemon
```

Then, from this addon repository, run:

```powershell
.\gradlew.bat clean build --no-daemon
```

The compiled addon JAR will be written to:

```text
build/libs/
```

## Installation

Copy the generated JAR from `build/libs/` into your Minecraft `mods` folder alongside the compatible AUTISM Client version.