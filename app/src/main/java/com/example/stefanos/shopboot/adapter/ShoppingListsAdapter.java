package com.example.stefanos.shopboot.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.stefanos.shopboot.MainActivity;
import com.example.stefanos.shopboot.R;
import com.example.stefanos.shopboot.activity.AuthenticationActivity;
import com.example.stefanos.shopboot.activity.ShoppingListActivity;
import com.example.stefanos.shopboot.model.ShoppingList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stefanos on 4/26/2017.
 */

public class ShoppingListsAdapter extends BaseAdapter {

    private List<ShoppingList> shoppingLists = new ArrayList<>();

    private final LayoutInflater layoutInflater;

    private final Context context;




    public ShoppingListsAdapter(List<ShoppingList> shoppingLists, Context context) {
        this.shoppingLists = shoppingLists;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return shoppingLists.size();
    }

    @Override
    public Object getItem(int position) {
        return shoppingLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        final ViewHolder viewHolder;

        //inflate view
        view = layoutInflater.inflate(R.layout.shopping_lists_item, viewGroup, false);

        //initialize viewHolder
        viewHolder = new ViewHolder();
        viewHolder.listName = (TextView) view.findViewById(R.id.listName);
        viewHolder.listLockedIndicator = (ImageView) view.findViewById(R.id.listLocked);


        view.setTag(viewHolder);


        //get item and populate view with it's data
        final ShoppingList shoppingList = (ShoppingList) getItem(position);

        viewHolder.listName.setText(shoppingList.getName());
        if(shoppingList.isLocked()){
            viewHolder.listLockedIndicator.setVisibility(View.VISIBLE);
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if shopping list is locked

                if (shoppingList.isLocked()){
                    Intent intent = new Intent(context, AuthenticationActivity.class);
                    intent.putExtra("password", shoppingList.getPassword());
                    ((Activity) context).startActivityForResult(intent, Activity.RESULT_OK);
                }else{
                    /*Intent intent = new Intent(context, ShoppingListActivity.class);
                    //clicked shoppingList
                    intent.putExtra("shoppingList", shoppingList);
                    ((Activity) context).startActivityForResult(intent, Activity.RESULT_OK);*/

                    ((MainActivity)context).callMe(shoppingList);


                }



            }
        });

        return view;
    }


    private class ViewHolder {

        private TextView listName;

        private ImageView listLockedIndicator;
    }

    public List<ShoppingList> getShoppingLists() {
        return shoppingLists;
    }

    public void setShoppingLists(List<ShoppingList> shoppingLists) {
        this.shoppingLists = shoppingLists;
    }
}
