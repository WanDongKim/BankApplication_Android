package com.example.mrgim.bankapplication;

/**
 * Created by mrgim on 2017-10-23.
 */

public class accRepo {

    private accRepo instance = null;

    public accRepo getInstance(){
        if(instance == null){
            instance = new accRepo();
        }
        return instance;
    }

    private accRepo(){

    }
}
