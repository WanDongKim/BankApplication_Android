package com.example.mrgim.bankapplication;

import java.util.HashMap;

/**
 * Created by mrgim on 2017-10-23.
 */

public  class accRepo {

    private static accRepo instance = null;
    private HashMap<String, Account> mAccountMap;

    public static accRepo getInstance(){
        if(instance == null){
            instance = new accRepo();
        }
        return instance;
    }

    public HashMap<String, Account> getmAccountMap() {
        return mAccountMap;
    }

    private accRepo(){
            mAccountMap = new HashMap<>();

    }
}
