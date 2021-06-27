package com.example.internprojectday1;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EmployeeRegistration extends AppCompatActivity {

    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_registration);

        Button btn = findViewById(R.id.mSubmitBtn);
        mRef = FirebaseDatabase.getInstance().getReference("employees");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // these String are meant to receive data from user

                String id = "1212";
                String name = "Abhay" ;
                String mobile = "121212";
                String email = "abhay@gmail.com";
                String designation = "Software developer";
                String reportingTo = "Manager";
                String DOJ  = "12121212";
                String rights = " These are rights";

                // Create an object of employee from above data and push it to database
                Employee newEmployee = new Employee(id,name,mobile,email,designation,reportingTo,DOJ,rights);
                mRef.push().setValue(newEmployee);

                // at the same time jump to Employee list activity
                //Intent intent = new Intent(RegisterActivity.this,EmployeeList.class);
                //startActivity(intent);

            }
        });

    }
}