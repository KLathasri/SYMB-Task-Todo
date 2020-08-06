package com.symb.task.todo.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.symb.task.todo.common.AppNavigator;
import com.symb.task.todo.R;
import com.symb.task.todo.data.TodoRepository;

public class MainActivity extends AppCompatActivity implements AppNavigator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showHomeFragment();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        TodoRepository.getInstance().getTodosDao().closeDao();
    }

    private void showHomeFragment() {
        getSupportFragmentManager().beginTransaction().
                add(R.id.fragment_content, new TodoHomeFragment(), TodoHomeFragment.class.getSimpleName()).
                commit();
    }

    @Override
    public void showTodoList() {
        getSupportFragmentManager().beginTransaction().
                add(R.id.fragment_content, new TodoListFragment(), TodoListFragment.class.getSimpleName()).
                addToBackStack(null).
                commit();
    }

    @Override
    public void showCreateTodoPage() {
        getSupportFragmentManager().beginTransaction().
                add(R.id.fragment_content, new CreateTodoFragment(), CreateTodoFragment.class.getSimpleName()).
                addToBackStack(null).
                commit();
    }

    @Override
    public void closeCreateTodoPage() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void closeTodoListPage() {
        getSupportFragmentManager().popBackStack();
    }
}
