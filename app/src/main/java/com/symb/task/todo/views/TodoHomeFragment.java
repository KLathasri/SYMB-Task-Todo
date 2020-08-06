package com.symb.task.todo.views;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.symb.task.todo.common.AppNavigator;
import com.symb.task.todo.R;
import com.symb.task.todo.data.TodoRepository;


public class TodoHomeFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_todo_home, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private AppNavigator mAppNavigator;

    private AppNavigator requireAppNavigator() {
        if (mAppNavigator == null && getActivity() instanceof AppNavigator) {
            mAppNavigator = (AppNavigator) getActivity();
        }

        if (mAppNavigator == null) {
            throw new IllegalStateException("Navigator is not set");
        }
        return mAppNavigator;
    }

    private void initViews(@NonNull View rootView) {
        View btnTodoList = rootView.findViewById(R.id.btn_todo_list);
        View btnCreateTodo = rootView.findViewById(R.id.btn_create_todo);

        btnTodoList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TodoRepository.getInstance().getTodosDao().getSavedTodos().isEmpty()) {
                    Toast.makeText(getActivity(), "Nothing added yet!", Toast.LENGTH_SHORT).show();
                    return;
                }
                requireAppNavigator().showTodoList();
            }
        });

        btnCreateTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireAppNavigator().showCreateTodoPage();
            }
        });
    }
}
