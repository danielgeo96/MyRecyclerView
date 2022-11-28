package com.example.myrecyclerview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Recycler extends Fragment {

    private ArrayList<HeroData> dataSet;
    private RecyclerView recycleView;
    private LinearLayoutManager layoutManager;
    private HeroAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_recycler, container, false);

        recycleView = (RecyclerView) view.findViewById(R.id.fragment_recycler_recyclerview);
        layoutManager = new LinearLayoutManager(this.getContext());
        recycleView.setLayoutManager(layoutManager);
        recycleView.setItemAnimator(new DefaultItemAnimator());

        dataSet = new ArrayList<HeroData>();

        for(int i=0 ; i<MyData.nameArray.length ; i++) {
            dataSet.add(new HeroData(MyData.nameArray[i], MyData.descriptionArray[i], MyData.id_[i], MyData.drawableArray[i]));
        }

        adapter = new HeroAdapter(dataSet);
        recycleView.setAdapter(adapter);

        adapter.setOnClickListener(new HeroAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {

                Bundle bundle = new Bundle();
                bundle.putString("description", dataSet.get(position).getDescription());
                bundle.putInt("img",dataSet.get(position).getImg());

                try {
                    Navigation.findNavController(view).navigate(R.id.action_recycler_to_description2, bundle);
                }finally {
                    Log.e("tag","error");
                }
            }
        });

        return view;
    }
}