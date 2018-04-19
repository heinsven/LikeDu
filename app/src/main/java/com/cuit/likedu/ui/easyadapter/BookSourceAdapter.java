package com.cuit.likedu.ui.easyadapter;

import android.content.Context;
import android.view.ViewGroup;

import com.cuit.likedu.R;
import com.cuit.likedu.bean.BookSource;
import com.cuit.likedu.view.LetterView;
import com.cuit.likedu.view.recyclerview.adapter.BaseViewHolder;
import com.cuit.likedu.view.recyclerview.adapter.RecyclerArrayAdapter;

/**
 * 查询
 */
public class BookSourceAdapter extends RecyclerArrayAdapter<BookSource> {


    public BookSourceAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseViewHolder<BookSource>(parent, R.layout.item_book_source) {
            @Override
            public void setData(BookSource item) {
                holder.setText(R.id.tv_source_title, item.host)
                        .setText(R.id.tv_source_content, item.lastChapter);

                LetterView letterView = holder.getView(R.id.letter_view);
                letterView.setText(item.host);
            }
        };
    }
}
