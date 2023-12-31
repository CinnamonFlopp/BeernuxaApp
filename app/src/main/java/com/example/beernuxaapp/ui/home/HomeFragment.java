package com.example.beernuxaapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beernuxaapp.R;
import com.example.beernuxaapp.adapters.HomeHorAdapter;
import com.example.beernuxaapp.adapters.HomeVerAdapter;
import com.example.beernuxaapp.adapters.UpdateVerticalRec;
import com.example.beernuxaapp.databinding.FragmentHomeBinding;
import com.example.beernuxaapp.models.HomeHorModel;
import com.example.beernuxaapp.models.HomeVerModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements UpdateVerticalRec {

    RecyclerView homeHorizontalRec,homeVerticalRec;
    ArrayList<HomeHorModel> homeHorModelList;
    HomeHorAdapter homeHorAdapter;

    /////Vertical
    ArrayList<HomeVerModel> homeVerModelList;
    HomeVerAdapter homeVerAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home,container,false);

        homeHorizontalRec = root.findViewById(R.id.home_hor_rec);
        homeVerticalRec = root.findViewById(R.id.home_ver_rec);


        ///////////////Horizontal RecyclerView





        homeHorModelList = new ArrayList<>();

        homeHorModelList.add(new HomeHorModel(R.drawable.ale,"Ale"));
        homeHorModelList.add(new HomeHorModel(R.drawable.wit,"Wit"));
        homeHorModelList.add(new HomeHorModel(R.drawable.stout,"Stout"));
        homeHorModelList.add(new HomeHorModel(R.drawable.pilsner,"Pilsner"));
        homeHorModelList.add(new HomeHorModel(R.drawable.porter,"Porter"));
        homeHorModelList.add(new HomeHorModel(R.drawable.kriek,"Kriek"));

        homeHorAdapter = new HomeHorAdapter(this,getActivity(),homeHorModelList);
        homeHorizontalRec.setAdapter(homeHorAdapter);
        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        homeHorizontalRec.setHasFixedSize(true);
        homeHorizontalRec.setNestedScrollingEnabled(false);


        ///////////////Vertical RecyclerView

        homeVerModelList = new ArrayList<>();

        homeVerAdapter = new HomeVerAdapter(getActivity(),homeVerModelList);
        homeVerticalRec.setAdapter(homeVerAdapter);
        homeVerticalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));



        return root;
    }


    @Override
    public void callBack(int position, ArrayList<HomeVerModel> list) {

        homeVerAdapter = new HomeVerAdapter(getContext(),list);

        homeVerAdapter.notifyDataSetChanged();
        homeVerticalRec.setAdapter(homeVerAdapter);

    }
}