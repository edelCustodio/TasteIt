package mx.com.tasteit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.net.URL;

import mx.com.tasteit.ui.RestaurantDetailActivity;

import mx.com.tasteit.tasteitmodel.http.HttpRequestTask;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            //Intent i = new Intent(this, RestaurantDetailActivity.class);
        }

        return super.onOptionsItemSelected(item);
    }

    public void startNewAction(View v){
        //Toast.makeText(this, "Aqui estoy", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, RestaurantDetailActivity.class);
        startActivity(i);
    }
}
