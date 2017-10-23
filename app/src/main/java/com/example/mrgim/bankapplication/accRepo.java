package com.example.mrgim.bankapplication;

import java.util.HashMap;

/**
 * Created by mrgim on 2017-10-23.
 */

public class accRepo {

    private accRepo instance = null;
    private HashMap<String, Account> mMap;

    public accRepo getInstance(){
        if(instance == null){
            instance = new accRepo();
        }
        return instance;
    }

    private accRepo(){

    }
}
