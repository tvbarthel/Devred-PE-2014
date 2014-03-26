package fr.tvbarthel.apps.devredpe2014.ui;


import android.app.ActionBar;
import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;

import fr.tvbarthel.apps.devredpe2014.R;

public final class ActionBarHelper {

    public static void setDevredTitle(Context context, ActionBar actionBar) {
        if (actionBar != null) {
            SpannableString title = new SpannableString(context.getString(R.string.app_name).toUpperCase());
            TypefaceSpan typefaceSpanLight = new TypefaceSpan("sans-serif-light");
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(context.getResources().getColor(android.R.color.holo_red_dark));
            title.setSpan(typefaceSpanLight, 0, title.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            title.setSpan(foregroundColorSpan, title.length() - 4, title.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            actionBar.setTitle(title);
        }
    }

    // Non instantiable class.
    private ActionBarHelper() {
    }
}
