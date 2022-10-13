package com.ztboxs.partnerbox.view.page;

import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.PageSliderProvider;
import ohos.app.Context;

import java.util.List;

/**
 * 每天一点点,天天进步
 *
 * @Author: ztbox
 * @Date: 2022/10/12/14:37
 * @Description:
 */
public class TestPageProvider extends PageSliderProvider {
    // 数据源，每个页面对应list中的一项
    private List<Component> list;
    private Context mContext;

    public TestPageProvider(List<Component> list, Context context) {
        this.list = list;
        this.mContext = context;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    //返回一个页面对象
    @Override
    public Object createPageInContainer(ComponentContainer componentContainer, int i) {
        componentContainer.addComponent(list.get(i));
        return list.get(i);
    }
    @Override
    public void destroyPageFromContainer(ComponentContainer componentContainer, int i, Object o) {
        componentContainer.removeComponent((Component) o);
    }

    //判断是否由对象生成界面
    @Override
    public boolean isPageMatchToObject(Component component, Object o) {
        //可添加具体处理逻辑
        return true;
    }
}
