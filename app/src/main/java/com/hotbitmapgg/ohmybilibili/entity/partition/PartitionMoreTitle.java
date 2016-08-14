package com.hotbitmapgg.ohmybilibili.entity.partition;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class PartitionMoreTitle implements Parcelable
{

    public List<PartitionMoreType> titles = new ArrayList<>();


    @Override
    public int describeContents()
    {

        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {

        dest.writeList(this.titles);
    }

    public PartitionMoreTitle()
    {

    }

    protected PartitionMoreTitle(Parcel in)
    {

        this.titles = new ArrayList<>();
        in.readList(this.titles, PartitionMoreType.class.getClassLoader());
    }

    public static final Parcelable.Creator<PartitionMoreTitle> CREATOR = new Parcelable.Creator<PartitionMoreTitle>()
    {

        @Override
        public PartitionMoreTitle createFromParcel(Parcel source)
        {

            return new PartitionMoreTitle(source);
        }

        @Override
        public PartitionMoreTitle[] newArray(int size)
        {

            return new PartitionMoreTitle[size];
        }
    };
}
