package com.example.resto;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String MENU = "MENU";
    public static final String DISH_ID = "DISH_ID";
    public static final String DISH_NAME = "DISH_NAME";
    public static final String DISH_PRICE = "DISH_PRICE";
    public static final String ISVEG = "ISVEG";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "restaurant.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableStatement = "CREATE TABLE " + MENU + " ( " + DISH_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + DISH_NAME + " TEXT NOT NULL, " + DISH_PRICE + " INTEGER NOT NULL, " + ISVEG + " BOOL NOT NULL   )";

        sqLiteDatabase.execSQL(createTableStatement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean AddOne(MenuModel menuModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DISH_NAME, menuModel.getDishname());
        contentValues.put(DISH_PRICE, menuModel.getDishprice());
        contentValues.put(ISVEG, menuModel.isIsveg());

        long insert = db.insert(MENU, null, contentValues);
        if(insert == -1)
        {
            return false;
        }
        else
        {
            return true;
        }


    }


    public List<MenuModel> GetEveryDish(){
        List<MenuModel> returnList = new ArrayList<>();

        //get list

        String queryString = "SELECT * FROM "+ MENU;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString , null);
        if(cursor.moveToFirst()){
            do {
                int dishID = cursor.getInt(0);
                String dishName = cursor.getString(1);
                int dishPrice = cursor.getInt(2);
                boolean isVeg = cursor.getInt(3)== 1? true: false;

                MenuModel newDish = new MenuModel(dishID,dishName,dishPrice,isVeg);
                returnList.add(newDish);

            } while(cursor.moveToNext());
        }
        else{
            //empty list

        }

        cursor.close();
        db.close();



        return returnList;
    }



}
