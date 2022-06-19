package com.example.resto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivityAdmin extends AppCompatActivity {

    TextView dishName,dishPrice;
    Switch isVeg;
    Button buttonAdd, buttonShowAll;
    ListView listViewDishes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);

        //references
        dishName = findViewById(R.id.editTextDishName);
        dishPrice = findViewById(R.id.editTextDishPrice);
        isVeg = findViewById(R.id.switchIsVeg);
        buttonAdd = findViewById(R.id.buttonAddDish);
        buttonShowAll = findViewById(R.id.buttonShowAll);
        listViewDishes = findViewById(R.id.ListViewDishes);


        //onclick listeners

        buttonShowAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivityAdmin.this);
                List<MenuModel> everyDish = dataBaseHelper.GetEveryDish();

                ArrayAdapter menuArrayAdapter = new ArrayAdapter<MenuModel>(MainActivityAdmin.this, android.R.layout.simple_list_item_1, everyDish);
                listViewDishes.setAdapter(menuArrayAdapter);

                //Toast.makeText(MainActivityAdmin.this, everyDish.toString(), Toast.LENGTH_SHORT).show();


            }
        });


        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MenuModel menuModel;

                try{
                    menuModel = new MenuModel(-1,dishName.getText().toString(), Integer.parseInt(dishPrice.getText().toString()), isVeg.isChecked());
                    Toast.makeText(MainActivityAdmin.this, menuModel.toString(), Toast.LENGTH_SHORT).show();
                    dishName.setText("");
                    dishPrice.setText("");
                }
                catch (Exception e){
                    Toast.makeText(MainActivityAdmin.this, "Error Adding Dish", Toast.LENGTH_SHORT).show();
                    menuModel = new MenuModel(-1,"error",0,false);
                }

                DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivityAdmin.this);
                boolean success = dataBaseHelper.AddOne(menuModel);
                Toast.makeText(MainActivityAdmin.this, "Success"+success, Toast.LENGTH_SHORT).show();


            }
        });



    }
}