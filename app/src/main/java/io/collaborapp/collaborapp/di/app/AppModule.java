package io.collaborapp.collaborapp.di.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wilfredonieves on 10/27/17.
 */

@Module
public class AppModule {
    private Context context;

    AppModule(Application application) {
        context = application;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public Resources provideResources(Context context) {
        return context.getResources();
    }

    @Provides
    FirebaseDatabase providesFirebaseDatabase() {
        return FirebaseDatabase.getInstance();
    }

    @Provides
    FirebaseAuth providesFirebaseAuth() {
        return FirebaseAuth.getInstance();
    }
}
