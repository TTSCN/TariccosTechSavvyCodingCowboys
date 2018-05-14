package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {
private List <String> mItems;

public void setItems(List<String> items){
    mItems=items;
    notifyDataSetChanged();
}

//    // Provide a suitable constructor (depends on the kind of dataset)
//    public MyAdapter(ArrayList<String> myDataset) {
//        this.mItems = myDataset;
//    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
    if (viewType==0){
        return TextViewHolder.inflate(parent);
    } else {
        return null;
    }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    if(holder instanceof TextViewHolder){
        ((TextViewHolder)holder).bind(mItems.get(position));
    }

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public int getItemViewType(int position){
    return 0;
    }

    static class TextViewHolder extends RecyclerView.ViewHolder{
    private TextView title;
    private TextView description;

    public static TextViewHolder inflate(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyler_list_item, parent,false);
        return new TextViewHolder(view);
    }

        public TextViewHolder(View itemView){
            super(itemView);

            title = itemView.findViewById(R.id.title);
//            description = itemView.findViewById(R.id.descriptions);
        }

        public void bind (String text){
            title.setText(text);
//            description.setText(text);
        }
    }
}
