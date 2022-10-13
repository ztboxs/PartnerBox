package com.ztboxs.partnerbox.view;

import com.ztboxs.partnerbox.ResourceTable;
import com.ztboxs.partnerbox.view.slice.HomeAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class HomeAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(HomeAbilitySlice.class.getName());
        super.setUIContent(ResourceTable.Layout_home_main);
    }
}
