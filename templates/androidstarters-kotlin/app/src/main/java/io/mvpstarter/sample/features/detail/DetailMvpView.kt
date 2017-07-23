package <%= appPackage %>.features.detail

import <%= appPackage %>.data.model.Pokemon
import <%= appPackage %>.data.model.Statistic
import <%= appPackage %>.features.base.MvpView

interface DetailMvpView : MvpView {

    fun showPokemon(pokemon: Pokemon)

    fun showStat(statistic: Statistic)

    fun showProgress(show: Boolean)

    fun showError(error: Throwable)

}