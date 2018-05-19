package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

/**
 * used https://www.youtube.com/watch?v=uTVu3HsRIEE and cross-referenced
 * with https://developer.android.com/guide/topics/ui/layout/recyclerview
 * and back when we were using listview, we used this tutorial:https://www.youtube.com/watch?v=VYDLTBjdliY
 */
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

    /**
     * takes in a list
     * @param items
     */
    public void setItems(List<String> items){
    mItems=items;
    notifyDataSetChanged();
}

    /**
     * inflate the textViewHolder to tell it to use xml resource to create a list
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
    if (viewType==0){
        return TextViewHolder.inflate(parent);
    } else {
        return null;
    }
    }

    /**
     * for every TextView created by inflating, set its value to a list element
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    if(holder instanceof TextViewHolder){
        ((TextViewHolder)holder).bind(mItems.get(position));
    }

    }


    /**
     *  returns the size of your list
     * @return
     */
    @Override
    public int getItemCount() {
        return mItems.size();
    }

    /**
     *  returns 0 as item view type
     * @param position index in overall list
     * @return
     */
    @Override
    public int getItemViewType(int position){
    return 0;
    }

    static class TextViewHolder extends RecyclerView.ViewHolder{
    private TextView title;

        /**
         * creates a new TextViewHolder using the layout inflater to create the view
         * @param parent the ViewGroup
         * @return
         */
    public static TextViewHolder inflate(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyler_list_item, parent,false);
        return new TextViewHolder(view);
    }

        /**
         *  initalize title
         * @param itemView
         */
        public TextViewHolder(View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.title);
        }

        /**
         * set the text that will be displayed in each TextView
         * @param text
         */
        public void bind (String text){
            title.setText(text);
        }
    }
}
