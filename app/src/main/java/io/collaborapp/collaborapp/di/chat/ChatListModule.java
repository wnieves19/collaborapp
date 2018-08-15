package io.collaborapp.collaborapp.di.chat;

import dagger.Module;
import dagger.Provides;
import io.collaborapp.collaborapp.chat_list.ChatListContract;
import io.collaborapp.collaborapp.chat_list.ChatListPresenter;
import io.collaborapp.collaborapp.data.DataManager;
import io.collaborapp.collaborapp.di.authentication.AppScope;

@Module
public class ChatListModule {
    @Provides
    @AppScope
    ChatListContract.Presenter providePresenter(DataManager chatManager) {
        return new ChatListPresenter(chatManager);
    }

}