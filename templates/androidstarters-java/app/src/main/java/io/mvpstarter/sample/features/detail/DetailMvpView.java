package <%= appPackage %>.features.detail;

import <%= appPackage %>.data.model.response.Pokemon;
import <%= appPackage %>.data.model.response.Statistic;
import <%= appPackage %>.features.base.MvpView;

public interface DetailMvpView extends MvpView {

    void showPokemon(Pokemon pokemon);

    void showStat(Statistic statistic);

    void showProgress(boolean show);

    void showError(Throwable error);
}
