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

- GlassifiedCard and CustomGlassifiedCard for more customizations
<div style="display: flex; gap: 10px;">
  <img src="https://github.com/user-attachments/assets/68a011e6-5786-4fd9-93ff-4ec819a93207" alt="Glassified UI 1" width="300"/>
  <img src="https://github.com/user-attachments/assets/4f3905ee-2c88-43c9-a3ee-770ee70362f1" alt="Glassified UI 2" width="300"/>
      <img src="https://github.com/user-attachments/assets/d4447488-81c7-4c49-b239-05adcec996d1" alt="Glassified UI 2" width="300"/>
     <img src="https://github.com/user-attachments/assets/0847ea83-b966-44fb-8a42-8ad53951b14f" alt="Glassified UI 2" width="300"/>
</div>






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
