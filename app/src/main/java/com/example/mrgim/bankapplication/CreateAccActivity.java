package com.example.mrgim.bankapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                break;
        }
    }
}
