# AUTISM Module Toggle Feedback

Small AUTISM Client addon that adds a `Module Toggle Feedback` boolean setting.
It defaults to ON. When OFF, only the chat message emitted by `Module.setEnabled` is suppressed; module state changes, lifecycle callbacks, persistence, commands, errors, and other client messages remain unchanged.

## Build

From the AUTISM Client repository root:

```powershell
.\gradlew.bat publishToMavenLocal --no-daemon
.\gradlew.bat -p addons/module-toggle-feedback build --no-daemon
```

The addon jar is written to `build/libs/` under this addon.
