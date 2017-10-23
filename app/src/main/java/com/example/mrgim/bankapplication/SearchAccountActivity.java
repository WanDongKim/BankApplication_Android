package com.example.mrgim.bankapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class SearchAccountActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mtxtID;
    private EditText mtxtPwd;
    private Button mbtnLogin;
    private Button mbtnClose;
    private TextView mtxtResult;

    private HashMap<String, Account> mAccountHashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_account);

        mtxtID = (EditText) findViewById(R.id.etxtID);
        mtxtPwd = (EditText) findViewById(R.id.etxtPwd);
        mbtnLogin = (Button) findViewById(R.id.btnLogin);
        mbtnClose = (Button) findViewById(R.id.btnClose);

        mtxtResult = (TextView) findViewById(R.id.txtResult);

        mbtnLogin.setOnClickListener(this);
        mbtnClose.setOnClickListener(this);

        Intent intent = getIntent();
        if(intent != null){
           mAccountHashMap = (HashMap<String, Account>)intent.getSerializableExtra("data");
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:
                String id = mtxtID.getText().toString();
                String pwd = mtxtPwd.getText().toString();

                if(TextUtils.isEmpty(id) || TextUtils.isEmpty(pwd)){
                    Toast.makeText(SearchAccountActivity.this,"Please type your ID and Password",Toast.LENGTH_SHORT).show();
                }else{
                    if(mAccountHashMap.containsKey(id)){
                        Account account = mAccountHashMap.get(id);
                        if(account.getPwd().equals(pwd)){
                            mtxtResult.setText(account.toString());
                        }else{
                            Toast.makeText(SearchAccountActivity.this,"Please check your password.",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(SearchAccountActivity.this,"No records regarding your ID",Toast.LENGTH_SHORT).show();

                    }
                }
                break;
            case R.id.btnClose:
                finish();
                break;
        }
    }
}
