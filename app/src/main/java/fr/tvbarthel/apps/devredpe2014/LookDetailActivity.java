package fr.tvbarthel.apps.devredpe2014;

import android.app.Activity;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import fr.tvbarthel.apps.devredpe2014.model.Look;
import fr.tvbarthel.apps.devredpe2014.model.LookItem;
import uk.co.senab.photoview.PhotoViewAttacher;

public class LookDetailActivity extends Activity {

    public static final String EXTRA_LOOK = "fr.tvbarthel.apps.devredpe2014.extra.look";

    private Look mLook;
    private ImageView mImageView;
    private ListView mListView;
    private PhotoViewAttacher mAttacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_detail);
        ActionBarHelper.setDevredTitle(this, getActionBar());

        mLook = getIntent().getParcelableExtra(EXTRA_LOOK);
        if (mLook == null) {
            finish();
        } else {
            init();
        }
    }

    private void init() {
        mListView = (ListView) findViewById(R.id.test);
        mImageView = (ImageView) findViewById(R.id.look_detail_activity_look_image);
        mAttacher = new PhotoViewAttacher(mImageView);


        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);


        Picasso.with(this).load(mLook.getLookResourceId()).skipMemoryCache().into(mImageView, new Callback() {
            @Override
            public void onSuccess() {
                mAttacher.update();
                mAttacher.zoomTo(1.2f, 0, 0);
            }

            @Override
            public void onError() {

            }
        });

        final View headerView = getLayoutInflater().inflate(R.layout.header_look_detail, mListView, false);
        final ArrayAdapter<LookItem> adapter = new LookItemAdapter(LookDetailActivity.this, mLook.getLookItems());
        mListView.addHeaderView(headerView);
        final View contentView = findViewById(android.R.id.content);
        final int headerListHeight = getResources().getDimensionPixelSize(R.dimen.header_look_detail_height);
        contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int height = contentView.getMeasuredHeight();
                int paddingTop = height - headerListHeight;
                mListView.setPadding(mListView.getPaddingLeft(), paddingTop, mListView.getPaddingRight(),
                        mListView.getPaddingBottom());
                mListView.setAdapter(adapter);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else {
                    contentView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.look_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
