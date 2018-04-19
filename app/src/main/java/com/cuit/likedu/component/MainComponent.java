package com.cuit.likedu.component;

import com.cuit.likedu.ui.activity.MainActivity;
import com.cuit.likedu.ui.activity.SettingActivity;
import com.cuit.likedu.ui.activity.WifiBookActivity;
import com.cuit.likedu.ui.fragment.RecommendFragment;

import dagger.Component;

@Component(dependencies = AppComponent.class)
public interface MainComponent {
    MainActivity inject(MainActivity activity);

    RecommendFragment inject(RecommendFragment fragment);

    SettingActivity inject(SettingActivity activity);
    WifiBookActivity inject(WifiBookActivity activity);
}