package com.guuzotech.favoriteplayer;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CentreBacks extends AppCompatActivity {
    public static final String EXTRA_PLAYERID = "playerId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centrebacks);

        int playerId = (Integer) getIntent().getExtras().get(EXTRA_PLAYERID);

        SQLiteOpenHelper PlayerDatabaseHelper = new PlayerDatabaseHelper(this);
        try {
            SQLiteDatabase db = PlayerDatabaseHelper.getReadableDatabase();
           Cursor cursor = db.query("PLAYER",
                    new String[]{"NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID"},
                    "_id = ?",
                    new String[]{Integer.toString(playerId)},
                    null, null, null);



            if (cursor.moveToFirst()) {
//Get the player details from the cursor
                String nameText = cursor.getString(0);
                String descriptionText = cursor.getString(1);
                int photoId = cursor.getInt(2);

                cursor.close();

                cursor = db.rawQuery("WITH user_t(u_id) AS (Select _id From USER Where NAME = ?) Select user_id, player_id FROM SELECTION, user_t Where u_id = user_id And player_id = ?", new String[] {User.getUName(), Integer.toString(playerId)});

                boolean isFavorite = (cursor.moveToFirst());
               // boolean isFavorite = (cursor.getInt(3) == 1);



//Populate the player name
                TextView name = (TextView) findViewById(R.id.name);
                name.setText(nameText);
                TextView description = (TextView) findViewById(R.id.description);
                description.setText(descriptionText);
                ImageView photo = (ImageView) findViewById(R.id.photo);
                photo.setImageResource(photoId);
                photo.setContentDescription(nameText);
                CheckBox favorite = (CheckBox)findViewById(R.id.favorite);
                favorite.setChecked(isFavorite);
            }
            cursor.close();
            db.close();
        }
        catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable",
                                                               Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    //Update the database when the checkbox is clicked
    public void onFavoriteClicked(View view){

        int playerId = (Integer) getIntent().getExtras().get(EXTRA_PLAYERID);
        int uID = 0;
//Get the value of the checkbox
        CheckBox favorite = (CheckBox) findViewById(R.id.favorite);
        ContentValues values = new ContentValues();
        Cursor c = null;


        //playerValues.put("FAVORITE", favorite.isChecked());

//Get a reference to the database and update the FAVORITE column
        SQLiteOpenHelper PlayerDatabaseHelper = new PlayerDatabaseHelper(this);
        try {
            SQLiteDatabase db = PlayerDatabaseHelper.getWritableDatabase();

            if(favorite.isChecked()) {
                c = db.query("USER", new String[]{"_id"}, "NAME = ?", new String[]{User.getUName()}, null, null, null);
                c.moveToNext();

                uID = c.getInt(0);

                values.put("user_id", uID);
                values.put("player_id", playerId);

                c.close();

                c = db.rawQuery("SELECT Count(*) FROM SELECTION WHERE user_id = ?", new String[] {Integer.toString(uID)});
                c.moveToFirst();

                if(c.getInt(0) >= 12){
                    Toast toast = Toast.makeText(this, "Your team is already full.", Toast.LENGTH_SHORT);
                    toast.show();

                    favorite.setChecked(false);
                }else {
                    db.insert("SELECTION",
                            null,
                            values);
                    db.close();
                }

            }else{
                c = db.query("USER", new String[]{"_id"}, "NAME = ?", new String[]{User.getUName()}, null, null, null);
                c.moveToNext();

                uID = c.getInt(0);

                db.delete("SELECTION",
                        "player_id = ? AND user_id = ?", new String[] {Integer.toString(playerId), Integer.toString(uID)});
                db.close();
            }
        }
        catch(SQLiteException e) {

            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }


}