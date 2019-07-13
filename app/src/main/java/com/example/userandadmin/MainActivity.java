package com.example.userandadmin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button adminButton, employeeButton, employeeLogin;
    EditText idEditeText;
    LinearLayout employeeHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        adminButton = findViewById(R.id.adminButton);
        employeeButton = findViewById(R.id.employeeButton);

        employeeHolder = findViewById(R.id.employeeHolder);
        idEditeText = findViewById(R.id.idEditText);
        employeeLogin = findViewById(R.id.employeeLogin);


        employeeHolder.setVisibility(View.GONE);


        adminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You clicked on admin", Toast.LENGTH_SHORT).show();
            }
        });

        employeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                employeeHolder.setVisibility(View.VISIBLE);
                adminButton.setVisibility(View.GONE);
                employeeButton.setVisibility(View.GONE);
            }
        });

        employeeLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(idEditeText.getText().toString().isEmpty())
                    idEditeText.setError("please enter your id!");

                else
                {
                    // go to content acitivty...

                    if(idEditeText.getText().toString().equals("123"))
                    {
                        Intent intent = new Intent(MainActivity.this, EmployeeDashboard.class);
                        intent.putExtra("employeeID", idEditeText.getText().toString());
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });





    }
}
