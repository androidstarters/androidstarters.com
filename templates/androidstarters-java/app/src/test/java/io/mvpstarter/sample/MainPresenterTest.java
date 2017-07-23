package <%= appPackage %>;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import <%= appPackage %>.common.TestDataFactory;
import <%= appPackage %>.data.DataManager;
import <%= appPackage %>.features.main.MainMvpView;
import <%= appPackage %>.features.main.MainPresenter;
import <%= appPackage %>.util.RxSchedulersOverrideRule;
import io.reactivex.Single;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ravindra on 24/12/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    @Rule
    public final RxSchedulersOverrideRule overrideSchedulersRule = new RxSchedulersOverrideRule();

    @Mock
    MainMvpView mockMainMvpView;
    @Mock
    DataManager mockDataManager;
    private MainPresenter mainPresenter;

    @Before
    public void setUp() {
        mainPresenter = new MainPresenter(mockDataManager);
        mainPresenter.attachView(mockMainMvpView);
    }

    @After
    public void tearDown() {
        mainPresenter.detachView();
    }

    @Test
    public void getPokemonReturnsPokemonNames() throws Exception {
        List<String> pokemonList = TestDataFactory.makePokemonNamesList(10);
        when(mockDataManager.getPokemonList(10)).thenReturn(Single.just(pokemonList));

        mainPresenter.getPokemon(10);

        verify(mockMainMvpView, times(2)).showProgress(anyBoolean());
        verify(mockMainMvpView).showPokemon(pokemonList);
        verify(mockMainMvpView, never()).showError(any(Throwable.class));
    }

    @Test
    public void getPokemonReturnsError() throws Exception {
        when(mockDataManager.getPokemonList(10)).thenReturn(Single.error(new RuntimeException()));

        mainPresenter.getPokemon(10);

        verify(mockMainMvpView, times(2)).showProgress(anyBoolean());
        verify(mockMainMvpView).showError(any(Throwable.class));
        verify(mockMainMvpView, never()).showPokemon(ArgumentMatchers.anyList());
    }
}
