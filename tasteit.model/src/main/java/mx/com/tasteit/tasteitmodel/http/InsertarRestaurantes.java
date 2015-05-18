package mx.com.tasteit.tasteitmodel.http;

import android.os.AsyncTask;
import android.util.Log;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import mx.com.tasteit.tasteitmodel.dto.Restaurante;

/**
 * Created by edel on 17/05/15.
 */
public class InsertarRestaurantes extends AsyncTask<List<Restaurante>, Integer, Boolean> {
    @Override
    protected Boolean doInBackground(List<Restaurante>... listaRestaurantes) {

        try {
            final String url = "http://tasteit-neburnz.rhcloud.com/api/restaurants";
            RestTemplate restTemplate = new RestTemplate(true);
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            Restaurante restaurant = restTemplate.getForObject(url, Restaurante.class);
            return true;
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }

        return false;
    }
}
