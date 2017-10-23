package com.example.mrgim.bankapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCreateAcc = (Button) findViewById(R.id.btnCreateAccount);
        Button btnSearchAcc = (Button) findViewById(R.id.btnSearchAccount);
        Button btnAdmin = (Button) findViewById(R.id.btnAdminMode);
        Button btnExit = (Button) findViewById(R.id.btnExit);

        btnCreateAcc.setOnClickListener(this);
        btnSearchAcc.setOnClickListener(this);
        btnAdmin.setOnClickListener(this);
        btnExit.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCreateAccount:
                Intent intent = new Intent(this, CreateAccActivity.class);
                startActivity(intent);
                break;
            case R.id.btnSearchAccount:
                break;
            case R.id.btnAdminMode:
                break;
            case R.id.btnExit:
                break;
        }
    }
}
