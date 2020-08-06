package com.symb.task.todo.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

import com.symb.task.todo.TodoAppController;
import com.symb.task.todo.common.Todo;
import com.symb.task.todo.common.TodosDao;

import java.util.ArrayList;
import java.util.List;

public class TodoSqlDao implements TodosDao {


    private DbHandler dbHandler;

    private TodoSqlDao() {
        dbHandler = new DbHandler(TodoAppController.getInstance());
    }

    static TodoSqlDao getInstance() {
        if (mInstance == null) {
            mInstance = new TodoSqlDao();
        }
        return mInstance;
    }

    private static TodoSqlDao mInstance;


    @Override
    public void closeDao() {
        dbHandler.close();
    }

    @Override
    public boolean saveTodo(Todo todoToSave) {

        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues cValues = new ContentValues();
        cValues.put(DbHandler.KEY_TEXT, todoToSave.getTodoText());
        cValues.put(DbHandler.KEY_TIME, todoToSave.getAddedTimeStamp());
        long newRowId = db.insert(DbHandler.TABLE_NAME, null, cValues);

        return newRowId > -1;
    }

    @NonNull
    @Override
    public List<Todo> getSavedTodos() {

        SQLiteDatabase db = dbHandler.getWritableDatabase();
        List<Todo> todoList = new ArrayList<>();
        String query = "SELECT " + DbHandler.KEY_TEXT + ", " + DbHandler.KEY_TIME + " FROM  " + DbHandler.TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            String text = cursor.getString(cursor.getColumnIndex(DbHandler.KEY_TEXT));
            long time = cursor.getLong(cursor.getColumnIndex(DbHandler.KEY_TIME));
            todoList.add(new TodoEntity(text, time));
        }
        cursor.close();
        return todoList;
    }


    public static class DbHandler extends SQLiteOpenHelper {
        private static final int DB_VERSION = 1;
        private static final String DB_NAME = "todos_db";
        private static final String TABLE_NAME = "todos";
        private static final String KEY_ID = "id";
        private static final String KEY_TEXT = "text";
        private static final String KEY_TIME = "time";

        DbHandler(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                    + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_TEXT + " TEXT,"
                    + KEY_TIME + " TEXT"
                    + ")";
            db.execSQL(CREATE_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // Drop older table if exist
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            // Create tables again
            onCreate(db);
        }
    }

}
