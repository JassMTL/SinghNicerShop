package com.example.singhnicershop;

import android.content.Context;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.singhnicershop.model.ShoppingItems;

import java.util.LinkedList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{
    @NonNull
    private LayoutInflater mInflater;
    private final LinkedList<ShoppingItems> mdata;
    private static final String TAG = "com.example.android.singhnicershop";

    public ProductAdapter(Context context, LinkedList<ShoppingItems> list) {
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

        ShoppingItems mCurrent = mdata.get(position);
        holder.image.setImageResource(mCurrent.getImage());
        holder.title_textView.setText(mCurrent.getTitle());
        holder.description_textView.setText(mCurrent.getDescription());
        holder.price_textView.setText(mCurrent.getPrice());
        holder.quantity_textView.setText(mCurrent.getQuantity());
        holder.subtotal_textView.setText(mCurrent.getSubtotal());
    }

    //return the size of the data
    @Override
    public int getItemCount() {

        return mdata.size();
    }

    //registers the clicks
    public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        final ProductAdapter mAdapter;
        TextView title_textView;
        TextView price_textView;
        TextView description_textView;
        TextView quantity_textView;
        ImageView image;
        TextView subtotal_textView;
        Button increase;
        Button decrease;
        CardView cardView;
        //int mPosition = getLayoutPosition();
        int mPosition;

        public ProductViewHolder(@NonNull View itemView, ProductAdapter adapter) {
            super(itemView);
            this.mAdapter = adapter;

            cardView = itemView.findViewById(R.id.cardView);
            title_textView = itemView.findViewById(R.id.title_textview);
            price_textView = itemView.findViewById(R.id.price_textview);
            description_textView = itemView.findViewById(R.id.description);
            quantity_textView = itemView.findViewById(R.id.amount);
            image = itemView.findViewById(R.id.pictureView);
            subtotal_textView = itemView.findViewById(R.id.subtotal);
            increase = itemView.findViewById(R.id.increaseButton);
            decrease = itemView.findViewById(R.id.decreaseButton);
            int mPosition = getLayoutPosition();

            increase.setOnClickListener(this);
            decrease.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            //registere what button is clicked
            int position = getLayoutPosition();
            ShoppingItems sample = mdata.get(position);
            int quantity = Integer.parseInt(sample.getQuantity());
            double price = Double.parseDouble(sample.getPrice().substring(1));

            switch (v.getId()){
                case R.id.increaseButton:
                    quantity++;
                    Log.d(TAG,"Increase pressed, "+sample.getTitle() +", "+ sample.getPrice());
                    break;
                case R.id.decreaseButton:
                    if(quantity > 0)
                        quantity--;
                    Log.d(TAG,"Decrease pressed, "+sample.getTitle() +", "+ sample.getPrice());
                    break;
            }

            double subtotal = quantity*price;
            sample.setQuantity(""+quantity);
            sample.setSubtotal(""+subtotal);
            mAdapter.notifyDataSetChanged();

        }
    }
}
