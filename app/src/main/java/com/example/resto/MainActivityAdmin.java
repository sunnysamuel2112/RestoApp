package com.example.resto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityAdmin extends AppCompatActivity {

    TextView dishName,dishPrice;
    Switch isVeg;
    Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);

        //references
        dishName = findViewById(R.id.editTextDishName);
        dishPrice = findViewById(R.id.editTextDishPrice);
        isVeg = findViewById(R.id.switchIsVeg);
        buttonAdd = findViewById(R.id.buttonAddDish);

        //onclick listeners

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MenuModel menuModel = new MenuModel(-1,dishName.getText().toString(), Integer.parseInt(dishPrice.getText().toString()), isVeg.isChecked());

                Toast.makeText(MainActivityAdmin.this, menuModel.toString(), Toast.LENGTH_SHORT).show();

            }
        });



    }
}