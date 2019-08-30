package com.yy.yybaselibary.ipc;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * author: Created by yuyao on 2019/8/22 10:15
 * E-Mail: 380712098@qq.com
 * description:
 */
public class Fruit implements Parcelable {
    private String name;
    private int price;

    public Fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }

    protected Fruit(Parcel in) {
        this.name = in.readString();
        this.price = in.readInt();
    }


    public static final Creator<Fruit> CREATOR = new Creator<Fruit>() {
        @Override
        public Fruit createFromParcel(Parcel in) {
            return new Fruit(in);
        }

        @Override
        public Fruit[] newArray(int size) {
            return new Fruit[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(price);
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
