package ch.jmbise.googlebook.ui;

import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import javax.inject.Inject;

import ch.jmbise.googlebook.GoogleBookApplication;
import ch.jmbise.googlebook.R;
import ch.jmbise.googlebook.databinding.FragmentBookListBinding;
import ch.jmbise.googlebook.network.model.Books;
import ch.jmbise.googlebook.viewmodel.BookListViewModel;


public class BookListFragment extends Fragment implements BookEventHandler {
    FragmentBookListBinding bookListBindingAdapter;

    @Inject
    BookListViewModel bookListViewModel;

    public BookListFragment() {
        // Required empty public constructor
    }

    public static BookListFragment newInstance() {
        return new BookListFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((GoogleBookApplication) getActivity().getApplication()).getComponent().inject(this);

        bookListBindingAdapter.setBookEventHandler(this);
        bookListBindingAdapter.setBookListViewModel(bookListViewModel);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bookListBindingAdapter = DataBindingUtil.inflate(inflater, R.layout.fragment_book_list, container, false);
        return bookListBindingAdapter.getRoot();
    }


    @Override
    public void onBookClicked(Books.Book book) {
        getActivity().getSupportFragmentManager().beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack(book.getId())
                .add(R.id.fragment_container, BookDetailFragment.newInstance(book))
                .commit();
    }

    @Override
    public void searchClicked(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Title");

        final EditText input = new EditText(getContext());
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                bookListViewModel.search(input.getText().toString());
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
}
