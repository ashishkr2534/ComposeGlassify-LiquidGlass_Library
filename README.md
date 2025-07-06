# ✨ Glassified UI Components for Jetpack Compose

A modern and elegant library of **glassmorphic UI components** for Android 12+ built using **Jetpack Compose** and **Material 3** design principles.

This library provides ready-to-use, customizable components like **BottomBar**, **Chip**, **Switch**, **Snackbar**, and **Card** with blurred backgrounds and frosted-glass effects.

---

## 📦 Features

- 🧊 **Glassmorphism Blur** using `RenderEffect` (Android 12+)
- 🌈 **Gradient Backgrounds**
- 🟦 **Rounded Corners & Border Support**
- ⚡ **Material 3 Theming**
- 🧩 **Composable-friendly APIs**
- 📱 **Responsive & Touch-friendly**
- ✅ **All components offer full control & customization**

---

## 🛠️ Requirements

- **Minimum SDK**: 31 (Android 12 / S)
- **Jetpack Compose BOM**: Compatible with latest stable Compose versions
- **Material 3**: Required for theming and styling

---

## 🚀 Installation

> 📦 Coming soon to Maven Central or JitPack

For now, include the module manually in your `settings.gradle` and `build.gradle`.

```kotlin
// settings.gradle.kts
include(":glassified-ui")

// app/build.gradle.kts
dependencies {
    implementation(project(":glassified-ui"))
}
