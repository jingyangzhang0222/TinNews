package com.laioffer.tinnews.tin;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteConstraintException;
import android.util.Log;

import com.laioffer.tinnews.TinApplication;
import com.laioffer.tinnews.database.AppDatabase;
import com.laioffer.tinnews.retrofit.NewsRequestApi;
import com.laioffer.tinnews.retrofit.RetrofitClient;
import com.laioffer.tinnews.retrofit.response.News;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by jingyangzhang on 1/5/19 in project of TinNews
 */
public class TinModel implements TinContract.Model {
    private TinContract.Presenter presenter;
    private final NewsRequestApi newsRequestApi;
    private final AppDatabase db;

    public TinModel() {
        newsRequestApi = RetrofitClient.getInstance().create(NewsRequestApi.class);
        db = TinApplication.getDataBase();

    }

    @Override
    public void setPresenter(TinContract.Presenter presenter) {
        //assign the presenter
        this.presenter = presenter;    }

    @Override
    public void fetchData(String country) {
        newsRequestApi.getNewsByCountry(country)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(baseResponse -> baseResponse != null && baseResponse.articles != null)
                .subscribe(baseResponse -> {
                    presenter.showNewsCard(baseResponse.articles);
                }, error -> {
                    Log.d("test", "test", error);
                });
    }

    //implement the saveFavoriteNews
    @SuppressLint("CheckResult")
    @Override
    public void saveFavoriteNews(News news) {
        Completable.fromAction(() -> db.newsDao().insertNews(news)).
                subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(() ->{
                presenter.onSavedSuccess();
        }, error -> {
            if (error instanceof SQLiteConstraintException) {
                presenter.onError();
            }
        });
    }
}
