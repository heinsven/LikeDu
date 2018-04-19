package com.cuit.likedu.component;

import com.cuit.likedu.ui.activity.BookDiscussionDetailActivity;
import com.cuit.likedu.ui.activity.BookReviewDetailActivity;
import com.cuit.likedu.ui.fragment.BookDiscussionFragment;
import com.cuit.likedu.ui.fragment.BookReviewFragment;

import dagger.Component;

@Component(dependencies = AppComponent.class)
public interface CommunityComponent {

    BookDiscussionFragment inject(BookDiscussionFragment fragment);

    BookDiscussionDetailActivity inject(BookDiscussionDetailActivity activity);

    BookReviewFragment inject(BookReviewFragment fragment);

    BookReviewDetailActivity inject(BookReviewDetailActivity activity);

}
