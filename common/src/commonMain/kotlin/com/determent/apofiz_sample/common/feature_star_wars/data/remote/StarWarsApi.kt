package com.determent.apofiz_sample.common.feature_star_wars.data.remote


import com.determent.apofiz_sample.common.feature_star_wars.data.model.PersonModel
import de.jensklingenberg.ktorfit.Call
import de.jensklingenberg.ktorfit.Response
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path
import de.jensklingenberg.ktorfit.http.Query
import kotlinx.coroutines.flow.Flow

interface StarWarsApi {
    companion object {
        const val baseUrl = "https://swapi.info/api/"
    }

    @GET("people/{id}/")
    suspend fun getPersonByIdResponse(@Path("id") peopleId: Int): PersonModel

    @GET("people/{id}/")
    fun getPeopleByIdFlowResponse(@Path("id") peopleId: Int, @Query("hello") world: String?): Flow<PersonModel>

    @GET("people/{id}/")
    fun getPeopleByIdCallResponse(@Path("id") peopleId: Int): Call<PersonModel>


    @GET("people/{id}/")
    fun queryTest(@Path("id") peopleId: Int, @Query("hello") world: String?): Call<PersonModel>

    @GET("people/{id}/")
    suspend fun getPersonResponse(@Path("id") personId: Int): Response<PersonModel>
}