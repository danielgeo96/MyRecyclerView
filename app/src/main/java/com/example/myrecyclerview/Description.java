package com.example.myrecyclerview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Description extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_description, container, false);

        TextView textView = view.findViewById(R.id.textDescription);
        ImageView img = view.findViewById(R.id.imgDescription);

        textView.setText(getArguments().get("description").toString());
        img.setImageResource((Integer) getArguments().get("img"));



        return view;
    }
}