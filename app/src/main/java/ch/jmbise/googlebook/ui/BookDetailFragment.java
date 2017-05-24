package ch.jmbise.googlebook.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ch.jmbise.googlebook.R;
import ch.jmbise.googlebook.databinding.FragmentBookDetailBinding;
import ch.jmbise.googlebook.network.model.Books;


public class BookDetailFragment extends Fragment {

    private static final String ARG_BOOK = "book";

    private Books.Book book;
    private FragmentBookDetailBinding fragmentBookDetailBinding;

    public BookDetailFragment() {
        // Required empty public constructor
    }


    public static BookDetailFragment newInstance(Books.Book book) {
        BookDetailFragment fragment = new BookDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_BOOK, book);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            book = getArguments().getParcelable(ARG_BOOK);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fragmentBookDetailBinding.setBook(book);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentBookDetailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_book_detail, container, false);
        return fragmentBookDetailBinding.getRoot();
    }
}
