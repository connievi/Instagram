package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class CreateAccountActivity extends AppCompatActivity {
    public static final String TAG = "CreateAccountActivity";
    private EditText etEmail;
    private EditText etUsername;
    private EditText etPassword;
    private Button btnCreate;
    private ImageView etIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        etEmail = findViewById(R.id.etEmail);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnCreate = findViewById(R.id.btnCreate);
        etIcon = findViewById(R.id.etIcon);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                if (username.isEmpty()) {
                    Toast.makeText(CreateAccountActivity.this, "Username cannot be empty.", Toast.LENGTH_SHORT).show();
                    return;
                }

                String password = etPassword.getText().toString();
                if (password.isEmpty()) {
                    Toast.makeText(CreateAccountActivity.this, "Password cannot be empty.", Toast.LENGTH_SHORT).show();
                    return;
                }

                String email = etEmail.getText().toString();
                if (password.isEmpty()) {
                    Toast.makeText(CreateAccountActivity.this, "Email cannot be empty.", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    saveUser(email, username, password);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void saveUser(String email, String username, String password) throws ParseException {
        ParseUser newUser = new ParseUser();
        newUser.put("username", username);
        newUser.put("password", password);
        newUser.put("email", email);
        newUser.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null) {
                    Log.e(TAG, "Issue with login", e);
                    Toast.makeText(CreateAccountActivity.this, "Issue with creating account!", Toast.LENGTH_SHORT).show();
                    return;
                }
                goMainActivity();
            }
        });
    }

    private void goMainActivity() {
        Intent i = new Intent(this, MainActivity.class); // this refers to this activity which is a context
        startActivity(i);
        finish();
    }
}