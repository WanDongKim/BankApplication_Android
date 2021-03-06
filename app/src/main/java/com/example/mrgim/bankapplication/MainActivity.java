package com.example.mrgim.bankapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private accRepo mAccRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCreateAcc = (Button) findViewById(R.id.btnCreateAccount);
        Button btnSearchAcc = (Button) findViewById(R.id.btnSearchAccount);
        Button btnAdmin = (Button) findViewById(R.id.btnAdminMode);
        Button btnExit = (Button) findViewById(R.id.btnExit);

        mAccRepo = accRepo.getInstance();

        btnCreateAcc.setOnClickListener(this);
        btnSearchAcc.setOnClickListener(this);
        btnAdmin.setOnClickListener(this);
        btnExit.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCreateAccount:
                Intent createAccIntent = new Intent(this, CreateAccActivity.class);
                startActivityForResult(createAccIntent, 1000);
                break;
            case R.id.btnSearchAccount:
                Intent searchAccIntent = new Intent(this, SearchAccountActivity.class);
                searchAccIntent.putExtra("data",mAccRepo.getmAccountMap());
                startActivity(searchAccIntent);
                break;
            case R.id.btnAdminMode:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Admin mode");
                final View dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_admin, null, false);
                builder.setView(dialogView);
                builder.setPositiveButton("Log-in", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String id = ((EditText) dialogView.findViewById(R.id.etxtID)).getText().toString();
                        String pwd = ((EditText) dialogView.findViewById(R.id.etxtPwd)).getText().toString();

                        if("admin".equals(id) && "admin".equals(pwd)){
                            // TODO: 2017-10-23  move to admin
                            Intent adminIntent = new Intent(MainActivity.this,AdminActivity.class);
                           adminIntent.putExtra("data",mAccRepo.getmAccountMap());
                            startActivity(adminIntent);
                        }else{
                            Toast.makeText(MainActivity.this,"Please type admin account. Incorrect value",Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                builder.setNegativeButton("Close",null);
                builder.show();
                break;
            case R.id.btnExit:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1000) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    Account account = (Account) data.getSerializableExtra("account");
                    mAccRepo.getmAccountMap().put(account.getId(), account);
                    Toast.makeText(MainActivity.this, "Created account",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
