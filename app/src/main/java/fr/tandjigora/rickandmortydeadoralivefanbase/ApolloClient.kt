package fr.tandjigora.rickandmortydeadoralivefanbase

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.okHttpClient
import okhttp3.OkHttpClient

private var instance: ApolloClient? = null
private const val BASE_URL: String = "https://rickandmortyapi.com/graphql"

fun apolloClient(): ApolloClient {
    if (instance != null) {
        return instance!!
    }

    val okHttpClient = OkHttpClient.Builder()
        .build()

    instance = ApolloClient.Builder()
        .serverUrl(BASE_URL)
        .okHttpClient(okHttpClient)
        .build()

    return instance!!
}