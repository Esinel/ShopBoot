package com.example.stefanos.shopboot.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.stefanos.shopboot.R;
import com.example.stefanos.shopboot.activity.ShoppingListActivity;
import com.example.stefanos.shopboot.model.Article;
import com.example.stefanos.shopboot.model.ShoppingList;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stefanos on 4/27/2017.
 */

public class ArticlesAdapter extends BaseAdapter {

    private ShoppingList shoppingList;

    private final LayoutInflater layoutInflater;

    private final Context context;


    public ArticlesAdapter(ShoppingList shoppingList, Context context) {
        this.shoppingList = shoppingList;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return shoppingList.getArticles().size();
    }

    @Override
    public Object getItem(int position) {
        return shoppingList.getArticles().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder;

        //inflate view
        view = layoutInflater.inflate(R.layout.articles_item, viewGroup, false);

        //initialize viewHolder
        viewHolder = new ViewHolder();
        viewHolder.articleDone = (CheckBox) view.findViewById(R.id.articleDone);
        viewHolder.articleName = (TextView) view.findViewById(R.id.articleName);


        view.setTag(viewHolder);


        //get item and populate view with it's data
        final Article article = (Article) getItem(position);

        viewHolder.articleName.setText(article.getName());
        if(article.isDone()){
            viewHolder.articleDone.setChecked(true);
        }


        viewHolder.articleDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                article.setDone(viewHolder.articleDone.isChecked());
                shoppingList.getArticles().set(position, article);
            }
        });



        return view;


    }






    private class ViewHolder {

        private CheckBox articleDone;

        private TextView articleName;
    }

    public ShoppingList getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
    }
}
