package com.example.najjiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * The app's launcher screen. Welcomes the user, collects their name,
 * then navigates to MyTasksActivity, exactly as planned in Phase 1.
 */
public class RegisterActivity extends AppCompatActivity {

    private EditText editTextName;
    private Button buttonStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextName = findViewById(R.id.edit_text_name);
        buttonStart = findViewById(R.id.button_start);

        buttonStart.setOnClickListener(v -> {
            String name = editTextName.getText().toString().trim();
            if (name.isEmpty()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
                return;
            }
            Intent intent = new Intent(RegisterActivity.this, MyTasksActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
