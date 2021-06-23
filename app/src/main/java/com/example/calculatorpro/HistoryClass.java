package com.example.calculatorpro;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class HistoryClass extends AppCompatActivity {
    ListView listview;
    String[] history_all;

    Button clr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc_history);
        setTitle("History");
        assert getSupportActionBar()!=null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        clr=(Button)findViewById(R.id.clr);

        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.emptyHistory();
                listview.setAdapter(null);
            }
        });

        listview=(ListView)findViewById(R.id.listview);
        List<String> history_ref=MainActivity.getList();
        history_all=new String[history_ref.size()];
        /*for(int i=0;i<history_ref.size();i++)
        {
            Log.d("HistoryClassRes",history_ref.get(i));
        }*/
        Log.d("Historyclassend","000");
        for(int i=0;i<history_ref.size();i++)
        {
            history_all[i]= String.valueOf(Html.fromHtml(history_ref.get(i)));
        }

       // Log.d("array contents",String.valueOf(history_all));
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,history_all);
        listview.setAdapter(adapter);

    }
    @Override
    public boolean onSupportNavigateUp()
    {
        finish();
        return true;
    }
}
