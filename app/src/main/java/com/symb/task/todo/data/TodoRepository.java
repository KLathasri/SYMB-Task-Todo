package com.symb.task.todo.data;

import androidx.annotation.NonNull;

import com.symb.task.todo.common.TodosDao;

public class TodoRepository {

    private TodoRepository() {}
    private static TodoRepository mInstance;

    public static TodoRepository getInstance() {
        if (mInstance == null) {
            mInstance = new TodoRepository();
        }
        return mInstance;
    }

    @NonNull
    public TodosDao getTodosDao() {
        return TodoSqlDao.getInstance();
    }
}
