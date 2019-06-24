package com.example.androideatit.ViewHolder;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.example.androideatit.Interface.ItemClickListener;
import com.example.androideatit.Model.Order;
import com.example.androideatit.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView txt_card_name, txt_price;
    public ImageView img_card_count;

    private ItemClickListener itemClickListener;

    public void setTxt_card_name(TextView txt_card_name) {
        this.txt_card_name = txt_card_name;
    }

    public CardViewHolder(@NonNull View itemView) {
        super(itemView);
        txt_card_name = (TextView) itemView.findViewById(R.id.card_item_name);
        txt_price = (TextView) itemView.findViewById(R.id.card_item_Price);
        img_card_count = (ImageView) itemView.findViewById(R.id.card_item_count);
    }

    @Override
    public void onClick(View view) {

    }
}

public class CartAdapter extends RecyclerView.Adapter<CardViewHolder>{

    private List<Order> listData = new ArrayList<>();
    private Context context;

    public CartAdapter(List<Order> listData, Context context) {
        this.listData = listData;
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.cart_layout,parent,false);
        return new CardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        TextDrawable drawable  = TextDrawable.builder().
                buildRound(""+listData.get(position).getQuantity(), Color.RED);
        holder.img_card_count.setImageDrawable(drawable);

        Locale locale = new Locale("en","US");
        NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
        int price = (Integer.parseInt(listData.get(position).getPrice()))*(Integer.parseInt(listData.get(position).getQuantity()));
        holder.txt_price.setText(fmt.format(price));
        holder.txt_card_name.setText(listData.get(position).getProductName());


    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
}
