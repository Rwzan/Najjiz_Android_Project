package com.example.najjiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Main dashboard. Displays all tasks in a RecyclerView (SELECT ALL),
 * lets the user open AddTaskActivity via the FAB, and delete a task
 * through a DialogFragment confirmation (DELETE), as planned in Phase 1.
 */
public class MyTasksActivity extends AppCompatActivity
        implements DeleteConfirmDialogFragment.OnDeleteConfirmedListener {

    private DatabaseHelper databaseHelper;
    private RecyclerView recyclerView;
    private TaskAdapter taskAdapter;
    private final List<Task> taskList = new ArrayList<>();
    private TextView emptyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tasks);

        databaseHelper = new DatabaseHelper(this);

        recyclerView = findViewById(R.id.recycler_view_tasks);
        emptyText = findViewById(R.id.text_empty);
        FloatingActionButton fabAddTask = findViewById(R.id.fab_add_task);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        taskAdapter = new TaskAdapter(taskList, this::showDeleteConfirmation);
        recyclerView.setAdapter(taskAdapter);

        fabAddTask.setOnClickListener(v -> {
            Intent intent = new Intent(MyTasksActivity.this, AddTaskActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Refresh the list every time the screen becomes visible,
        // so newly added or deleted tasks are always shown (SELECT ALL).
        loadTasks();
    }

    private void loadTasks() {
        taskList.clear();
        taskList.addAll(databaseHelper.getAllTasks());
        taskAdapter.notifyDataSetChanged();
        emptyText.setVisibility(taskList.isEmpty() ? View.VISIBLE : View.GONE);
    }

    private void showDeleteConfirmation(Task task) {
        DeleteConfirmDialogFragment dialog =
                DeleteConfirmDialogFragment.newInstance(task.getId(), task.getTitle());
        dialog.setOnDeleteConfirmedListener(this);
        dialog.show(getSupportFragmentManager(), "delete_confirm");
    }

    @Override
    public void onDeleteConfirmed(int taskId) {
        databaseHelper.deleteTask(taskId);
        loadTasks();
    }
}
