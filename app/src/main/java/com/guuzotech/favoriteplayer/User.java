package com.guuzotech.favoriteplayer;

public class User {

    private static String uName = "";

    public String id;
    public String userName;
    public String email;
    public String password;

    public User(String id, String userName, String email, String password) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public static void setUName(String un){
        uName = un;
    }

    public static String getUName(){
        return uName;
    }

}
