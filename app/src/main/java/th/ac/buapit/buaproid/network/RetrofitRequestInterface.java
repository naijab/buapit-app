package th.ac.buapit.buaproid.network;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import th.ac.buapit.buaproid.activities.fragment.moremenu.model.AboutSchoolModel;
import th.ac.buapit.buaproid.activities.fragment.moremenu.model.PersonModel;
import th.ac.buapit.buaproid.model.CalendarModel;
import th.ac.buapit.buaproid.model.NewsModel;

public interface RetrofitRequestInterface {

    @GET("json_news.php")
    Call<List<NewsModel>> getNewsFull(@QueryMap Map<String, String> apiNewsRequest);

    @GET("json_calendar.php")
    Call<List<CalendarModel>> getCalendarFull(@QueryMap Map<String, String> apiNewsRequest);

    @GET("json_person.php")
    Call<List<PersonModel>> getPeopleFull(@QueryMap Map<String, String> apiNewsRequest);

    @GET("json_school.php")
    Call<List<AboutSchoolModel>> getAboutSchool(@QueryMap Map<String, String> apiNewsRequest);

}
