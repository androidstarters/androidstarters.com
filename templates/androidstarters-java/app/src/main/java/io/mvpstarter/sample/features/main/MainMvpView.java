package <%= appPackage %>.features.main;

import java.util.List;

import <%= appPackage %>.features.base.MvpView;

public interface MainMvpView extends MvpView {

    void showPokemon(List<String> pokemon);

    void showProgress(boolean show);

    void showError(Throwable error);
}
