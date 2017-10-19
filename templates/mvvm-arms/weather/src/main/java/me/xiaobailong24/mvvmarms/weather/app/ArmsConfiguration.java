package <%= appPackage %>.weather.app;

import android.content.Context;

import <%= appPackage %>.base.ConfigArms;
import <%= appPackage %>.di.module.ArmsConfigModule;

/**
 * Created by xiaobailong24 on 2017/7/24.
 * Arms 的全局配置信息在此配置,需要将此实现类声明到 AndroidManifest 中
 */
public class ArmsConfiguration implements ConfigArms {

    @Override
    public void applyOptions(Context context, ArmsConfigModule.Builder builder) {
        //自己自定义图片加载逻辑
        //        builder.imageLoaderStrategy(new CustomLoaderStrategy());
    }
}
