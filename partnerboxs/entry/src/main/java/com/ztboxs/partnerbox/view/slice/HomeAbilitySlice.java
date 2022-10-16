package com.ztboxs.partnerbox.view.slice;

import com.google.gson.reflect.TypeToken;
import com.ztboxs.partnerbox.ResourceTable;
import com.ztboxs.partnerbox.Utils.CommonUtil;
import com.ztboxs.partnerbox.dome.HomeContentDO;
import com.ztboxs.partnerbox.dome.HomeTitleDO;
import com.ztboxs.partnerbox.provider.HomeContentProvider;
import com.ztboxs.partnerbox.provider.HomeProvider;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.components.ListContainer;
import java.util.List;
import java.util.stream.Collectors;

public class HomeAbilitySlice extends AbilitySlice {

    ListContainer homeTitle;
    ListContainer homeContent;
    List<HomeContentDO> data;
    HomeContentProvider homeContentProvider;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_home_main);
        initView();
        initHomeTitle();
        inithomeContent();
    }

    private void initView() {
        homeTitle = (ListContainer) findComponentById(ResourceTable.Id_hone_title);
        homeContent = (ListContainer) findComponentById(ResourceTable.Id_home_content);
    }

    private void initHomeTitle() {
        String path = "entry/resources/rawfile/news_type_datas.json";
        String homeTitleStr = CommonUtil.readRawToString(this,path);
        TypeToken token = new TypeToken<List<HomeTitleDO>>() {};
        List<HomeTitleDO>  data = CommonUtil.parseJsonArray(homeTitleStr,token);
        HomeProvider homeTitleProvider = new HomeProvider(data,this);
        homeTitle.setItemProvider(homeTitleProvider);
        homeTitleProvider.notifyDataChanged();
        homeTitle.setItemClickedListener(this::showData);
    }
//    -----------------------------------
        public  void  showData(ListContainer listContainer,
                               Component component, int i, long l) {
            //获取点击的数据

            HomeTitleDO item = (HomeTitleDO) listContainer.getItemProvider().getItem(i);
            //过虑数据
            List<HomeContentDO> content = data.stream()
                    .filter(homecontent -> homecontent.getType().equals(item.getName()))
                    .collect(Collectors.toList());
            //设置数据，并通知数据变更
            homeContentProvider.setDatas(content);
            homeContentProvider.notifyDataChanged();

        }

            private void inithomeContent() {
                // 实体类，Provider，数据源
                String path = "entry/resources/rawfile/news_datas.json";
                String homeContentStr = CommonUtil.readRawToString(this, path);
                // 用于解析JSON数据，把JSON数据转换成对象
                TypeToken token = new TypeToken<List<HomeContentDO>>() {};
                data = CommonUtil.parseJsonArray(homeContentStr, token);
                homeContentProvider = new HomeContentProvider(data, this);
                homeContent.setItemProvider(homeContentProvider);
                homeContentProvider.notifyDataChanged();

                homeContent.setItemClickedListener(this::gotoDetails);
            }
            public  void  gotoDetails(ListContainer listContainer,
                                      Component component,int i,long l){
                //获取点击的数据

                HomeContentDO item =(HomeContentDO) listContainer.getItemProvider().getItem(i);
                Intent intent = new Intent();
//                 intent.setParam("news",item);
                //Slice 间跳转
//                present(new NewsDetailsAbilitySlice(),intent);
                //presentForResult()  跳转  并由返回值
//                intent = new Intent();
                intent.setParam("news",item);
                /**
                 * Slice之间跳转
                 * intent.setParam()传值
                 * presentForResult();跳转，并返回值
                 */
                present(new NewsDetailsAbilitySlice(), intent);
            }



//------------------------------------------


    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
