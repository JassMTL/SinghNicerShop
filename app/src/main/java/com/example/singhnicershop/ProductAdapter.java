package com.example.singhnicershop;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.singhnicershop.model.ShoppingItems;

import java.util.LinkedList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{
    @NonNull
    private LayoutInflater mInflater;
    private final LinkedList<ShoppingItems> mdata;

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
    }

    //return the size of the data
    @Override
    public int getItemCount() {

        return mdata.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        final ProductAdapter mAdapter;
        TextView title_textView;
        TextView price_textView;
        TextView description_textView;
        TextView quantity_textView;
        ImageView image;
        int mPosition = getLayoutPosition();
        //String element = mdata.get(mPosition);

        public ProductViewHolder(@NonNull View itemView, ProductAdapter adapter) {
            super(itemView);
            title_textView = itemView.findViewById(R.id.title_textview);
            price_textView = itemView.findViewById(R.id.price_textview);
            description_textView = itemView.findViewById(R.id.description);
            quantity_textView = itemView.findViewById(R.id.amount);
            image = itemView.findViewById(R.id.pictureView);

            this.mAdapter = adapter;
            //itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
