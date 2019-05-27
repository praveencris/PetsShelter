package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.provider.BaseColumns._ID;
import static com.example.android.pets.data.PetsContract.PetsEntry.COLUMN_PET_BREED;
import static com.example.android.pets.data.PetsContract.PetsEntry.COLUMN_PET_GENDER;
import static com.example.android.pets.data.PetsContract.PetsEntry.COLUMN_PET_NAME;
import static com.example.android.pets.data.PetsContract.PetsEntry.COLUMN_PET_WEIGHT;
import static com.example.android.pets.data.PetsContract.PetsEntry.TABLE_NAME;

public class PetsOpenHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "pets.db";
    private static final int DATABASE_VERSION = 1;
    private static final String LOG_TAG = PetsOpenHelper.class.getSimpleName();

    public PetsOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String CREATE_PETS_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + "(" +
                        _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        COLUMN_PET_NAME + " TEXT NOT NULL," +
                        COLUMN_PET_BREED + " TEXT," +
                        COLUMN_PET_GENDER + " INTEGER NOT NULL," +
                        COLUMN_PET_WEIGHT + " INTEGER NOT NULL DEFAULT 0);";
        Log.d(LOG_TAG,CREATE_PETS_ENTRIES);
        db.execSQL(CREATE_PETS_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        final String DELETE_PETS_ENTRIES = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(DELETE_PETS_ENTRIES);
        onCreate(db);
    }
}
