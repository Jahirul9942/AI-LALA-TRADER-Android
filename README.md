# AI LALA TRADER — Android starter v0.2.0

Focused on EUR/USD (OTC), 30-second demo/paper-trading workflow.

## Current status
- Android native starter UI updated for EUR/USD (OTC).
- Demo/paper mode only; no real orders, deposits, or account automation.
- No market-data provider is connected yet.
- No BUY/SELL signal is generated until a verified feed and tested logic are available.
- Quotex OTC feed/API access has not been verified.

## Build APK
Open this folder in Android Studio, sync Gradle, then choose **Build > Build Bundle(s) / APK(s) > Build APK(s)**.
The debug APK will be at `app/build/outputs/apk/debug/app-debug.apk`.

The GitHub Actions workflow can also build a debug APK after the project is pushed to a repository.
