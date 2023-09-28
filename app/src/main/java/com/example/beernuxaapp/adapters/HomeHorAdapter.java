package com.example.beernuxaapp.adapters;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beernuxaapp.R;
import com.example.beernuxaapp.models.HomeHorModel;
import com.example.beernuxaapp.models.HomeVerModel;

import java.util.ArrayList;
import java.util.List;

public class HomeHorAdapter extends RecyclerView.Adapter<HomeHorAdapter.ViewHolder> {

    UpdateVerticalRec updateVerticalRec;
    Activity activity;
   
    ArrayList<HomeHorModel> list;

    boolean check = true;
    boolean select = true;
    int row_index = -1;


    public HomeHorAdapter(UpdateVerticalRec updateVerticalRec, Activity activity, ArrayList<HomeHorModel> list) {
        this.updateVerticalRec = updateVerticalRec;
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizontal_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());

        if (check) {
            ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
            homeVerModels.add(new HomeVerModel(R.drawable.side_nav_bar,R.drawable.melon_ale,"CRAFT BEAR", "MELON",R.drawable.prosent,"5.6%","IBU","43","SIZE","330ML"));
            homeVerModels.add(new HomeVerModel(R.drawable.side_nav_bar,R.drawable.dargett_ale,"CRAFT BEAR", "DARGETT",R.drawable.prosent,"5.0%","IBU","35","SIZE","330ML"));

            updateVerticalRec.callBack(position, homeVerModels);
            check = false;

        }
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    row_index = position;
                    notifyDataSetChanged();


                    if (position == 0) //Ale
                    {
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add(new HomeVerModel(R.drawable.side_nav_bar,R.drawable.melon_ale,"CRAFT BEAR", "MELON",R.drawable.prosent,"5.6%","IBU","43","SIZE","330ML"));
                        homeVerModels.add(new HomeVerModel(R.drawable.side_nav_bar,R.drawable.dargett_ale,"CRAFT BEAR", "DARGETT",R.drawable.prosent,"5.0%","IBU","35","SIZE","330ML"));

                        updateVerticalRec.callBack(position,homeVerModels);
                    }
                    else if (position == 1) // Wit
                    {
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add(new HomeVerModel(R.drawable.side_nav_bar,R.drawable.wit1,"CRAFT BEAR", "ПАСХАЛОЧКА",R.drawable.prosent,"4.1%","IBU","28","SIZE","485ML"));
                        homeVerModels.add(new HomeVerModel(R.drawable.side_nav_bar,R.drawable.banana_wit,"CRAFT BEAR", "BANANA KONIX",R.drawable.prosent,"4.3%","IBU","31","SIZE","330ML"));
                        updateVerticalRec.callBack(position,homeVerModels);
                    }
                    else if (position == 2) // Stout
                    {
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add(new HomeVerModel(R.drawable.side_nav_bar,R.drawable.staut_imp,"CRAFT BEAR", "RU IMPERIAL",R.drawable.prosent,"11%","IBU","28","SIZE","330ML"));
                        homeVerModels.add(new HomeVerModel(R.drawable.side_nav_bar,R.drawable.imp_stout,"CRAFT BEAR", "MAINSTREAM",R.drawable.prosent,"4.1%","IBU","24","SIZE","485ML"));

                        updateVerticalRec.callBack(position,homeVerModels);
                    }
                }
            });

            if (select)
            {
                if (position == 0)
                {
                    holder.cardView.setBackgroundResource(R.drawable.change_bg);
                    select = false;
                }
            }
            else
            {
                if(row_index == position)
                {
                    holder.cardView.setBackgroundResource(R.drawable.change_bg);
                }else {
                    holder.cardView.setBackgroundResource(R.drawable.default_bg);
                }
            }

        }
        


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.hor_img);
            name = itemView.findViewById(R.id.hor_text);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
