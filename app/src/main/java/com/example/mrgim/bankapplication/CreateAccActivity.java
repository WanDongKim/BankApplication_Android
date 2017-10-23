package com.example.mrgim.bankapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEtxtId;
    private EditText mEtxtPwd;
    private EditText mEtxtConfirmPwd;
    private EditText mEtxtBalance;

    private Button mBtnReset;
    private Button mBtnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_acc);

        mEtxtId = (EditText) findViewById(R.id.etxtID);
        mEtxtPwd = (EditText) findViewById(R.id.etxtPwd);
        mEtxtConfirmPwd = (EditText) findViewById(R.id.etxtConfirmPwd);
        mEtxtBalance = (EditText) findViewById(R.id.etxtBalance);

        mBtnReset = (Button) findViewById(R.id.btnReset);
        mBtnCreate = (Button) findViewById(R.id.btnCreate);

        mBtnReset.setOnClickListener(this);
        mBtnCreate.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnReset:
                mEtxtId.setText("");
                mEtxtPwd.setText("");
                mEtxtConfirmPwd.setText("");
                mEtxtBalance.setText("");

                break;
            case R.id.btnCreate:
                String id = mEtxtId.getText().toString();
                String pwd = mEtxtPwd.getText().toString();
                String confirmPwd = mEtxtConfirmPwd.getText().toString();
                String balance = mEtxtBalance.getText().toString();

                if(TextUtils.isEmpty(id) || TextUtils.isEmpty(pwd)
                        || TextUtils.isEmpty(confirmPwd) || TextUtils.isEmpty(balance)){
                    Toast.makeText(CreateAccActivity.this, "Please type everything",Toast.LENGTH_SHORT).show();
                }
                else{
                    Account account = new Account(id,pwd,balance);
                    Intent intent = new Intent();
                    intent.putExtra("account", account);
                    setResult(RESULT_OK,intent);
                    finish();
                }

                break;
        }
    }


}
