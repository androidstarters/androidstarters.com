package <%= appPackage %>.injection.component

import android.app.Application
import android.content.Context
import dagger.Component
import <%= appPackage %>.data.DataManager
import <%= appPackage %>.data.remote.PokemonApi
import <%= appPackage %>.injection.ApplicationContext
import <%= appPackage %>.injection.module.AppModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    @ApplicationContext
    fun context(): Context

    fun application(): Application

    fun dataManager(): DataManager

    fun pokemonApi(): PokemonApi
}
