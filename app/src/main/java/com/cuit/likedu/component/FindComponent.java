/**
 * Copyright 2016 JustWayward Team
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cuit.likedu.component;

import com.cuit.likedu.ui.activity.SubCategoryListActivity;
import com.cuit.likedu.ui.activity.SubOtherHomeRankActivity;
import com.cuit.likedu.ui.activity.SubRankActivity;
import com.cuit.likedu.ui.activity.SubjectBookListActivity;
import com.cuit.likedu.ui.activity.SubjectBookListDetailActivity;
import com.cuit.likedu.ui.activity.TopCategoryListActivity;
import com.cuit.likedu.ui.activity.TopRankActivity;
import com.cuit.likedu.ui.fragment.SubCategoryFragment;
import com.cuit.likedu.ui.fragment.SubRankFragment;
import com.cuit.likedu.ui.fragment.SubjectFragment;

import dagger.Component;

/**
 * @author yuyh.
 * @date 16/9/1.
 */
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

    /** 主题书单 **/
    SubjectBookListActivity inject(SubjectBookListActivity subjectBookListActivity);

    SubjectFragment inject(SubjectFragment subjectFragment);

    SubjectBookListDetailActivity inject(SubjectBookListDetailActivity categoryListActivity);
}
