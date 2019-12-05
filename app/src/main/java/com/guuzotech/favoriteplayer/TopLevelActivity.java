package com.guuzotech.favoriteplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ListView;
import android.view.View;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.SimpleCursorAdapter;
import android.widget.CursorAdapter;
import android.widget.Toast;

public class TopLevelActivity extends AppCompatActivity {
    private SQLiteDatabase db;
    private Cursor favoritesCursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);
        setupOptionsListView();
        setupFavoritesListView();
    }
    private void setupOptionsListView() {
//Create an OnItemClickListener
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> listView,
                                    View itemView,
                                    int position,
                                    long id) {
                if (position == 0) {
                    Intent intent = new Intent(TopLevelActivity.this,
                            GoalkepperCatagory.class);
                    startActivity(intent);
                }
                else if(position == 1){
                    Intent intent = new Intent(TopLevelActivity.this,
                            RightBacksCatagory.class);
                    startActivity(intent);
                }
                else if(position == 2){
                    Intent intent = new Intent(TopLevelActivity.this,
                            CentreBacksCatagory.class);
                    startActivity(intent);
                }
                else if(position == 3){
                    Intent intent = new Intent(TopLevelActivity.this,
                            LeftBacksCatagory.class);
                    startActivity(intent);
                }
                else if(position == 4){
                    Intent intent = new Intent(TopLevelActivity.this,
                            CentralMidfieldersCatagory.class);
                    startActivity(intent);
                }
                else if(position == 5){
                    Intent intent = new Intent(TopLevelActivity.this,
                            AttackingMidfieldersCatagory.class);
                    startActivity(intent);
                }
                else if(position == 6){
                    Intent intent = new Intent(TopLevelActivity.this,
                            WingersCatagory.class);
                    startActivity(intent);
                }
                else if(position == 7){
                    Intent intent = new Intent(TopLevelActivity.this,
                            ForwardCatagory.class);
                    startActivity(intent);
                }
                else if(position == 8){
                    Intent intent = new Intent(TopLevelActivity.this,
                            StrikersCatagory.class);
                    startActivity(intent);
                }
            }
        };
//Add the listener to the list view
        ListView listView = (ListView) findViewById(R.id.list_options);
        listView.setOnItemClickListener(itemClickListener);
    }

    private void setupFavoritesListView() {
//Populate the list_favorites ListView from a cursor
        ListView listFavorites = (ListView) findViewById(R.id.list_favorites);
        try{
            PlayerDatabaseHelper PlayerDatabaseHelper = new PlayerDatabaseHelper(this);
            db = PlayerDatabaseHelper.getReadableDatabase();

            favoritesCursor = db.rawQuery("WITH sel_Players(P_id) As (Select player_id FROM SELECTION, USER WHERE NAME = ? AND _id = user_id) SELECT _id, NAME FROM PLAYER, sel_Players WHERE P_id = _id", new String[] {User.getUName()});

            CursorAdapter favoriteAdapter =
                    new SimpleCursorAdapter(TopLevelActivity.this,
                            android.R.layout.simple_list_item_1,
                            favoritesCursor,
                            new String[]{"NAME"},
                            new int[]{android.R.id.text1}, 0);
            listFavorites.setAdapter(favoriteAdapter);
            db.close();
        } catch(SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }

        listFavorites.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View v, int position, long id) {
                Intent intent = new Intent(TopLevelActivity.this, forward.class);
                intent.putExtra(forward.EXTRA_PLAYERID, (int)id);
                startActivity(intent);
            }
        });
    }

    public void onRestart() {
        super.onRestart();
        setupFavoritesListView();
        setupOptionsListView();

    }
    //Close the cursor and database in the onDestroy() method
    @Override
    public void onDestroy(){
        super.onDestroy();
        favoritesCursor.close();
        db.close();
    }
}
