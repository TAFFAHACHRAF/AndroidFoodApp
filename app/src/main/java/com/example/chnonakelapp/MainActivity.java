package com.example.chnonakelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.ListView;

import com.example.chnonakelapp.adapters.FoodAdapter;
import com.example.chnonakelapp.models.FoodItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            ListView shopListView = findViewById(R.id.shop_list_view);
            shopListView.setAdapter(new FoodAdapter(this, getFoodsFromAssets()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public List<FoodItem> getFoodsFromAssets() throws IOException, JSONException {
        AssetManager assetManager = getAssets();
        InputStream inputStream = assetManager.open("Foods.json");

        // Read the JSON data from the file
        int size = inputStream.available();
        byte[] buffer = new byte[size];
        inputStream.read(buffer);
        inputStream.close();

        // Convert the data to a JSON string
        String json = new String(buffer, "UTF-8");

        // Parse the JSON string to a JSON array
        JSONArray jsonArray = new JSONArray(json);

        LinkedList<FoodItem> foodItems=new LinkedList<>();

        // Loop through the array and show each food name
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String name = jsonObject.getString("name");
            String price = jsonObject.getString("price");
            String imageName = jsonObject.getString("imageName");
            foodItems.add(new FoodItem(name,Double.parseDouble(price),imageName));
        }

        return foodItems;
    }
}