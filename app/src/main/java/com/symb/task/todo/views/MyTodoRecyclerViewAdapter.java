package com.symb.task.todo.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.symb.task.todo.R;
import com.symb.task.todo.common.Todo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class MyTodoRecyclerViewAdapter extends RecyclerView.Adapter<MyTodoRecyclerViewAdapter.ViewHolder> {

    private final List<Todo> mValues;

    MyTodoRecyclerViewAdapter(List<Todo> items) {
        mValues = new ArrayList<>(items);
        Collections.reverse(mValues);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_todo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mtext.setText(mValues.get(position).getTodoText());
        holder.mTime.setText(getTimeDisplayString(mValues.get(position).getAddedTimeStamp()));
    }
    private static final String DEFAULT_TIMESTAMP_FORMAT = "dd/MM/yyyy HH:mm";

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    private static String getTimeDisplayString(long timeInMillis) {
        return new SimpleDateFormat(DEFAULT_TIMESTAMP_FORMAT).format(new Date(timeInMillis));
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView mtext;
        private final TextView mTime;

        private ViewHolder(View view) {
            super(view);
            mtext = view.findViewById(R.id.tvTodoText);
            mTime = view.findViewById(R.id.tvTodoTime);
        }

    }
}
