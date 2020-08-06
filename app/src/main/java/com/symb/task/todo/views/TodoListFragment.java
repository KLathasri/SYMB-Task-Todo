package com.symb.task.todo.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.symb.task.todo.R;
import com.symb.task.todo.data.TodoRepository;

public class TodoListFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_todo_list, container, false);
        RecyclerView rvTodos = view.findViewById(R.id.rvTodos);
        rvTodos.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        rvTodos.setAdapter(new MyTodoRecyclerViewAdapter(TodoRepository.getInstance().
                getTodosDao().getSavedTodos()));
        return view;
    }


}
