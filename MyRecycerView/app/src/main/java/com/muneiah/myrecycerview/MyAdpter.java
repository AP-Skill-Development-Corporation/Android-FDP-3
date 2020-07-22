package com.muneiah.myrecycerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdpter extends RecyclerView.Adapter<MyAdpter.MyViewHolder> {
    Context ctx;
    int img[];
    String tt[];
    String subtt[];
    //for creating constructor alt+insert or right click click on genereate


    public MyAdpter(Context ctx, int[] img, String[] tt, String[] subtt) {
        this.ctx = ctx;
        this.img = img;
        this.tt = tt;
        this.subtt = subtt;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(ctx).inflate(R.layout.row_design,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.t.setText(tt[position]);
        holder.st.setText(subtt[position]);
        holder.iv.setImageResource(img[position]);

    }

    @Override
    public int getItemCount() {
        return img.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView t,st;
        ImageView iv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            t=itemView.findViewById(R.id.mytitle);
            st=itemView.findViewById(R.id.subtitle);
            iv=itemView.findViewById(R.id.myImage);
        }
    }
}
