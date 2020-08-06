package com.symb.task.todo;

import android.app.Application;

public class TodoAppController extends Application {

    private static TodoAppController mInstance;

    public static TodoAppController getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
}
