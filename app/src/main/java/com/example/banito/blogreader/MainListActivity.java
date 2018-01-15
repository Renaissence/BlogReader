package com.example.banito.blogreader;

import android.app.ListActivity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainListActivity extends ListActivity {

    protected String [] mBlogPostTitles;
    public static final int NUMBER_OF_POSTS = 20;
    public static final String TAG = MainListActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);

        // Connecting to the teamthreehouse blog site
        try {
            URL blogFeedUrl = new URL("http://blog.teamtreehouse.com/api/get_recent_summary/?count=" + NUMBER_OF_POSTS);
            //opening the connection with http url connection object
            HttpURLConnection connection = (HttpURLConnection) blogFeedUrl.openConnection();
            connection.connect();

            //the variable that holds the response from the server
            int responseCode = connection.getResponseCode();
            Log.i(TAG, "Code: " + responseCode);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            Log.e(TAG, "Exception caught", e );
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG, "Exception caught", e );
        } catch (Exception e){
            Log.e(TAG, "Exception caught", e );
        }


//        Toast.makeText(this, getString(R.string.no_items), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings){
            return true;
        }

        return super.onOptionsItemSelected(item);

    }
}
