package com.example.resto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    Button buttonLogout, buttonMenu;
    ListView listViewDishes;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        buttonLogout = findViewById(R.id.buttonLogout);


        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });

        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity2.this);
                List<MenuModel> everyDish = dataBaseHelper.GetEveryDish();

                ArrayAdapter menuArrayAdapter = new ArrayAdapter<MenuModel>(MainActivity2.this, android.R.layout.simple_list_item_1, everyDish);
                listViewDishes.setAdapter(menuArrayAdapter);

                //Toast.makeText(MainActivityAdmin.this, everyDish.toString(), Toast.LENGTH_SHORT).show();


            }
        });



    }


}