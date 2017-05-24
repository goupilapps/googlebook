package ch.jmbise.googlebook;


import android.app.Application;

import ch.jmbise.googlebook.dagger.AppComponent;
import ch.jmbise.googlebook.dagger.AppModule;
import ch.jmbise.googlebook.dagger.DaggerAppComponent;

public class GoogleBookApplication extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

    }

    public AppComponent getComponent() {
        return appComponent;
    }
}
