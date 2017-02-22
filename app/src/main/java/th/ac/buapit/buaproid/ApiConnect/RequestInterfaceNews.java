package th.ac.buapit.buaproid.ApiConnect;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import th.ac.buapit.buaproid.Model.CalendarModel;
import th.ac.buapit.buaproid.Model.NewsModel;

public interface RequestInterfaceNews {

    @GET("json_news.php")
    Call<List<NewsModel>> getNewsFull(@QueryMap Map<String, String> apiNewsRequest);

    @GET("json_calendar.php")
    Call<List<CalendarModel>> getCalendarFull(@QueryMap Map<String, String> apiNewsRequest);

}
