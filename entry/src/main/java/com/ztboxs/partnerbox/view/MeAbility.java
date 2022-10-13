package com.ztboxs.partnerbox.view;

import com.ztboxs.partnerbox.ResourceTable;
import com.ztboxs.partnerbox.view.slice.MeAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class MeAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(MeAbilitySlice.class.getName());
        super.setUIContent(ResourceTable.Layout_me_main);
    }
}
