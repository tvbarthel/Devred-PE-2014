package fr.tvbarthel.apps.devredpe2014;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import fr.tvbarthel.apps.devredpe2014.fragments.AboutDialogFragment;
import fr.tvbarthel.apps.devredpe2014.model.Look;
import fr.tvbarthel.apps.devredpe2014.model.LookFactory;
import fr.tvbarthel.apps.devredpe2014.ui.ActionBarHelper;

public class MainActivity extends Activity {

    private ArrayAdapter<Look> mAdapter;
    private GridView mGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBarHelper.setDevredTitle(this, getActionBar());

        mGridView = (GridView) findViewById(R.id.main_activity_grid_view);

        final Look[] values = new Look[]{
                LookFactory.create1(),
                LookFactory.create2(),
                LookFactory.create3(),
                LookFactory.create4(),
                LookFactory.create6(),
                LookFactory.create7(),
                LookFactory.create8(),
                LookFactory.create9(),
                LookFactory.create10()};

        mAdapter = new MySimpleArrayAdapter(this, values);
        mGridView.setAdapter(mAdapter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, LookDetailActivity.class);
                intent.putExtra(LookDetailActivity.EXTRA_LOOK, values[position]);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        boolean isSelectionConsume;
        switch (id) {
            case R.id.action_licenses:
                startActivity(new Intent(this, LicenseActivity.class));
                isSelectionConsume = true;
                break;

            case R.id.action_about:
                (new AboutDialogFragment()).show(getFragmentManager(), "AboutDialogFragment");
                isSelectionConsume = true;
                break;

            case R.id.action_report_a_problem:
                String uriString = getString(R.string.report_uri,
                        Uri.encode(getString(R.string.report_mail)),
                        Uri.encode(getString(R.string.report_default_subject)));
                Uri uri = Uri.parse(uriString);
                Intent sendIntent = new Intent(Intent.ACTION_SENDTO);
                sendIntent.setData(uri);
                startActivity(sendIntent);
                isSelectionConsume = true;
                break;

            default:
                isSelectionConsume = super.onOptionsItemSelected(item);
        }
        return isSelectionConsume;
    }


    private class MySimpleArrayAdapter extends ArrayAdapter<Look> {

        class ViewHolder {
            ImageView imageView;
        }

        public MySimpleArrayAdapter(Context context, Look[] looks) {
            super(context, R.layout.row_look, looks);
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.row_look, parent, false);
                ImageView imageView = ((ImageView) convertView.findViewById(R.id.row_look_rounded_image));

                ViewHolder viewHolder = new ViewHolder();
                viewHolder.imageView = imageView;
                convertView.setTag(viewHolder);
            }

            final ViewHolder viewHolder = (ViewHolder) convertView.getTag();
            Picasso.with(MainActivity.this)
                    .load(getItem(position).getPreviewResourceId())
                    .placeholder(R.drawable.look_placeholder)
                    .into(viewHolder.imageView);

            return convertView;
        }

    }

}
