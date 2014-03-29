package fr.tvbarthel.apps.devredpe2014.model;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Look implements Parcelable {

    private int mPreviewResourceId;
    private int mLookResourceId;
    private ArrayList<LookItem> mLookItems;

    public Look() {
    }

    public Look(int previewResourceId, int lookResourceId, ArrayList<LookItem> lookItems) {
        mPreviewResourceId = previewResourceId;
        mLookResourceId = lookResourceId;
        mLookItems = lookItems;
    }

    private Look(Parcel in) {
        readFromParcel(in);
    }

    public int getPreviewResourceId() {
        return mPreviewResourceId;
    }

    public void setPreviewResourceId(int previewResourceId) {
        mPreviewResourceId = previewResourceId;
    }

    public int getLookResourceId() {
        return mLookResourceId;
    }

    public void setLookResourceId(int lookResourceId) {
        mLookResourceId = lookResourceId;
    }

    public ArrayList<LookItem> getLookItems() {
        return mLookItems;
    }

    public void setLookItems(ArrayList<LookItem> lookItems) {
        mLookItems = lookItems;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mPreviewResourceId);
        dest.writeInt(mLookResourceId);
        dest.writeTypedList(mLookItems);
    }

    private void readFromParcel(Parcel in) {
        mPreviewResourceId = in.readInt();
        mLookResourceId = in.readInt();
        mLookItems = new ArrayList<LookItem>();
        in.readTypedList(mLookItems, LookItem.CREATOR);
    }


    public static Creator<Look> CREATOR = new Creator<Look>() {
        public Look createFromParcel(Parcel source) {
            return new Look(source);
        }

        public Look[] newArray(int size) {
            return new Look[size];
        }
    };
}
