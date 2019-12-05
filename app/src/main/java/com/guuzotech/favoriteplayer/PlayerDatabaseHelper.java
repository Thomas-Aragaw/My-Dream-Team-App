package com.guuzotech.favoriteplayer;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class PlayerDatabaseHelper extends SQLiteOpenHelper {

     public static final String DB_NAME = "favoriteplayer"; // the name of our database
     public static final int DB_VERSION = 1; // the version of the database
     public static final String TABLE_NAME = "USER" ;
    public static final String COL_1 = "_id";
     public static final String COL_2 ="NAME";
     public static final String COL_3 ="PASSWORD";

    public PlayerDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        updateMyDatabase(db, 0, DB_VERSION);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);


    }

    private static void insertPlayer(SQLiteDatabase db, String name,
                                     String description, int resourceId, String pos) {
        ContentValues playerValues = new ContentValues();
        playerValues.put("NAME", name);
        playerValues.put("DESCRIPTION", description);
        playerValues.put("IMAGE_RESOURCE_ID", resourceId);
        playerValues.put("POSITION", pos);
        db.insert("PLAYER", null, playerValues);
    }
     private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
         if (oldVersion < 1) {
             db.execSQL("CREATE TABLE PLAYER (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                     + "NAME TEXT, "
                     + "DESCRIPTION TEXT, "
                     + "IMAGE_RESOURCE_ID INTEGER,"
                     + "POSITION TEXT);");

             insertPlayer(db, "Andre Onana ", "Current teams AFC Ajax  & Cameroon ", R.drawable.andreonana, "Goalkeeper");
             insertPlayer(db, "David de Gea  ", "Current teams Manchester Unite Hotspur   Spain ", R.drawable.david2, "Goalkeeper");
             insertPlayer(db, "Hugo Lloris ", "Current teams Tottenham Hotspur   France ", R.drawable.hugo, "Goalkeeper");
             insertPlayer(db, "Kepa Arrizabalaga", "Current teams Chelsea  & Spain", R.drawable.kepaarrizabalaga, "Goalkeeper");
             insertPlayer(db, "Wojciech Szczesny", "Current teams Juventus  & Poland", R.drawable.wojecechszczency, "Goalkeeper");
             insertPlayer(db, "Manuel Neuer", "Current teams Bayern Munich  & Germany", R.drawable.manuelneuer, "Goalkeeper");
             insertPlayer(db, "Ederson", "Current teams Manchester City  & Brazil", R.drawable.ederson, "Goalkeeper");
             insertPlayer(db, "Marc-Andre ter Stegen", "Current teams Barcelona  & Germany", R.drawable.marcandreterstegen, "Goalkeeper");
             insertPlayer(db, "Jan Oblak", "Current teams Atletico Madrid  & Slovenia", R.drawable.janoblak, "Goalkeeper");
             insertPlayer(db, "Alisson Becker ", "Current teams Liverpool  & Brazil", R.drawable.alissonbecker, "Goalkeeper");
             insertPlayer(db, "Trent Alexander-Arnold", "Current teams Liverpool  & England", R.drawable.trentalexander, "RightBacks");
             insertPlayer(db, "Joshua Kimmich", "Current teams Bayern Munich  & Germany", R.drawable.joshuakimmich, "RightBacks");
             insertPlayer(db, "Ricardo Pereira", "Current teams Leicester City  & Portugal", R.drawable.ricardopereira, "RightBacks");
             insertPlayer(db, "Dani Carvajal", "Current teams Real Madrid  & Spain", R.drawable.danicarvajal, "RightBacks");
             insertPlayer(db, "Kyle Walker", "Current teams Manchester City  & England", R.drawable.kylewalker, "RightBacks");
             insertPlayer(db, "Dani Alves", "Current teams Sao Paulo  & Brazil", R.drawable.danialves, "RightBacks");
             insertPlayer(db, "Joao Cancelo", "Current teams Atletico Madrid  & Portugal", R.drawable.joaocancelo, "RightBacks");
             insertPlayer(db, "Kieran Trippier", "Current teams Liverpool  & England", R.drawable.kierantrippier2, "RightBacks");
             insertPlayer(db, "Cesar Azpilicueta", "Current teams Chelsea  & Spain", R.drawable.cesarazpilicueta, "RightBacks");
             insertPlayer(db, "Aaron Wan-Bissaka ", "Current teams Manchester United  & England", R.drawable.aaronwanbissaka, "RightBacks");
             insertPlayer(db, "Virgil van Dijk  ", "Current teams Liverpool  & Netherlands", R.drawable.virgilvandijk, "CentreBacks");
             insertPlayer(db, "Kalidou Koulibaly ", "Current teams Napoli  & Senegal", R.drawable.kalidoukoulibaly2, "CentreBacks");
             insertPlayer(db, "Matthijs de Ligt ", "Current teams Juventus  & Netherlands", R.drawable.matthijsdeligt2, "CentreBacks");
             insertPlayer(db, "Aymeric Laporte", "Current teams Manchester City  & France", R.drawable.aymericlaporte, "CentreBacks");
             insertPlayer(db, "Sergio Ramos ", "Current teams Real Madrid  & Spain", R.drawable.sergioramos2, "CentreBacks");
             insertPlayer(db, "Giorgio Chiellini ", "Current teams Juventus  & Italy", R.drawable.giorgiochiellini, "CentreBacks");
             insertPlayer(db, "Leonardo Bonucci ", "Current teams Juventus  & Italy", R.drawable.leonardobonucci, "CentreBacks");
             insertPlayer(db, "Marquinhos  ", "Current teams Paris Saint-Germain  & Brazil", R.drawable.marquinhos, "CentreBacks");
             insertPlayer(db, "Jose Maria Gimenez  ", "Current teams Atletico Madrid  & Uruguay", R.drawable.josemariagimenez, "CentreBacks");
             insertPlayer(db, "Milan Skriniar  ", "Current teams Inter Milan  & Slovakia", R.drawable.milanskriniar, "CentreBacks");
             insertPlayer(db, "Andrew Robertson", "Current teams Juventus  & Italy", R.drawable.leonardobonucci, "LeftBacks");
             insertPlayer(db, "David Alaba ", "Current teams Bayern Munich  & Austria", R.drawable.davidalaba, "LeftBacks");
             insertPlayer(db, "Jordi Alba ", "Current teams Barcelona  & Spain", R.drawable.jordialba, "LeftBacks");
             insertPlayer(db, "Alex Sandro ", "Current teams Juventus  & Brazil", R.drawable.alexsandro, "LeftBacks");
             insertPlayer(db, "Lucas Hernandez ", "Current teams Bayern Munich  & France", R.drawable.lucashernandez, "LeftBacks");
             insertPlayer(db, "Lucas Digne ", "Current teams Juventus  & France", R.drawable.lucasdigne, "LeftBacks");
             insertPlayer(db, "Ferland Mendy", "Current teams Real Madrid  & France", R.drawable.ferlandmendy, "LeftBacks");
             insertPlayer(db, "Alex Grimaldo ", "Current teams Benfica  & Portugal", R.drawable.alexgrimaldo, "LeftBacks");
             insertPlayer(db, "Aleksandar Kolarov", "Current teams AS Roma  & Serbia", R.drawable.aleksandarkolarov, "LeftBacks");
             insertPlayer(db, "Nicolas Tagliafico", "Current teams Ajax  & Argentina", R.drawable.nicolastagliafico, "LeftBacks");
             insertPlayer(db, "N’Golo Kante ", "Current teams Chelsea  & France", R.drawable.ngolokante, "CentralMidfielders");
             insertPlayer(db, "Frenkie de Jong ", "Current teams Barcelona  & Netherlands", R.drawable.frenkiedejong, "CentralMidfielders");
             insertPlayer(db, "Sergio Busquets", "Current teams Barcelona  & Spain", R.drawable.sergiobusquets, "CentralMidfielders");
             insertPlayer(db, "Fernandinho ", "Current teams Manchester City  & Brazil", R.drawable.fernandinho, "CentralMidfielders");
             insertPlayer(db, "Casemiro ", "Current teams Real Madrid  & Brazil", R.drawable.casemiro, "CentralMidfielders");
             insertPlayer(db, "Fabinho ", "Current teams Liverpool  & Brazil", R.drawable.fabinho, "CentralMidfielders");
             insertPlayer(db, "Miralem Pjanic ", "Current teams Juventus  & Bosnia & Herzegovina", R.drawable.miralempjanic, "CentralMidfielders");
             insertPlayer(db, "Rodrigo Hernández", "Current teams Manchester City  & Spain", R.drawable.rodri, "CentralMidfielders");
             insertPlayer(db, "Marco Verratti ", "Current teams PSG  & Italy", R.drawable.marcoverratti, "CentralMidfielders");
             insertPlayer(db, "Saúl Ñíguez ", "Current teams Atletico Madrid  & Spain", R.drawable.saul, "CentralMidfielders");
             insertPlayer(db, "Bernardo Silva", "Current teams Man City  & Portugal", R.drawable.bernardosilva, "AttackingMidfielders");
             insertPlayer(db, "Kevin De Bruyne ", "Current teams Man City  & Belgium", R.drawable.kevindebruyne, "AttackingMidfielders");
             insertPlayer(db, "Donny van de Beek ", "Current teams Ajax  & Netherlands", R.drawable.donnyvandebeek, "AttackingMidfielders");
             insertPlayer(db, "David Silva", "Current teams Man City & Spain", R.drawable.davidsilva, "AttackingMidfielders");
             insertPlayer(db, "Christian Eriksen ", "Current teams Tottenham  & Denmark", R.drawable.christianeriksen, "AttackingMidfielders");
             insertPlayer(db, "Paul Pogba ", "Current teams Man United  & France", R.drawable.paulpogba, "AttackingMidfielders");
             insertPlayer(db, "Koke ", "Current teams Atletico Madrid  & Spain", R.drawable.bustoskoke, "AttackingMidfielders");
             insertPlayer(db, "Kai Havertz ", "Current teams Bayer Leverkusen  & Germany", R.drawable.kaihavertz, "AttackingMidfielders");
             insertPlayer(db, "Ever Banega ", "Current teams Sevilla  & Argentina", R.drawable.everbanega, "AttackingMidfielders");
             insertPlayer(db, "Bruno Fernandes ", "Current teams Juventus  National team Italy", R.drawable.brunofenandes2, "AttackingMidfielders");
             insertPlayer(db, "Raheem Sterling ", "Current teams Manchester City & England", R.drawable.raheemsterling, "Wingers");
             insertPlayer(db, "Sadio Mane", "Current teams Liverpool  & Senegal", R.drawable.sadiomane, "Wingers");
             insertPlayer(db, "Eden Hazard ", "Current teams Real Madrid  & Belgium", R.drawable.edenhazard2, "Wingers");
             insertPlayer(db, "Jadon Sancho", "Current teams Borussia Dortmund  & England", R.drawable.jadonsancho, "Wingers");
             insertPlayer(db, "Son Heung-min ", "Current teams Tottenham Dortmund  & South Korea", R.drawable.sonheungmin, "Wingers");
             insertPlayer(db, "Marco Reus ", "Current teams Borussia Dortmund  & Germany", R.drawable.marcoreus, "Wingers");
             insertPlayer(db, "Angel Di Maria", "Current teams PSG  & Argentina", R.drawable.angeldimaria, "Wingers");
             insertPlayer(db, "David Neres ", "Current teams Ajax  & Brazil", R.drawable.davidneres, "Wingers");
             insertPlayer(db, "Leroy Sane ", "Current teams Manchester City  & Germany", R.drawable.leoroysane2, "Wingers");
             insertPlayer(db, "Everton Soares ", "Current teams Gremio  & Brazil", R.drawable.everton, "Wingers");
             insertPlayer(db, "Lionel Messi ", "Current teams Barcelona  & Argentina", R.drawable.lionelmessi, "Forward");
             insertPlayer(db, "Cristiano Ronaldo ", "Current teams Juventus  & Portugal", R.drawable.cristianoronaldo, "Forward");
             insertPlayer(db, "Kylian Mbappe ", "Current teams Paris Saint-Germain  & France", R.drawable.kylianmbappe, "Forward");
             insertPlayer(db, "Mohamed Salah", "Current teams Liverpool  & Egypt", R.drawable.mohamedsalah, "Forward");
             insertPlayer(db, "Roberto Firmino", "Current teams Liverpool  & Brazil", R.drawable.robertofirmino, "Forward");
             insertPlayer(db, ". Antoine Griezmann ", "Current teams Barcelona  & France", R.drawable.antoinegriezmann, "Forward");
             insertPlayer(db, "Pierre-Emerick Aubameyang ", "Current teams Arsenal  & Gabon", R.drawable.pierreemerickaubameyang, "Forward");
             insertPlayer(db, "Neymar ", "Current teams Paris Saint-Germain  & Brazil", R.drawable.neymar, "Forward");
             insertPlayer(db, "Joao Felix ", "Current teams Atletico Madrid  & Portugal", R.drawable.joaofelix, "Forward");
             insertPlayer(db, "Dusan Tadic ", "Current teams Ajax  & Serbia", R.drawable.dusantadic, "Forward");
             insertPlayer(db, "Sergio Aguero ", "Current teams Manchester City  & Manchester City", R.drawable.sergioaguero, "Strikers");
             insertPlayer(db, "Harry Kane ", "Current teams Tottenham Hotspur  & England", R.drawable.harrkane, "Strikers");
             insertPlayer(db, "Robert Lewandowski ", "Current teams Bayern Munich  & Poland", R.drawable.robertlewandowski, "Strikers");
             insertPlayer(db, "Karim Benzema", "Current teams Real Madrid  & France", R.drawable.karimbenzema, "Strikers");
             insertPlayer(db, "Luis Suarez ", "Current teams Barcelona  & Uruguay", R.drawable.luissuarez2, "Strikers");
             insertPlayer(db, "Edinson Cavani ", "Current teams Paris Saint-Germain  & Uruguay", R.drawable.edinsoncavani, "Strikers");
             insertPlayer(db, "Duvan Zapata", "Current teams Atalanta  & Colombia", R.drawable.duvanzapata, "Strikers");
             insertPlayer(db, "Alexandre Lacazette", "Current teams Arsenal  & France", R.drawable.alexandrelacazette, "Strikers");
             insertPlayer(db, "Zlatan Ibrahimovic ", "Current teams LA Galaxy  & Sweden", R.drawable.zlatanibrahimovic, "Strikers");
             insertPlayer(db, "Fabio Quagliarella", "Current teams Sampdoria  & Italy", R.drawable.fabioquagliarella, "Strikers");












             db.execSQL("CREATE TABLE USER (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                     + "NAME TEXT, "
                     + "PASSWORD TEXT);");

             db.execSQL("CREATE TABLE SELECTION (user_id INTEGER, "
                     + "player_id INTEGER);");
         }
         if (oldVersion < 2) {
            // db.execSQL("ALTER TABLE PLAYER ADD COLUMN FAVORITE NUMERIC;");
             //db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
         }
     }
     public long  addUser (String username, String userpassword){
        SQLiteDatabase db = this.getWritableDatabase();
         ContentValues userValues = new ContentValues();
         userValues.put("NAME", username);
         userValues.put("PASSWORD", userpassword);
         long res = db.insert("USER",null,userValues);
         db.close();
         return  res;
     }

    public boolean checkUserName (String NAME){
        String [] columns ={COL_1};
        SQLiteDatabase db =getReadableDatabase();
        String selection = COL_2 +"=?";
        String[] selectionArgs = {NAME};
        Cursor cursor = db.query(TABLE_NAME, columns,selection, selectionArgs, null,null,null);
        int count =cursor.getCount();
        cursor.close();
        db.close();
        if(count> 0)
            return true;
        else return false;


    }

     public boolean checkUser (String NAME, String PASSWORD){
     String [] columns ={COL_1};
     SQLiteDatabase db =getReadableDatabase();
     String selection = COL_2 +"=?"+ " and " + COL_3 + "=?";
     String[] selectionArgs = {NAME, PASSWORD};
         Cursor cursor = db.query(TABLE_NAME, columns,selection, selectionArgs, null,null,null);
         int count =cursor.getCount();
         cursor.close();
         db.close();
         if(count> 0)
             return true;
         else return false;


     }
}
