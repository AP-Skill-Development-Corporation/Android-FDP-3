package com.muneiah.myroomdatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmplyeeAdapter extends RecyclerView.Adapter<EmplyeeAdapter.EmployeeViewHolder> {
    Context ctx;
    List<EmployeeEntity> employeeEntityList;

    public EmplyeeAdapter(Context ctx, List<EmployeeEntity> employeeEntityList) {
        this.ctx = ctx;
        this.employeeEntityList = employeeEntityList;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(ctx).inflate(R.layout.row_design,parent,false);
        return new EmployeeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        holder.empid.setText(employeeEntityList.get(position).getId());
        holder.empname.setText(employeeEntityList.get(position).getName());
        holder.empdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.empDb.employeeDAO().delete(employeeEntityList.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return employeeEntityList.size();
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder {
        TextView empname,empid,empedit,empdelete;
        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            empdelete=itemView.findViewById(R.id.delete_row);
            empedit=itemView.findViewById(R.id.update_row);
            empname=itemView.findViewById(R.id.emp_name_row);
            empid=itemView.findViewById(R.id.emp_id_row);

        }
    }
}
