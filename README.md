# AUTISM Module Toggle Feedback

Small AUTISM Client addon that adds an independent `Module Toggle Feedback`
boolean setting inside every registered module's existing settings screen.
Settings default to ON:
ON suppresses that module's toggle message, while OFF preserves its normal feedback.
Module state changes, lifecycle callbacks, persistence, commands, errors, and other
client messages remain unchanged.

## Build

From the AUTISM Client repository root:

```powershell
.\gradlew.bat publishToMavenLocal --no-daemon
.\gradlew.bat -p addons/module-toggle-feedback build --no-daemon
```

The addon jar is written to `build/libs/` under this addon.
