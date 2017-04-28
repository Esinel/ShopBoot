package com.example.stefanos.shopboot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.stefanos.shopboot.activity.ShoppingListActivity;
import com.example.stefanos.shopboot.adapter.ShoppingListsAdapter;
import com.example.stefanos.shopboot.model.Article;
import com.example.stefanos.shopboot.model.ShoppingList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static List<ShoppingList> shoppingList;

    private ShoppingListsAdapter shoppingListsAdapter;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.addNewShoppingListBtn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // 3 dots - settings
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            ShoppingList editedList = (ShoppingList) data.getSerializableExtra("editedShoppingList");
            updateChanges(editedList);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }




    private void updateChanges(ShoppingList shoppingList){
        for (ShoppingList s : this.shoppingList){
            if(s.getId() == shoppingList.getId()){
                s = shoppingList;
            }
        }
        shoppingListsAdapter.notifyDataSetChanged();
    }

    private void init() {
        // get listView's reference
        listView = (ListView) findViewById(R.id.shoppingLists);

        // initialize items
        shoppingList = new ArrayList<>();


        ShoppingList shoppingListItem = new ShoppingList();
        List<Article> articles = new ArrayList<>();
        articles.add(new Article("Mleko", false));
        articles.add(new Article("Hleb", true));
        shoppingListItem.setArticles(articles);
        shoppingListItem.setName("Nabavka za goste");
        shoppingList.add(shoppingListItem);

        shoppingListItem = new ShoppingList();
        articles = new ArrayList<>();
        articles.add(new Article("Kinder jaja", false));
        articles.add(new Article("Plazma", true));
        articles.add(new Article("Milka cokolade", false));
        shoppingListItem.setArticles(articles);
        shoppingListItem.setName("Slatkisi za decu");
        shoppingList.add(shoppingListItem);

        shoppingListItem = new ShoppingList();
        articles = new ArrayList<>();
        articles.add(new Article("Cekic", false));
        articles.add(new Article("Magicni stapic", true));
        articles.add(new Article("Limene palete", true));
        shoppingListItem.setArticles(articles);
        shoppingListItem.setName("Alat za konstrukciju helikoptera na pedale");
        shoppingList.add(shoppingListItem);



        // initialize adapter
        shoppingListsAdapter = new ShoppingListsAdapter(shoppingList, this);

        // set adapter to list
        listView.setAdapter(shoppingListsAdapter);
    }

    public void callMe(ShoppingList shoppingList){

        Intent intent = new Intent(this, ShoppingListActivity.class);
        //clicked shoppingList
        intent.putExtra("shoppingList", shoppingList);
        startActivityForResult(intent, this.RESULT_OK);
    }

}
