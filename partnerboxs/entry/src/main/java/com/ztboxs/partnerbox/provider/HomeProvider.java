package com.ztboxs.partnerbox.provider;

import com.ztboxs.partnerbox.ResourceTable;
import com.ztboxs.partnerbox.dome.HomeTitleDO;
import ohos.aafwk.ability.AbilitySlice;
import ohos.agp.components.*;

import java.util.List;

/**
 * 每天一点点,天天进步
 *
 * @Author: ztbox
 * @Date: 2022/10/12/22:51
 * @Description:
 */
public class HomeProvider extends BaseItemProvider {
   private List<HomeTitleDO>  datas;
   private AbilitySlice slice;
    private Text text;

    public HomeProvider(List<HomeTitleDO> datas, AbilitySlice slice){
       this.datas = datas;
       this.slice = slice;
   }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
   }

    @Override
    public Object getItem(int i) {
        return  datas == null ? null : datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public Component getComponent(int i, Component component, ComponentContainer componentContainer) {
       Component c = component;
        if (c == null) {
            c = LayoutScatter.getInstance(slice)
                    .parse(ResourceTable.Layout_item_home_title,null,false);
        }
        HomeTitleDO item = (HomeTitleDO) getItem(i);
        text = (Text) c.findComponentById(ResourceTable.Id_item_home_title);
        text.setText(item.getName());
        return c;
    }
}
