package com.ztboxs.partnerbox.view;

import com.ztboxs.partnerbox.ResourceTable;
import com.ztboxs.partnerbox.view.slice.TeamAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class TeamAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(TeamAbilitySlice.class.getName());
        super.setUIContent(ResourceTable.Layout_team_main);
    }
}
