package io.collaborapp.collaborapp.di.chat;

import dagger.Module;
import dagger.Provides;
import io.collaborapp.collaborapp.chat.ChatContract;
import io.collaborapp.collaborapp.chat.ChatPresenterImpl;
import io.collaborapp.collaborapp.chat_list.ChatListContract;
import io.collaborapp.collaborapp.chat_list.ChatListPresenterImpl;
import io.collaborapp.collaborapp.data.DataManager;
import io.collaborapp.collaborapp.di.authentication.AppScope;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ChatListModule {
    @Provides
    @AppScope
    ChatListContract.Presenter providePresenter(DataManager chatManager, CompositeDisposable compositeDisposable) {
        return new ChatListPresenterImpl(chatManager, compositeDisposable);
    }

    @Provides
    @AppScope
    ChatContract.Presenter provideChatPresenter(DataManager chatManager, CompositeDisposable compositeDisposable) {
        return new ChatPresenterImpl(chatManager, compositeDisposable);
    }

}
