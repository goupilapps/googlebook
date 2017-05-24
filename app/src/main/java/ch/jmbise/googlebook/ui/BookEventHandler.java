package ch.jmbise.googlebook.ui;


import android.view.View;

import ch.jmbise.googlebook.network.model.Books;

public interface BookEventHandler {
    void onBookClicked(Books.Book book);
    void searchClicked(View view);
}
