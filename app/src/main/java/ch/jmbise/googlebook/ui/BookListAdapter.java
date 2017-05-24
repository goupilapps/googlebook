package ch.jmbise.googlebook.ui;


import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import ch.jmbise.googlebook.R;
import ch.jmbise.googlebook.databinding.ListItemBookBinding;
import ch.jmbise.googlebook.network.BookFetcher;
import ch.jmbise.googlebook.network.model.Books;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.ViewHolder> {
    private BookFetcher bookFetcher;
    private BookEventHandler bookEventHandler;

    public BookListAdapter(BookFetcher bookFetcher, BookEventHandler bookEventHandler) {
        this.bookFetcher = bookFetcher;
        this.bookEventHandler = bookEventHandler;
    }

    static final class ViewHolder extends RecyclerView.ViewHolder {
        private ListItemBookBinding binding;
        private Disposable disposable;

        public ViewHolder(ListItemBookBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Observable<Books.Book> book, final BookEventHandler bookEventHandler) {
            disposable = book.subscribe(new Consumer<Books.Book>() {
                @Override
                public void accept(@NonNull Books.Book book) throws Exception {
                    binding.setBook(book);
                    binding.setBookEventHandler(bookEventHandler);
                    binding.executePendingBindings();
                }
            }, new Consumer<Throwable>() {
                @Override
                public void accept(@NonNull Throwable throwable) throws Exception {
                    throwable.printStackTrace();
                }
            });
        }

        public void cleanup() {
            disposable.dispose();
        }

    }

    @Override
    public void onViewRecycled(ViewHolder holder) {
        super.onViewRecycled(holder);
        holder.cleanup();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //https://developer.android.com/topic/libraries/data-binding/index.html
        ListItemBookBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.list_item_book, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(bookFetcher.getBookAt(position), bookEventHandler);
    }

    @Override
    public int getItemCount() {
        return bookFetcher.countBooks();
    }


}
