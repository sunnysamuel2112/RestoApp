package com.example.resto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityAdmin extends AppCompatActivity {

    TextView dishName,dishPrice;
    Switch isVeg;
    Button buttonAdd;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);

        //references
        dishName = findViewById(R.id.editTextDishName);
        dishPrice = findViewById(R.id.editTextDishPrice);
        isVeg = findViewById(R.id.switchIsVeg);
        buttonAdd = findViewById(R.id.buttonAddDish);
        toolbar=findViewById(R.id.myToolBar);
        setSupportActionBar(toolbar);

        //onclick listeners

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MenuModel menuModel = new MenuModel(-1,dishName.getText().toString(), Integer.parseInt(dishPrice.getText().toString()), isVeg.isChecked());

                Toast.makeText(MainActivityAdmin.this, menuModel.toString(), Toast.LENGTH_SHORT).show();

            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbarmenu,menu);
        return true;
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.id_logOut:
                Intent intent = new Intent(this,MainActivity2.class);
                startActivity(intent);

            default:
                break;
        }
        return super.onContextItemSelected(item);
    }
}