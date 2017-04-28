package com.example.stefanos.shopboot.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ListView;

import com.example.stefanos.shopboot.R;
import com.example.stefanos.shopboot.adapter.ArticlesAdapter;
import com.example.stefanos.shopboot.adapter.ShoppingListsAdapter;
import com.example.stefanos.shopboot.model.ShoppingList;

import java.util.ArrayList;
import java.util.List;

import static com.example.stefanos.shopboot.R.id.shoppingList;

public class ShoppingListActivity extends AppCompatActivity {

    private ArticlesAdapter articlesAdapter;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);


        ShoppingList shoppingList = (ShoppingList) getIntent().getExtras().getSerializable("shoppingList");

        articlesAdapter = new ArticlesAdapter(shoppingList, this);
        listView = (ListView) findViewById(R.id.shoppingList);
        listView.setAdapter(articlesAdapter);
    }

    @Override
    protected void onResume(){
        super.onResume();
    }



    @Override
    public void onBackPressed()
    {
        ShoppingList shoppingList = articlesAdapter.getShoppingList();
        Intent returnIntent = new Intent();
        returnIntent.putExtra("editedShoppingList",shoppingList);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
        super.onBackPressed();
    }

}
