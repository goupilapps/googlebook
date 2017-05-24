package ch.jmbise.googlebook.ui;


import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import ch.jmbise.googlebook.network.BookFetcher;
import ch.jmbise.googlebook.network.model.Books;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

public class BookListBindingAdapter {

    @BindingAdapter({"book_fetcher", "book_event_handler", "search_term"})
    public static void setListContent(final RecyclerView recyclerView, final BookFetcher bookFetcher, final BookEventHandler bookEventHandler, String searchTerm) {
        if (bookFetcher != null && bookEventHandler != null && searchTerm != null) {
            bookFetcher.setSearchTerm(searchTerm);
            bookFetcher.getBookAt(0).subscribe(new Consumer<Books.Book>() {
                @Override
                public void accept(@NonNull Books.Book book) throws Exception {
                    if(recyclerView.getAdapter() == null) {
                        final BookListAdapter bookListAdapter = new BookListAdapter(bookFetcher, bookEventHandler);
                        recyclerView.setAdapter(bookListAdapter);
                    } else {
                        recyclerView.getAdapter().notifyDataSetChanged();
                    }
                }
            });
        }
    }


    @BindingAdapter({"book_event_handler", "book"})
    public static void setOnCLickLinearLayout(LinearLayout lickLinearLayout, final BookEventHandler bookEventHandler, final Books.Book book) {
        if (book != null && bookEventHandler != null) {
            lickLinearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bookEventHandler.onBookClicked(book);
                }
            });
        }
    }

    @BindingAdapter("image_url")
    public static void setImage(ImageView imageView, String url) {
        if (url != null) {
            Picasso.with(imageView.getContext()).load(url).into(imageView);
        }
    }

    @BindingAdapter("android:text")
    public static void setText(TextView textView, String[] content) {
        if (content != null) {
            String concat = "";
            for (String item : content) {
                concat = concat + item + "\r\n";
            }
            textView.setText(concat);
        }
    }
}
