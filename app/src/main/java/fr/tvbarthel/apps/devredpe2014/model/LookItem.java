package fr.tvbarthel.apps.devredpe2014.model;


import android.os.Parcel;
import android.os.Parcelable;

public class LookItem implements Parcelable {

    private int mImageResourceId;
    private int mTitleResourceId;
    private int mPriceResourceId;

    public LookItem() {
    }

    public LookItem(int imageResourceId, int titleResourceId, int priceResourceId) {
        mTitleResourceId = titleResourceId;
        mImageResourceId = imageResourceId;
        mPriceResourceId = priceResourceId;
    }

    public LookItem(Parcel in) {
        readFromParcel(in);
    }

    public int getTitleResourceId() {
        return mTitleResourceId;
    }

    public void setTitleResourceId(int titleResourceId) {
        mTitleResourceId = titleResourceId;
    }

    public int getPriceResourceId() {
        return mPriceResourceId;
    }

    public void setPriceResourceId(int priceResourceId) {
        mPriceResourceId = priceResourceId;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        mImageResourceId = imageResourceId;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mImageResourceId);
        dest.writeInt(mTitleResourceId);
        dest.writeInt(mPriceResourceId);
    }

    private void readFromParcel(Parcel in) {
        mImageResourceId = in.readInt();
        mTitleResourceId = in.readInt();
        mPriceResourceId = in.readInt();
    }

    public static Creator<LookItem> CREATOR = new Creator<LookItem>() {
        public LookItem createFromParcel(Parcel source) {
            return new LookItem(source);
        }

        public LookItem[] newArray(int size) {
            return new LookItem[size];
        }
    };
}
