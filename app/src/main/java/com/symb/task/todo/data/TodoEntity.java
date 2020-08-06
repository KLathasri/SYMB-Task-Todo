package com.symb.task.todo.data;

import com.symb.task.todo.common.Todo;

public class TodoEntity implements Todo {

    private String mtext;
    private long mAddedTimeStamp;

    public TodoEntity(String text, long addedTimeStamp) {
        mtext = text;
        mAddedTimeStamp = addedTimeStamp;
    }
    @Override
    public String getTodoText() {
        return mtext;
    }

    @Override
    public long getAddedTimeStamp() {
        return mAddedTimeStamp;
    }
}
