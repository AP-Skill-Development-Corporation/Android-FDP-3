package com.muneiah.myroomdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = EmployeeEntity.class,version = 1,exportSchema = false)
public abstract class EmployeeDatabase extends RoomDatabase {

    //for narmal database
    public static EmployeeDatabase INSTANCE;
    public abstract EmployeeDAO employeeDAO();
    //for LiveData
    public static synchronized EmployeeDatabase getempDb(Context ctx){
        INSTANCE= Room.databaseBuilder(ctx,EmployeeDatabase.class,"employee")
                .allowMainThreadQueries()
                .build();
        return INSTANCE;
    }

}
