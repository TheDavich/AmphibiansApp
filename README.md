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

