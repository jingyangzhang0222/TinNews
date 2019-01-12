package com.laioffer.tinnews.retrofit.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jingyangzhang on 12/23/18 in project of TinNews
 */
public class BaseResponse {

    public String status;
    public int totalResults;
    public List<News> articles;
}
