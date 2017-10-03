package <%= appPackage %>.data

import <%= appPackage %>.data.model.Pokemon
import <%= appPackage %>.data.remote.PokemonApi
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataManager @Inject
constructor(private val pokemonApi: PokemonApi) {

    fun getPokemonList(limit: Int): Single<List<String>> {
        return pokemonApi.getPokemonList(limit)
                .toObservable()
                .flatMapIterable { (results) -> results }
                .map { (name) -> name }
                .toList()
    }

    fun getPokemon(name: String): Single<Pokemon> {
        return pokemonApi.getPokemon(name)
    }
}