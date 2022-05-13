package com.example.resto;

//import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button editLoginButton;
    private TextView editTextForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        editLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editTextPassword = findViewById(R.id.editTextPassword);
                String password = editTextPassword.getText().toString();

                EditText editUserName = findViewById(R.id.editUserName);
                String message = editUserName.getText().toString();
                String atom_message;
                if (message.equals("admin") &&
                    password.equals("ewce@123")){
                        atom_message =  (message + " Login Successful ");
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(intent);
                        Toast.makeText(MainActivity.this, atom_message, Toast.LENGTH_SHORT).show();
                        editTextPassword.setText("");
                        editUserName.setText("");

                    }
                else{
                    atom_message =  ("Invalid User Credentials");
                    Toast.makeText(MainActivity.this, atom_message, Toast.LENGTH_SHORT).show();
                }

            }
        });






    }

    private void initViews(){
        editLoginButton = findViewById(R.id.editLoginBtn);
    }







}