package com.muneiah.myroomdatabase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class EmployeeViewModel extends AndroidViewModel {
    EmployeeRepo employeeRepo;
    LiveData<List<EmployeeEntity>> liveDataModel;

    public EmployeeViewModel(@NonNull Application application) {
        super(application);
        employeeRepo=new EmployeeRepo(application);
        liveDataModel=employeeRepo.listLiveData;
    }
    public void insert(EmployeeEntity entity){
        employeeRepo.insert(entity);
    }
    public void update(EmployeeEntity entity){
        employeeRepo.update(entity);
    }
    public void delete(EmployeeEntity entity){
        employeeRepo.delete(entity);
    }
    public LiveData<List<EmployeeEntity>> liveData(){
        return liveDataModel;
    }
}
