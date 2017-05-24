package ch.jmbise.googlebook.network;


import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import ch.jmbise.googlebook.network.model.Books;
import ch.jmbise.googlebook.network.service.GoogleBookService;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;

public class BookFetcher {

    private GoogleBookService googleBookService;
    private int numberBooks = 0;
    private String searchTerm = "";

    private Map<Integer, BehaviorSubject<Books>> pageIndexRequestCache = new HashMap<>();

    @Inject
    public BookFetcher(GoogleBookService googleBookService) {
        this.googleBookService = googleBookService;

    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
        pageIndexRequestCache.clear();
    }

    public Observable<Books.Book> getBookAt(final int position) {
        int pageIndex = (position / 40) * 40;
        Observable<Books> booksObservable = pageIndexRequestCache.get(pageIndex);
        if (booksObservable != null) {
            booksObservable = pageIndexRequestCache.get(pageIndex);
        } else {
            final BehaviorSubject<Books> booksSubject = BehaviorSubject.create();
            booksObservable = googleBookService.search(searchTerm, pageIndex, 40)
                    .doOnNext(new Consumer<Books>() {
                        @Override
                        public void accept(@NonNull Books books) throws Exception {
                            booksSubject.onNext(books);
                        }
                    }).subscribeOn(Schedulers.io());
            pageIndexRequestCache.put(pageIndex, booksSubject);
        }
        return booksObservable
                .map(new Function<Books, Books.Book>() {
                    @Override
                    public Books.Book apply(@NonNull Books books) throws Exception {
                        BookFetcher.this.numberBooks = books.getTotalItems();
                        return books.getItems()[position % 40];
                    }
                })
                .observeOn(AndroidSchedulers.mainThread());
    }

    public int countBooks() {
        return numberBooks;
    }
}
