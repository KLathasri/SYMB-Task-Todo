package com.symb.task.todo.views;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.symb.task.todo.common.AppNavigator;
import com.symb.task.todo.R;
import com.symb.task.todo.data.TodoEntity;
import com.symb.task.todo.data.TodoRepository;

import java.util.Objects;


public class CreateTodoFragment extends Fragment {


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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_todo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }
    private AppCompatEditText etTodoText;

    private void initViews(@NonNull View rootView) {
        View btnSaveTodo = rootView.findViewById(R.id.btnSaveTodo);
        etTodoText = rootView.findViewById(R.id.etTodoText);

        btnSaveTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateAndSaveTodo();
            }
        });
    }

    private void validateAndSaveTodo() {
        String todoText = Objects.requireNonNull(etTodoText.getText()).toString();
        if (TextUtils.isEmpty(todoText)) {
            etTodoText.setError("Text must not be empty!!!");
        } else {
            boolean success = TodoRepository.getInstance().getTodosDao().
                    saveTodo(new TodoEntity(todoText, System.currentTimeMillis()));
            if (success) {
                Toast.makeText(getActivity(), "Todo saved successfully!!!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity(), "Cannot save right now.", Toast.LENGTH_SHORT).show();
            }
            requireAppNavigator().closeCreateTodoPage();
        }
    }

}
