package com.cuit.likedu.component;

import com.cuit.likedu.ui.activity.BookDetailActivity;
import com.cuit.likedu.ui.activity.BookSourceActivity;
import com.cuit.likedu.ui.activity.BooksByTagActivity;
import com.cuit.likedu.ui.activity.ReadActivity;
import com.cuit.likedu.ui.activity.SearchActivity;
import com.cuit.likedu.ui.activity.SearchByAuthorActivity;
import com.cuit.likedu.ui.fragment.BookDetailDiscussionFragment;
import com.cuit.likedu.ui.fragment.BookDetailReviewFragment;

import dagger.Component;

@Component(dependencies = AppComponent.class)
public interface BookComponent {
    BookDetailActivity inject(BookDetailActivity activity);

    ReadActivity inject(ReadActivity activity);

    BookSourceActivity inject(BookSourceActivity activity);

    BooksByTagActivity inject(BooksByTagActivity activity);

    SearchActivity inject(SearchActivity activity);

    SearchByAuthorActivity inject(SearchByAuthorActivity activity);

    BookDetailReviewFragment inject(BookDetailReviewFragment fragment);

    BookDetailDiscussionFragment inject(BookDetailDiscussionFragment fragment);
}