package com.example.volume_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //1-AdapterView: GridView
    GridView gridview;
    //2-Dta source: ArrayList<shape>
    ArrayList<shape> shapeArrayList;
    //3-Adapter: my_custom_adapter
    my_custom_adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridview=findViewById(R.id.gridview);
        shapeArrayList=new ArrayList<>();
        shape s1=new shape(R.drawable.sphere,"sphere");
        shape s2=new shape(R.drawable.cyclinder,"cyclinder");
        shape s3=new shape(R.drawable.cube,"cube");
        shape s4=new shape(R.drawable.prism,"prism");
        shapeArrayList.add(s1);
        shapeArrayList.add(s2);
        shapeArrayList.add(s3);
        shapeArrayList.add(s4);

        adapter =new my_custom_adapter(shapeArrayList,getApplicationContext());
        gridview.setAdapter(adapter);
        gridview.setNumColumns(2);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i =new Intent(getApplicationContext(), sphere.class);
                startActivity(i);
            }
        });

    }
}