package ch.jmbise.googlebook.dagger;

import javax.inject.Singleton;

import ch.jmbise.googlebook.ui.BookListFragment;
import ch.jmbise.googlebook.ui.MainActivity;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(BookListFragment fragement);
}