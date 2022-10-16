package com.ztboxs.partnerbox.view.slice;

import com.ztboxs.partnerbox.ResourceTable;
import com.ztboxs.partnerbox.Utils.CommonUtil;
import com.ztboxs.partnerbox.dome.HomeContentDO;
import com.ztboxs.partnerbox.dome.HomeTitleDO;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Image;
import ohos.agp.components.Text;
import ohos.media.image.PixelMap;

/**
 * 每天一点点,天天进步
 *
 * @Author: ztbox
 * @Date: 2022/10/13/15:16
 * @Description:
 */
public class domeData  extends AbilitySlice{

        @Override
        public void onStart(Intent intent) {
            super.onStart(intent);
            super.setUIContent(ResourceTable.Layout_home_main);
            this.initData(intent);
        }

        private void initData(Intent intent) {
            //取值,与传值的类型一致，这里实体表已经序列化了
            HomeTitleDO news = intent.getSerializableParam("news");
            if (news==null) {
                return;
            }
            Text titleText = (Text) findComponentById(ResourceTable.Id_hone_title);
            titleText.setText(news.getName());
//            Text readText = (Text) findComponentById(ResourceTable.Id_news_read_txt);
//            readText.setText("reads:"+news.getReads());
//            Text likeText = (Text) findComponentById(ResourceTable.Id_news_like_txt);
//            likeText.setText("likes"+news.getLikes());
//            Text infoText = (Text) findComponentById(ResourceTable.Id_news_info_txt);
//            infoText.setText(news.getContent());
//            Image image = (Image) findComponentById(
//                    ResourceTable.Id_news_img);
//            PixelMap imgData = CommonUtil.getPixelMapFromPath(
//                    this, news.getImgUrl());
//            image.setPixelMap(imgData);
        }

}
