package com.laioffer.tinnews.save;

import com.laioffer.tinnews.retrofit.response.News;
import com.laioffer.tinnews.save.SavedNewsContract;
import com.laioffer.tinnews.save.SavedNewsModel;

import java.util.List;

/**
 * Created by jingyangzhang on 1/12/19 in project of TinNews
 */
public class SavedNewsPresenter implements SavedNewsContract.Presenter{
    private final SavedNewsContract.Model model;
    private SavedNewsContract.View view;

    public SavedNewsPresenter() {
        model = new SavedNewsModel();
        model.setPresenter(this);
    }


    @Override
    public void onCreate() {


    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onViewAttached(SavedNewsContract.View view) {
        //1.6
        this.view = view;
        //4.5
        this.model.fetchData();
    }

    @Override
    public void onViewDetached() {

    }

    @Override
    public void loadSavedNews(List<News> newsList) {
        if (view != null) {
            view.loadSavedNews(newsList);
        }
    }
}
