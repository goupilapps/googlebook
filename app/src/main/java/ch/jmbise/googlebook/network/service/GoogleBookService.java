package ch.jmbise.googlebook.network.service;


import ch.jmbise.googlebook.network.model.Books;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GoogleBookService {
    @GET("books/v1/volumes")
    Observable<Books> search(@Query("q") String searchTerms, @Query("startIndex") int startIndex, @Query("maxResults") int maxResults);
}
