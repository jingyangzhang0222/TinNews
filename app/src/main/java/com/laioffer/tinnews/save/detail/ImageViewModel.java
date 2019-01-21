package com.laioffer.tinnews.save.detail;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.laioffer.tinnews.R;
import com.laioffer.tinnews.common.BaseViewModel;
import com.squareup.picasso.Picasso;

/**
 * Created by jingyangzhang on 1/20/19 in project of TinNews
 */
public class ImageViewModel extends BaseViewModel<ImageViewModel.ImageViewModelViewHolder> {
    private final String uri;
    public ImageViewModel(String uri) {
        super(R.layout.image_layout);
        this.uri = uri;
    }

    @Override
    public ImageViewModelViewHolder createItemViewHolder(View view) {
        return new ImageViewModelViewHolder(view);
    }

    @Override
    public void bindViewHolder(ImageViewModelViewHolder holder) {
        Picasso.get().load(uri).into(holder.image);
    }


    public static class  ImageViewModelViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        ImageViewModelViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
        }
    }

}
