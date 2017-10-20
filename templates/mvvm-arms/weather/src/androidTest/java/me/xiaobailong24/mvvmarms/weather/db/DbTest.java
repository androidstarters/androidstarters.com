package <%= appPackage %>.weather.db;

import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;

import org.junit.After;
import org.junit.Before;

import <%= appPackage %>.weather.mvvm.model.db.WeatherNowDb;

/**
 * @author xiaobailong24
 * @date 2017/7/30
 * Room Database Test
 */
public abstract class DbTest {
    protected WeatherNowDb db;

    @Before
    public void initDb() {
        db = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
                WeatherNowDb.class).build();
    }

    @After
    public void closeDb() {
        db.close();
    }
}
