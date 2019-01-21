package com.laioffer.tinnews.save;

import android.support.annotation.DrawableRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.laioffer.tinnews.R;
import com.laioffer.tinnews.TinFragmentPagerAdapter;
import com.laioffer.tinnews.common.BaseViewModel;
import com.laioffer.tinnews.common.TinFragmentManager;
import com.laioffer.tinnews.common.Util;
import com.laioffer.tinnews.retrofit.response.News;
import com.laioffer.tinnews.save.detail.SavedNewsDetailedFragment;

/**
 * Created by jingyangzhang on 1/20/19 in project of TinNews
 */
public class SavedNewsViewModel extends BaseViewModel<SavedNewsViewModel.SavedNewsViewHolder> {
    private TinFragmentManager tinFragmentManager;
    private News news;
    private static int[] ICON_ARRAY = new int[]{R.drawable.a_news_icon, R.drawable.g_news_icon,
            R.drawable.c_news_icon, R.drawable.y_news_icon, R.drawable.m_news_icon};

    public SavedNewsViewModel(News news, TinFragmentManager tinFragmentManager) {
        super(R.layout.saved_news_item);
        this.news = news;
        this.tinFragmentManager = tinFragmentManager;
    }

    @Override
    public SavedNewsViewHolder createItemViewHolder(View view) {
        return new SavedNewsViewHolder(view);
    }

    @Override
    public void bindViewHolder(SavedNewsViewHolder holder) {
        //5.4
        if (!Util.isStringEmpty(news.author)) {
            holder.author.setText(news.author);
        }
        holder.description.setText(news.getDescription());
        holder.icon.setImageResource(getDrawable());
        holder.itemView.setOnClickListener(v -> {
            tinFragmentManager.doFragmentTransaction(SavedNewsDetailedFragment.newInstance(news));
        });

    }

    //2.4
    private @DrawableRes
    int getDrawable() {
        return ICON_ARRAY[(int)(Math.random() * 5)];
    }

    public static class SavedNewsViewHolder extends RecyclerView.ViewHolder {

        TextView author;
        TextView description;
        ImageView icon;

        public SavedNewsViewHolder(View itemView) {
            super(itemView);
            author = itemView.findViewById(R.id.author);
            description = itemView.findViewById(R.id.description);
            icon = itemView.findViewById(R.id.image);
        }
    }
}
