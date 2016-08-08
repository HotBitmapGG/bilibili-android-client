package com.hotbitmapgg.ohmybilibili.entity.index;

import com.google.gson.annotations.SerializedName;
import com.hotbitmapgg.ohmybilibili.entity.video.VideoItemInfo;

import java.io.Serializable;
import java.util.ArrayList;

public class Index implements Serializable
{

    @SerializedName("type1")
    public FuckList typeCartoon;

    @SerializedName("type3")
    public FuckList typeMusic;

    @SerializedName("type4")
    public FuckList typeGame;

    @SerializedName("type5")
    public FuckList typeEntertainment;

    @SerializedName("type11")
    public FuckList typeTvSeries;

    @SerializedName("type13")
    public FuckList typeAnime;

    @SerializedName("type23")
    public FuckList typeMovie;

    @SerializedName("type36")
    public FuckList typeTechnology;

    @SerializedName("type129")
    public FuckList typeDance;

    @SerializedName("type119")
    public FuckList typeFunny;

    public class FuckList implements Serializable
    {

        @SerializedName("0")
        public VideoItemInfo item0;

        @SerializedName("1")
        public VideoItemInfo item1;

        @SerializedName("2")
        public VideoItemInfo item2;

        @SerializedName("3")
        public VideoItemInfo item3;

        @SerializedName("4")
        public VideoItemInfo item4;

        @SerializedName("5")
        public VideoItemInfo item5;

        @SerializedName("6")
        public VideoItemInfo item6;

        @SerializedName("7")
        public VideoItemInfo item7;

        @SerializedName("8")
        public VideoItemInfo item8;

        public ArrayList<VideoItemInfo> list()
        {

            ArrayList<VideoItemInfo> array = new ArrayList<>();
            if (item0 != null)
            {
                array.add(item0);
            }
            if (item1 != null)
            {
                array.add(item1);
            }
            if (item2 != null)
            {
                array.add(item2);
            }
            if (item3 != null)
            {
                array.add(item3);
            }
            if (item4 != null)
            {
                array.add(item4);
            }
            if (item5 != null)
            {
                array.add(item5);
            }
            if (item6 != null)
            {
                array.add(item6);
            }
            if (item7 != null)
            {
                array.add(item7);
            }
            if (item8 != null)
            {
                array.add(item8);
            }
            return array;
        }
    }
}
