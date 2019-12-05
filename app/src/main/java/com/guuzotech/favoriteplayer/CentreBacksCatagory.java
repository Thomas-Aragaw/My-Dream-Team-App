package com.guuzotech.favoriteplayer;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CentreBacksCatagory extends AppCompatActivity {

    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centrebacks_catagory);

        ListView listPlayers = (ListView) findViewById(R.id.list_players);
        PlayerDatabaseHelper playerDatabaseHelper = new PlayerDatabaseHelper(this);
        try {
            db = playerDatabaseHelper.getReadableDatabase();
            cursor = db.query("PLAYER",
                    new String[]{"_id", "NAME"},
                    "POSITION = ?", new String[] {"CentreBacks"}, null, null, null);
            SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_1,
                    cursor,
                    new String[]{"NAME"},
                    new int[]{android.R.id.text1},
                    0);
            listPlayers.setAdapter(listAdapter);
            db.close();
        } catch(SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
//Create a listener to listen for clicks in the list view
        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener(){
                    public void onItemClick(AdapterView<?> listPlayers,
                                            View itemView,
                                            int position,
                                            long id) {
//Pass the drink the user clicks on to DrinkActivity

                        Intent intent = new Intent(CentreBacksCatagory.this, forward.class);
                        intent.putExtra(forward.EXTRA_PLAYERID, (int) id);
                        startActivity(intent);
                    }
                };
//Assign the listener to the list view
        listPlayers.setOnItemClickListener(itemClickListener);
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        //cursor.close();
       // db.close();
    }
}
