package mx.com.tasteit.tasteitmodel.http;

import android.os.AsyncTask;
import android.util.Log;

import java.net.URL;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import mx.com.tasteit.tasteitmodel.dto.Restaurante;

/**
 * Created by edel on 17/05/15.
 */
public class HttpRequestTask extends AsyncTask<String, Integer, Restaurante> {
    @Override
    protected Restaurante doInBackground(String... urls) {
        try {
            final String url = urls[0];
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            Restaurante restaurant = restTemplate.getForObject(url, Restaurante.class);
            return restaurant;
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }

        return null;
    }

    @Override
    protected void onPostExecute(Restaurante restaurante) {

    }
}
