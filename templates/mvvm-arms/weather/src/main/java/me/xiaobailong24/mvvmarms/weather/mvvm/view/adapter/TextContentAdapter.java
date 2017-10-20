package <%= appPackage %>.weather.mvvm.view.adapter;

import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import java.util.List;

import <%= appPackage %>.mvvm.binding.BaseBindAdapter;
import <%= appPackage %>.mvvm.binding.BaseBindHolder;
import <%= appPackage %>.weather.BR;
import <%= appPackage %>.weather.mvvm.model.pojo.TextContent;

/**
 * @author xiaobailong24
 * @date 2017/6/28
 * RecyclerView DataBinding Adapter
 */
public class TextContentAdapter extends BaseBindAdapter<TextContent> {

    public TextContentAdapter(@LayoutRes int layoutResId, @Nullable List<TextContent> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseBindHolder helper, TextContent item) {
        ViewDataBinding binding = helper.getBinding();
        binding.setVariable(BR.content, item);
        binding.executePendingBindings();
    }

}
