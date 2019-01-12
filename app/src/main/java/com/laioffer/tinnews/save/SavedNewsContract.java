package com.laioffer.tinnews.save;

import com.laioffer.tinnews.mvp.MvpContract;
import com.laioffer.tinnews.mvp.MvpFragment;
import com.laioffer.tinnews.retrofit.response.News;

import java.util.List;

/**
 * Created by jingyangzhang on 1/12/19 in project of TinNews
 */
public interface SavedNewsContract {
    interface View extends MvpContract.View<Presenter> {
        void loadSavedNews(List<News> newsList);
    }

    interface Presenter extends MvpContract.Presenter<View, MvpContract.Model> {
        void loadSavedNews(List<News> newsList);
    }

    interface Model extends MvpContract.Model<Presenter> {
        void fetchData();
    }
}
