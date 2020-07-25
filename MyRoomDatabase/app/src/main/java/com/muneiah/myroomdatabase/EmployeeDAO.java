package com.muneiah.myroomdatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EmployeeDAO {
    @Insert
    public void insert(EmployeeEntity employeeEntity);

    @Update
    public void update(EmployeeEntity employeeEntity);

    @Delete
    public void delete(EmployeeEntity employeeEntity);

    @Query("SELECT * FROM employee_table")
    //public List<EmployeeEntity> retrive();//nor database
    public LiveData<List<EmployeeEntity>> liveData();//for live data
}
