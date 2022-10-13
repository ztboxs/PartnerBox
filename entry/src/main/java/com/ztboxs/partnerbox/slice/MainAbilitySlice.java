package com.ztboxs.partnerbox.slice;

import com.ztboxs.partnerbox.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.RadioButton;

public class MainAbilitySlice extends AbilitySlice {
    private RadioButton rb_home;
    private RadioButton rb_team;
    private RadioButton rb_me;
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);

        rb_home = (RadioButton) findComponentById(ResourceTable.Id_home_icons);
        rb_team = (RadioButton) findComponentById(ResourceTable.Id_tame_icons);
        rb_me = (RadioButton) findComponentById(ResourceTable.Id_me_icons);

    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
