package com.muneiah.myroomdatabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = EmployeeEntity.class,version = 1,exportSchema = false)
public abstract class EmployeeDatabase extends RoomDatabase {
    //for narmal database
    public static EmployeeDatabase INSTANCE;
    public abstract EmployeeDAO employeeDAO();


}
