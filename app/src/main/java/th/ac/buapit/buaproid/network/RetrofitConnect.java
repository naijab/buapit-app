package th.ac.buapit.buaproid.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitConnect {

    private static final String RETROFIT_BASE_URL = "http://app.buapit.ac.th/sada/json/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {

        if (retrofit == null) {

            retrofit = new Retrofit.Builder()
                    .baseUrl(RETROFIT_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
