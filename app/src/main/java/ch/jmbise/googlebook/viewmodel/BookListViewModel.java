package ch.jmbise.googlebook.viewmodel;

import android.databinding.ObservableField;

import javax.inject.Inject;

import ch.jmbise.googlebook.network.BookFetcher;

public class BookListViewModel {

    private ObservableField<String> searchTerm = new ObservableField<>();
    private ObservableField<BookFetcher> bookFetcher = new ObservableField<>();

    @Inject
    public BookListViewModel(BookFetcher bookFetcher) {
        this.bookFetcher.set(bookFetcher);
    }

    public void search(String searchTerm) {
        this.searchTerm.set(searchTerm);
    }

    public ObservableField<BookFetcher> getBookFetcher() {
        return bookFetcher;
    }

    public ObservableField<String> getSearchTerm() {
        return searchTerm;
    }
}