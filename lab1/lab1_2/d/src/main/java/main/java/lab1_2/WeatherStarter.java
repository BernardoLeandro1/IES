package main.java.lab1_2;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.lang.StringBuilder;
import java.util.logging.Logger;

import main.java.lab1_2.IpmaCityForecast; //may need to adapt package name
import main.java.lab1_2.IpmaService;

/**
 * demonstrates the use of the IPMA API for weather forecast
 */
public class WeatherStarter {

    //todo: should generalize for a city passed as argument
    private static final int CITY_ID_AVEIRO = 1010500;

    public static void  main(String[] args ) {

        // get a retrofit instance, loaded with the GSon lib to convert JSON into objects
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // create a typed interface to use the remote API (a client)
        IpmaService service = retrofit.create(IpmaService.class);
        // prepare the call to remote endpoint
        int cityID = 1010500;

        if (args.length > 0){
            try {
                cityID = Integer.parseInt(args[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Call<IpmaCityForecast> callSync = service.getForecastForACity(cityID);

        try {
            Response<IpmaCityForecast> apiResponse = callSync.execute();
            IpmaCityForecast forecast = apiResponse.body();

            if (forecast != null) {
                StringBuilder sb = new StringBuilder();
                String log = sb.append("Maximum temperature for today: ")
                                .append(forecast.getData().listIterator().next().getTMax())
                                .append("C.")
                                .append('\n')
                                .append("Minimum temperature for today: ")
                                .append(forecast.getData().listIterator().next().getTMin())
                                .append("C.")
                                .toString();
                System.out.print(log);
            } else {
                System.out.println( "No results for this request!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}