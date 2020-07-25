package com.muneiah.myroomdatabase;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class EmployeeRepo
{
    EmployeeDatabase employeeDatabase;
    LiveData<List<EmployeeEntity>> listLiveData;
    public EmployeeRepo(Application app){
        employeeDatabase=EmployeeDatabase.getempDb(app);
        listLiveData=employeeDatabase.employeeDAO().liveData();


    }
    //Insert
    public class AsyncTAskInsert extends AsyncTask<EmployeeEntity,Void,Void> {

        @Override
        protected Void doInBackground(EmployeeEntity... employeeEntities) {
            employeeDatabase.employeeDAO().insert(employeeEntities[0]);
            return null;
        }
    }

        //update
        public class AsyncTAskUpdate extends AsyncTask<EmployeeEntity, Void, Void> {

            @Override
            protected Void doInBackground(EmployeeEntity... employeeEntities) {
                employeeDatabase.employeeDAO().update(employeeEntities[0]);
                return null;
            }
        }
    //delete
    public class AsyncTAskDelete extends AsyncTask<EmployeeEntity,Void,Void> {

        @Override
        protected Void doInBackground(EmployeeEntity... employeeEntities) {
            employeeDatabase.employeeDAO().delete(employeeEntities[0]);
            return null;
        }
    }
    //for retrive
    public LiveData<List<EmployeeEntity>> getListLiveData(){
        return listLiveData;
    }
    public void insert(EmployeeEntity employeeEntity){
        new AsyncTAskInsert().execute(employeeEntity);
    }
    public void update(EmployeeEntity employeeEntity){
        new AsyncTAskUpdate().execute(employeeEntity);
    }
    public void delete(EmployeeEntity employeeEntity){
        new AsyncTAskDelete().execute(employeeEntity);
    }
}
