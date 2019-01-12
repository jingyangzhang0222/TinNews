package com.laioffer.tinnews.mvp;

/**
 * Created by jingyangzhang on 1/5/19 in project of TinNews
 */
public interface MvpContract {
    interface View<P extends Presenter> {
        P getPresenter();
    }

    interface Presenter<V extends View, M extends Model> {
        void onCreate();

        void onDestroy();

        void onViewAttached(V view);

        void onViewDetached();
    }

    interface Model<P extends  Presenter> {
        void setPresenter(P presenter);
    }
}
