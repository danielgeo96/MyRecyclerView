package com.example.myrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.MyViewHolder> {

    public ArrayList<HeroData> mData;

    public HeroAdapter(ArrayList<HeroData> data) {
        mData = data;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder  {
        TextView textViewName;
        TextView textViewDescription;
        ImageView imageViewIcon;
        HeroAdapter.OnItemClickListener listener;
        int position;


        public MyViewHolder (View itemView )
        {
            super(itemView);

            textViewName = ( TextView) itemView.findViewById(R.id.row_list_name);
            textViewDescription = ( TextView) itemView.findViewById(R.id.row_list_description);
            imageViewIcon = (ImageView) itemView.findViewById(R.id.row_list_img);

            itemView.setOnClickListener(v -> listener.OnItemClick(position));

        }

        public void bindData(HeroData heroData, int position) {

            textViewName.setText(heroData.getName());
            textViewDescription.setText(heroData.getDescription());
            imageViewIcon.setImageResource(heroData.getImg());

            this.position = position;
        }

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list,parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        holder.listener = listener;
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

//        TextView textViewName = holder.textViewName;
//        TextView textViewDescription = holder.textViewDescription;
//        ImageView imageView = holder.imageViewIcon;

//        textViewName.setText(mData.get(position).getName());
//        textViewDescription.setText(mData.get(position).getDescription());
//        imageView.setImageResource(mData.get(position).getImg());

        holder.bindData(mData.get(position),position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public interface OnItemClickListener{
        void OnItemClick(int position);
    }

    private OnItemClickListener listener;

    public void setOnClickListener(OnItemClickListener listener){
        this.listener = listener;
    }


}
