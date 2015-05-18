package mx.com.tasteit.tasteitmodel.http;

import android.os.AsyncTask;
import android.util.Log;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import mx.com.tasteit.tasteitmodel.dto.Restaurante;

/**
 * Created by edel on 17/05/15.
 */
public class HttpRequestRestaurante {

    private static final String URL = "http://tasteit-neburnz.rhcloud.com/api/restaurants";

    public class ObtenerRestaurante extends AsyncTask<Integer, Integer, Restaurante>{

        @Override
        protected Restaurante doInBackground(Integer... ids) {
            try {

                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Restaurante restaurant = restTemplate.getForObject(URL +"/" + ids[0], Restaurante.class);
                return restaurant;
            } catch (Exception e) {
                Log.e("GETREST", e.getMessage(), e);
                return null;
            }
        }
    }

    public class ObtenerListaRestaurantes extends AsyncTask<Void, Integer, Restaurante[]>{

        @Override
        protected Restaurante[] doInBackground(Void... params) {

            try {
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Restaurante[] list = restTemplate.getForObject(URL, Restaurante[].class);


                return list;

            }catch (Exception e){
                Log.e("GETLISTREST", e.getMessage(), e);
            }
            return null;
        }
    }
}
