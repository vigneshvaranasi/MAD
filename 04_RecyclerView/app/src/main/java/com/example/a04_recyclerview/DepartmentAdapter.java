package com.example.a04_recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentViewHolder> {
    Context ct;
    List<Department> depts;

    public DepartmentAdapter(Context ct,List<Department> depts) {
        this.ct = ct;
        this.depts = depts;
    }

    @NonNull
    @Override
    public DepartmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DepartmentViewHolder(LayoutInflater.from(ct).inflate(R.layout.llayout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DepartmentViewHolder holder, int position) {
        holder.dpic.setImageResource(depts.get(position).getDpic());
        holder.dname.setText(depts.get(position).getDname());
        holder.dseats.setText(depts.get(position).getDseats());
    }

    @Override
    public int getItemCount() {
        return depts.size();
    }
}
