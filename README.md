# 🐸 Amphibians App

## 📖 Overview

The Amphibians App is designed to showcase a list of amphibians along with their images and descriptions. It uses Kotlin and modern Android development practices, including Dependency Injection and Jetpack Compose for building the user interface.

## 📦 Project Structure

### `AmphibiansRepository`

```kotlin
/**
 * Repository retrieves amphibian data from underlying data source.
 */
interface AmphibiansRepository {
    /** Retrieves list of amphibians from underlying data source */
    suspend fun getAmphibians(): List<Amphibians>
}
```
### `AppContainer`
```kotlin
interface AppContainer {
    /**
     * Dependency Injection container at the application level.
     */
    val amphibiansRepository: AmphibiansRepository
}
```
The AppContainer interface defines a container for managing dependencies, including the AmphibiansRepository.
### `DefaultAppContainer`
```kotlin
/**
 * Implementation for the Dependency Injection container at the application level.
 *
 * Variables are initialized lazily, and the same instance is shared across the whole app.
 */
class DefaultAppContainer : AppContainer {
    // ...
}
```
The DefaultAppContainer class provides the implementation for the AppContainer interface, including the repository and Retrofit setup.

Data Classes and API Service
The project includes data classes like Amphibians and AmphibiansApiService for representing amphibian data and making network requests.

UI Components
The user interface is built using Jetpack Compose, and it includes components like HomeScreen, LoadingScreen, ErrorScreen, and AmphibianCard for displaying amphibian information.

ViewModels
The AmphibiansViewModel class manages the UI state and fetches data from the repository.

## 🚀 Getting Started
To run the app locally, follow these steps:

1. Clone this repository.
2. Open the project in Android Studio.
3. Build and run the app on an Android emulator or device.

## 🌐 API Endpoint
The app retrieves data from the following API endpoint:
https://android-kotlin-fun-mars-server.appspot.com/amphibians

## 📷 Screenshots
<img width="387" alt="Amphibians" src="https://github.com/TheDavich/AmphibiansApp/assets/87846576/7627f07d-b97b-4d07-a88b-b3a029f68379">
