package <%= appPackage %>.weather.mvvm.model;

import android.app.Application;

import java.util.List;

import javax.inject.Inject;

import <%= appPackage %>.mvvm.BaseModel;
import <%= appPackage %>.weather.mvvm.model.db.WeatherNowDb;
import <%= appPackage %>.weather.mvvm.model.entry.Location;

/**
 * Created by xiaobailong24 on 2017/7/31.
 * MVVM WeatherModel
 */

public class WeatherModel extends BaseModel {

    @Inject
    public WeatherModel(Application application) {
        super(application);
    }

    //从Room数据库查询所有位置信息
    public List<Location> getAllLocations() {
        return mRepositoryManager
                .obtainRoomDatabase(WeatherNowDb.class, WeatherNowDb.class.getSimpleName())
                .weatherNowDao()
                .getAll();
    }

}
