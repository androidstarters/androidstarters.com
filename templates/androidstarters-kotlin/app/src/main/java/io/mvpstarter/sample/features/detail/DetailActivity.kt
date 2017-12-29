package <%= appPackage %>.features.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import <%= appPackage %>.R
import <%= appPackage %>.data.model.Pokemon
import <%= appPackage %>.data.model.Statistic
import <%= appPackage %>.features.base.BaseActivity
import <%= appPackage %>.features.common.ErrorView
import <%= appPackage %>.features.detail.widget.StatisticView
import <%= appPackage %>.util.gone
import <%= appPackage %>.util.loadImageFromUrl
import <%= appPackage %>.util.visible
import kotlinx.android.synthetic.main.activity_detail.*
import timber.log.Timber
import javax.inject.Inject

class DetailActivity : BaseActivity(), DetailMvpView, ErrorView.ErrorListener {

    @Inject lateinit var detailPresenter: DetailPresenter

    private var pokemonName: String? = null

    companion object {
        val EXTRA_POKEMON_NAME = "EXTRA_POKEMON_NAME"

        fun getStartIntent(context: Context, pokemonName: String): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXTRA_POKEMON_NAME, pokemonName)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent().inject(this)
        detailPresenter.attachView(this)

        pokemonName = intent.getStringExtra(EXTRA_POKEMON_NAME)
        if (pokemonName == null) {
            throw IllegalArgumentException("Detail Activity requires a pokemon name@")
        }

        setSupportActionBar(detail_toolbar)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        title = "${pokemonName?.substring(0, 1)?.toUpperCase()}${pokemonName?.substring(1)}"

        errorView?.setErrorListener(this)

        detailPresenter.getPokemon(pokemonName as String)
    }

    override fun layoutId() = R.layout.activity_detail

    override fun showPokemon(pokemon: Pokemon) {
        if (pokemon.sprites.frontDefault != null) {
            imagePokemon?.loadImageFromUrl(pokemon.sprites.frontDefault as String)
        }
        layoutPokemon?.visible()
    }

    override fun showStat(statistic: Statistic) {
        val statisticView = StatisticView(this)
        statisticView.setStat(statistic)
        layoutStats?.addView(statisticView)
    }

    override fun showProgress(show: Boolean) {
        errorView?.gone()
        progress?.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun showError(error: Throwable) {
        layoutPokemon?.gone()
        errorView?.visible()
        Timber.e(error, "There was a problem retrieving the pokemon...")
    }

    override fun onReloadData() {
        detailPresenter.getPokemon(pokemonName as String)
    }

    override fun onDestroy() {
        super.onDestroy()
        detailPresenter.detachView()
    }
}