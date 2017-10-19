package <%= appPackage %>.base;

import <%= appPackage %>.di.component.ArmsComponent;
import <%= appPackage %>.di.module.ArmsModule;

/**
 * Created by xiaobailong24 on 2017/9/30.
 * Application 继承该接口，就可以具有 ArmsComponent 提供的方法。
 */
public interface IArms {
    /**
     * Description: 获得全局 ArmsComponent
     *
     * @return ArmsComponent
     */
    ArmsComponent getArmsComponent();


    /**
     * Description: 获得全局 ArmsModule 重用
     *
     * @return ArmsModule
     */
    ArmsModule getArmsModule();
}
