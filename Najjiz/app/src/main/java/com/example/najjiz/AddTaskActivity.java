package com.example.najjiz;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Lets the user create a new task (title + priority) and INSERTs it
 * into the SQLite database, then returns to MyTasksActivity.
 */
public class AddTaskActivity extends AppCompatActivity {

    private EditText editTextTitle;
    private RadioGroup radioGroupPriority;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        databaseHelper = new DatabaseHelper(this);

        editTextTitle = findViewById(R.id.edit_text_title);
        radioGroupPriority = findViewById(R.id.radio_group_priority);
        Button buttonSave = findViewById(R.id.button_save);
        TextView buttonBack = findViewById(R.id.button_back);

        buttonBack.setOnClickListener(v -> finish());

        buttonSave.setOnClickListener(v -> saveTask());
    }

    private void saveTask() {
        String title = editTextTitle.getText().toString().trim();
        if (title.isEmpty()) {
            Toast.makeText(this, "Please enter a task title", Toast.LENGTH_SHORT).show();
            return;
        }

        int checkedId = radioGroupPriority.getCheckedRadioButtonId();
        String priority = "Medium";
        if (checkedId == R.id.radio_high) {
            priority = "High";
        } else if (checkedId == R.id.radio_medium) {
            priority = "Medium";
        } else if (checkedId == R.id.radio_low) {
            priority = "Low";
        }

        long newId = databaseHelper.insertTask(title, priority);
        if (newId != -1) {
            Toast.makeText(this, "Task saved", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Failed to save task", Toast.LENGTH_SHORT).show();
        }
    }
}
