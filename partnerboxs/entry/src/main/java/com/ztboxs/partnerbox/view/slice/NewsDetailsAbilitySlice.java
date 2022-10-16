package com.ztboxs.partnerbox.view.slice;


import com.ztboxs.partnerbox.ResourceTable;
import com.ztboxs.partnerbox.Utils.CommonUtil;
import com.ztboxs.partnerbox.dome.HomeContentDO;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.components.Image;
import ohos.agp.components.ListContainer;
import ohos.agp.components.Text;
import ohos.media.image.PixelMap;

import java.io.Serializable;

public class NewsDetailsAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_team_main);
        this.initData(intent);
    }

    private void initData(Intent intent) {
        //取值,与传值的类型一致，这里实体表已经序列化了
        HomeContentDO news = intent.getSerializableParam("news");
        if (news==null) {
            return;
        }
        Text titleText = (Text) findComponentById(ResourceTable.Id_news_title_name_txt);
        titleText.setText(news.getTitle());
        Text readText = (Text) findComponentById(ResourceTable.Id_news_read_txt);
        readText.setText("reads:"+news.getReads());
        Text likeText = (Text) findComponentById(ResourceTable.Id_news_like_txt);
        likeText.setText("likes"+news.getLikes());
        Text infoText = (Text) findComponentById(ResourceTable.Id_news_info_txt);
        infoText.setText(news.getContent());
        Image image = (Image) findComponentById(
                ResourceTable.Id_news_img);
        PixelMap imgData = CommonUtil.getPixelMapFromPath(
                this, news.getImgUrl());
        image.setPixelMap(imgData);
    }

}
