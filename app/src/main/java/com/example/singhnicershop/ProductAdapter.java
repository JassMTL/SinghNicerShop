package com.example.singhnicershop;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{
    @NonNull
    private LayoutInflater mInflater;
    private final LinkedList<String> mdata;

    public ProductAdapter(Context context, LinkedList<String> list) {
            mInflater = LayoutInflater.from(context);
            this.mdata = list;
        }

    //inflate the item layout and return a ViewHolder object
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mItemView = mInflater.inflate(R.layout.card1_content,viewGroup,false);
        return new ProductViewHolder(mItemView, this);
    }

    // set the ViewHolder attributes based on the position of the item
    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {
        String mCurrent = mdata.get(position);
        holder.wordItemView.setText(mCurrent);
    }

    //return the size of the data
    @Override
    public int getItemCount() {

        return mdata.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        int mPosition = getLayoutPosition();
        String element = mdata.get(mPosition);
        public ProductViewHolder(@NonNull View itemView, ProductAdapter adapter) {
            super(itemView);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }
    }
}
