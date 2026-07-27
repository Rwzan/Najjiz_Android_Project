package com.example.najjiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * SQLite helper for the Najjiz Task & To-Do Manager.
 *
 * Implements exactly the single-table design planned in Phase 1:
 *   tasks(task_id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT NOT NULL, priority TEXT)
 *
 * Supported operations (as planned): INSERT, DELETE, SELECT ALL.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "najjiz.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_TASKS = "tasks";
    public static final String COLUMN_ID = "task_id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_PRIORITY = "priority";

    private static final String CREATE_TABLE_TASKS =
            "CREATE TABLE " + TABLE_TASKS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_TITLE + " TEXT NOT NULL, " +
                    COLUMN_PRIORITY + " TEXT" +
                    ");";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_TASKS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASKS);
        onCreate(db);
    }

    /** INSERT a new task. Returns the new row id, or -1 on failure. */
    public long insertTask(String title, String priority) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, title);
        values.put(COLUMN_PRIORITY, priority);
        long newId = db.insert(TABLE_TASKS, null, values);
        db.close();
        return newId;
    }

    /** DELETE a task by its id. Returns the number of rows deleted. */
    public int deleteTask(int taskId) {
        SQLiteDatabase db = getWritableDatabase();
        int rows = db.delete(TABLE_TASKS, COLUMN_ID + " = ?",
                new String[]{String.valueOf(taskId)});
        db.close();
        return rows;
    }

    /** SELECT ALL tasks, most recently added first. */
    public List<Task> getAllTasks() {
        List<Task> taskList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_TASKS,
                new String[]{COLUMN_ID, COLUMN_TITLE, COLUMN_PRIORITY},
                null, null, null, null,
                COLUMN_ID + " DESC"
        );

        if (cursor != null) {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID));
                String title = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE));
                String priority = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PRIORITY));
                taskList.add(new Task(id, title, priority));
            }
            cursor.close();
        }
        db.close();
        return taskList;
    }
}
