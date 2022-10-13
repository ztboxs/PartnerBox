package com.ztboxs.partnerbox;

import com.ztboxs.partnerbox.slice.MainAbilitySlice;
import com.ztboxs.partnerbox.view.HomeAbility;
import com.ztboxs.partnerbox.view.MeAbility;
import com.ztboxs.partnerbox.view.TeamAbility;
import com.ztboxs.partnerbox.view.page.TestPageProvider;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.agp.components.*;

import java.util.ArrayList;
import java.util.List;

public class MainAbility extends Ability {


    private RadioContainer radioContainer;
    private RadioButton rb_home;
    private RadioButton rb_team;
    private RadioButton rb_me;
    private DirectionalLayout home, team,me;
    private PageSlider pageSlider;
    private LayoutScatter layoutScatter;
    private List<Component> pageViews;


    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(MainAbilitySlice.class.getName());
        super.setUIContent(ResourceTable.Layout_ability_main);
        initView();

    }

    private void initView() {
        radioContainer = (RadioContainer) findComponentById(ResourceTable.Id_table_list);
        rb_home = (RadioButton) findComponentById(ResourceTable.Id_home_icons);
        rb_team = (RadioButton) findComponentById(ResourceTable.Id_tame_icons);
        rb_me = (RadioButton) findComponentById(ResourceTable.Id_me_icons);
        initPageSlider();
    }

    private void initPageSlider() {
        pageSlider = (PageSlider) findComponentById(ResourceTable.Id_vpager);
        layoutScatter = LayoutScatter.getInstance(getContext());
        home = (DirectionalLayout) layoutScatter.parse(ResourceTable.Layout_home_main,null,false);
        team = (DirectionalLayout) layoutScatter.parse(ResourceTable.Layout_team_main,null,false);
        me = (DirectionalLayout) layoutScatter.parse(ResourceTable.Layout_me_main,null,false);
        pageViews = new ArrayList<>();
        pageViews.add(home);
        pageViews.add(team);
        pageViews.add(me);
        //设置provider
        pageSlider.setProvider(new TestPageProvider(pageViews, this));
        //添加监听事件
        pageSlider.addPageChangedListener(new PageSlider.PageChangedListener() {
            @Override
            public void onPageSliding(int i, float v, int i1) {

            }

            @Override
            public void onPageSlideStateChanged(int i) {

            }

            @Override
            public void onPageChosen(int i) {
                ((RadioButton) radioContainer.getComponentAt(i)).setChecked(true);
            }
        });
        radioContainer.setMarkChangedListener((radioContainer, i) -> pageSlider.setCurrentPage(i));
    }

}
