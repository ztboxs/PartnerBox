package com.ztboxs.partnerbox.provider;

import com.ztboxs.partnerbox.ResourceTable;
import com.ztboxs.partnerbox.Utils.CommonUtil;
import com.ztboxs.partnerbox.dome.HomeContentDO;
import com.ztboxs.partnerbox.dome.HomeTitleDO;
import ohos.aafwk.ability.AbilitySlice;
import ohos.agp.components.*;
import ohos.media.image.PixelMap;

import java.util.List;

/**
 *
 *
 * @Author: ztbox
 * @Date: 2022/10/12/22:51
 * @Description:
 */
public class HomeContentProvider extends BaseItemProvider {
   private List<HomeContentDO>  datas;
   private AbilitySlice slice;
   private Text text;

    public HomeContentProvider(List<HomeContentDO> datas, AbilitySlice slice){
       this.datas = datas;
       this.slice = slice;
   }

   public void setDatas(List<HomeContentDO> datas){
        this.datas = datas;
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
    public Component getComponent(int i, Component component,
                                  ComponentContainer container) {
        Component c = component;
        if (c == null) {
            c = LayoutScatter.getInstance(slice)
                    .parse(ResourceTable.Layout_item_home_content,
                            null, false);
        }
        HomeContentDO item = (HomeContentDO) getItem(i);
        Text text = (Text) c.findComponentById(
                ResourceTable.Id_home_info_title_txt);
        text.setText(item.getTitle());
        Image image = (Image) c.findComponentById(
                ResourceTable.Id_home_info_img);
        PixelMap imgData = CommonUtil.getPixelMapFromPath(
                slice, item.getImgUrl());
        image.setPixelMap(imgData);
        return c;
    }
}
