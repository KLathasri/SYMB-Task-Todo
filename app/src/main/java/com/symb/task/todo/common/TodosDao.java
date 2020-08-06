package com.symb.task.todo.common;

import androidx.annotation.NonNull;

import java.util.List;

public interface TodosDao {

    boolean saveTodo(Todo todoToSave);

    @NonNull
    List<Todo> getSavedTodos();

    void closeDao();

}
