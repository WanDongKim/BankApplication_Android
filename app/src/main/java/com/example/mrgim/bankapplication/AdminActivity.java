package com.example.mrgim.bankapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        ArrayList<Account> accountList = new ArrayList<>();

        Intent intent = getIntent();
        if(intent != null){
            HashMap<String, Account> hMap = (HashMap<String, Account>) intent.getSerializableExtra("data");
            accountList = new ArrayList<>(hMap.values());
        }

        ListView listView = (ListView) findViewById(R.id.list_view);

        AccountAdapter adapter = new AccountAdapter(accountList);
        listView.setAdapter(adapter);
    }

    private static class AccountAdapter extends BaseAdapter{

        private List<Account> mData;
        public AccountAdapter(List<Account> data){
            mData = data;
        }
        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public Object getItem(int position) {
            return mData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_2,parent,false);
            }
            TextView text1 = (TextView) convertView.findViewById(android.R.id.text1);
            TextView text2 = (TextView) convertView.findViewById(android.R.id.text2);

            Account account = mData.get(position);

            text1.setText(account.getId());
            text2.setText(account.getBalance());

            return convertView;
        }
    }
}
