package fr.tvbarthel.apps.devredpe2014;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;


public class LicenseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_license);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        ((WebView) findViewById(R.id.license_activity_web_view)).loadUrl("file:///android_asset/licenses.html");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
