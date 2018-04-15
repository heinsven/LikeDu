package com.cuit.likedu.component;

import android.content.Context;

import com.cuit.likedu.api.BookApi;
import com.cuit.likedu.module.AppModule;
import com.cuit.likedu.module.BookApiModule;

import dagger.Component;

@Component(modules = {AppModule.class, BookApiModule.class})
public interface AppComponent {

    Context getContext();

    BookApi getReaderApi();

}