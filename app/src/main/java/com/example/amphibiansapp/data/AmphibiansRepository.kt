package com.example.amphibiansapp.data

import com.example.amphibiansapp.model.Amphibians
import com.example.amphibiansapp.network.AmphibiansApiService

/**
 * Repository retrieves amphibian data from underlying data source.
 */
interface AmphibiansRepository {
    /** Retrieves list of amphibians from underlying data source */
    suspend fun getAmphibians(): List<Amphibians>
}

/**
 * Network Implementation of repository that retrieves amphibian data from underlying data source.
 */
class DefaultAmphibiansRepository(
    private val amphibiansApiService: AmphibiansApiService
) : AmphibiansRepository {
    /** Retrieves list of amphibians from underlying data source */
    override suspend fun getAmphibians(): List<Amphibians> = amphibiansApiService.getAmphibians()
}
