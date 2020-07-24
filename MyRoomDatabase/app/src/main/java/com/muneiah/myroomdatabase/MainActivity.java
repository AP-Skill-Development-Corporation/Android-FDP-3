package com.muneiah.myroomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
EditText name,id;
RecyclerView rec;
static EmployeeDatabase empDb;
EmplyeeAdapter adapter;
List<EmployeeEntity> employeeEntityList;
EmployeeEntity empEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.emp_name);
        id=findViewById(R.id.emp_id);
        rec=findViewById(R.id.recycler);
        empDb= Room.databaseBuilder(this,EmployeeDatabase.class,"employee")
                .allowMainThreadQueries()
                .build();
    }

    public void saveData(View view) {
        String empoyeeName=name.getText().toString();
        String empoyeeid=id.getText().toString();
        empEntity=new EmployeeEntity();
        empEntity.setId(empoyeeid);
        empEntity.setName(empoyeeName);
        empDb.employeeDAO().insert(empEntity);
        Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
    }

    public void retriveData(View view) {
        employeeEntityList=empDb.employeeDAO().retrive();
        adapter=new EmplyeeAdapter(this,employeeEntityList);
        rec.setLayoutManager(new LinearLayoutManager(this));
        rec.setAdapter(adapter);


    }
}
