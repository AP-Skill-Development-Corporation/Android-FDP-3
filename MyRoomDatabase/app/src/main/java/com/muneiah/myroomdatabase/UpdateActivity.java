package com.muneiah.myroomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
EditText n,i;
EmployeeEntity entity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        n=findViewById(R.id.update_emp_name);
        i=findViewById(R.id.update_emp_id);
        Intent intent=getIntent();
        String resName=intent.getStringExtra("name");
        String resID=intent.getStringExtra("id");
        n.setText(resName);
        i.setText(resID);
        i.setKeyListener(null);//for not editable

    }

    public void updateData(View view) {
        entity=new EmployeeEntity();
        String empNAME=n.getText().toString();
        String empID=i.getText().toString();
        entity.setName(empNAME);
        entity.setId(empID);
       // MainActivity.empDb.employeeDAO().update(entity);for normal database
        //for live data
        MainActivity.viewModel.update(entity);
        Toast.makeText(this, "Updated : "+empNAME, Toast.LENGTH_SHORT).show();
Intent intent=new Intent(this,MainActivity.class);
startActivity(intent);

    }
}
