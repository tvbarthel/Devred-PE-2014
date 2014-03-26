package fr.tvbarthel.apps.devredpe2014.ui;

import android.app.Service;
import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.SuperscriptSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import fr.tvbarthel.apps.devredpe2014.R;
import fr.tvbarthel.apps.devredpe2014.model.LookItem;

public class LookItemAdapter extends ArrayAdapter<LookItem> {

    private final SuperscriptSpan mSuperscriptSpan;
    private final AbsoluteSizeSpan mAbsoluteSizeSpan;
    private final ForegroundColorSpan mForegroundColorSpan;

    public LookItemAdapter(Context context, List<LookItem> objects) {
        super(context, R.layout.row_look_detail, objects);
        mSuperscriptSpan = new SuperscriptSpan();
        mAbsoluteSizeSpan = new AbsoluteSizeSpan(14, true);
        mForegroundColorSpan = new ForegroundColorSpan(context.getResources().getColor(android.R.color.holo_red_dark));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Service.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row_look_detail, parent, false);
            LookItemHolder viewHolder = new LookItemHolder();
            viewHolder.title = (TextView) convertView.findViewById(R.id.row_look_detail_title);
            viewHolder.price = (TextView) convertView.findViewById(R.id.row_look_detail_price);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.row_look_detail_image);
            convertView.setTag(viewHolder);
        }

        LookItem lookItem = getItem(position);
        LookItemHolder viewHolder = (LookItemHolder) convertView.getTag();
        Picasso.with(getContext()).load(lookItem.getImageResourceId()).into(viewHolder.image);
        viewHolder.title.setText(lookItem.getTitleResourceId());
        SpannableString price = new SpannableString(getContext().getString(lookItem.getPriceResourceId()));
        price.setSpan(mSuperscriptSpan, price.length() - 2, price.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        price.setSpan(mAbsoluteSizeSpan, price.length() - 2, price.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        price.setSpan(mForegroundColorSpan, price.length() - 2, price.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        viewHolder.price.setText(price);
        return convertView;
    }

    private class LookItemHolder {
        TextView title;
        ImageView image;
        TextView price;
    }
}
