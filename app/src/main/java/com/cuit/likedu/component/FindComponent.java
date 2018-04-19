package com.cuit.likedu.component;

import com.cuit.likedu.ui.activity.SubCategoryListActivity;
import com.cuit.likedu.ui.activity.SubOtherHomeRankActivity;
import com.cuit.likedu.ui.activity.SubRankActivity;
import com.cuit.likedu.ui.activity.TopCategoryListActivity;
import com.cuit.likedu.ui.activity.TopRankActivity;
import com.cuit.likedu.ui.fragment.SubCategoryFragment;
import com.cuit.likedu.ui.fragment.SubRankFragment;

import dagger.Component;

@Component(dependencies = AppComponent.class)
public interface FindComponent {

    /** 分类 **/
    TopCategoryListActivity inject(TopCategoryListActivity activity);

    SubCategoryListActivity inject(SubCategoryListActivity activity);

    SubCategoryFragment inject(SubCategoryFragment fragment);

    /** 排行 **/
    TopRankActivity inject(TopRankActivity activity);

    SubRankActivity inject(SubRankActivity activity);

    SubOtherHomeRankActivity inject(SubOtherHomeRankActivity activity);

    SubRankFragment inject(SubRankFragment fragment);

}
