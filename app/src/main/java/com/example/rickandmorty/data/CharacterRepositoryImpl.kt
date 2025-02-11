package com.example.rickandmorty.data

import android.util.Log
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.exception.ApolloException
import com.example.rickandmorty.GetCharactersQuery
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val apolloClient: ApolloClient
) : CharacterRepository {

    override suspend fun getCharacters(): List<GetCharactersQuery.Result>? {
        return withContext(Dispatchers.IO) {
            try {
                val response = apolloClient.query(GetCharactersQuery()).execute()
                if (response.hasErrors()) {
                    Log.w("GraphQL", "Error in query: ${response.errors}")
                    return@withContext emptyList()
                }

                response.data?.characters?.results?.filterNotNull() ?: emptyList()

            } catch (e: ApolloException) {
                Log.e("ApolloClient", "Error in GraphQL request: ${e.message}", e)
                emptyList()

            } catch (e: Exception) {
                Log.e("Repository", "Unknown error in CharacterRepositoryImpl", e)
                emptyList()
            }
        }
    }
}
