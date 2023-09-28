package com.example.beernuxaapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beernuxaapp.R;
import com.example.beernuxaapp.models.HomeVerModel;

import java.util.ArrayList;
import java.util.List;

public class HomeVerAdapter extends RecyclerView.Adapter<HomeVerAdapter.ViewHolder> {

    Context context;
    ArrayList<HomeVerModel> list;



    public HomeVerAdapter(Context context, ArrayList<HomeVerModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_vertical_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.imageView1.setImageResource(list.get(position).getImage1());
        holder.imageView2.setImageResource(list.get(position).getImage2());
        holder.icon.setImageResource(list.get(position).getIcon());
        holder.name.setText(list.get(position).getName());
        holder.numb1.setText(list.get(position).getNumb1());
        holder.numb1.setText(list.get(position).getNumb2());
        holder.proce.setText(list.get(position).getProce());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView1,imageView2, icon;
        TextView surname,name,proce,ibu, numb1,size,numb2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView1 = itemView.findViewById(R.id.img_back);
            imageView2 = itemView.findViewById(R.id.ver_img);
            surname = itemView.findViewById(R.id.surname);
            name = itemView.findViewById(R.id.name);
            icon = itemView.findViewById(R.id.icon);
            proce = itemView.findViewById(R.id.prose);
            ibu = itemView.findViewById(R.id.ibu);
            numb1 = itemView.findViewById(R.id.numb1);
            size = itemView.findViewById(R.id.size);
            numb2 = itemView.findViewById(R.id.numb2);
        }
    }
}
