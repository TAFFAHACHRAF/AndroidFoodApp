package com.example.chnonakelapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chnonakelapp.R;
import com.example.chnonakelapp.models.FoodItem;

import java.util.List;

public class FoodAdapter extends BaseAdapter {
    private Context context;
    private List<FoodItem> highTecItemList;
    private LayoutInflater inflater;


    public FoodAdapter(Context context, List<FoodItem> highTecItemList) {
        this.context = context;
        this.highTecItemList = highTecItemList;
        this.inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return highTecItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return highTecItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.adapter_item, null);


        FoodItem currentItem = (FoodItem) getItem(i);
        String itemName = currentItem.getName();
        Double itemPrice = currentItem.getPrice();
        String itemImageName = currentItem.getImageName();

        ImageView itemIconView=view.findViewById(R.id.item_icon);
        int resId = context.getResources().getIdentifier(itemImageName,"drawable",context.getOpPackageName());
        itemIconView.setImageResource(resId);

        TextView itemNameView = view.findViewById(R.id.item_name);
        itemNameView.setText(itemName);

        TextView itemPriceView = view.findViewById(R.id.item_price);
        itemPriceView.setText(itemPrice+"$");

        return view;
    }
}