package com.example.picturegallery;

import android.content.*;
import android.content.res.*;
import android.view.*;
import android.widget.*;

public class ImageAdapter extends BaseAdapter {
    int mGalleryItemBackground;
    private Context mContext;

    private Integer[] mImageIds = { // the above horizontal scroll bar
            R.drawable.image01,
            R.drawable.image02,
            R.drawable.image03,
            R.drawable.image04,
            R.drawable.image05,
            R.drawable.image06,
            R.drawable.image07,
            R.drawable.image08,
            R.drawable.image09,
            R.drawable.image10,
            R.drawable.image11,
            R.drawable.image12

    };

    public ImageAdapter(Context c) {
        mContext = c;
        TypedArray a = c.obtainStyledAttributes(R.styleable.GalleryTheme);
        mGalleryItemBackground = a.getResourceId(R.styleable.GalleryTheme_android_galleryItemBackground, 0);
        a.recycle();
    }

    public int getCount() {
        return mImageIds.length;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView i = new ImageView(mContext);
        i.setImageResource(mImageIds[position]);
        i.setLayoutParams(new Gallery.LayoutParams(250, 200));     // this is for the small sliding icons
        i.setScaleType(ImageView.ScaleType.FIT_XY);
        i.setBackgroundResource(mGalleryItemBackground);
        return i;
    }
}
