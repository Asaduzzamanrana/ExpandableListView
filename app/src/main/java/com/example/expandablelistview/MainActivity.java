package com.example.expandablelistview;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private CustomAdapter customAdapter;
     List<String> listDataHeader;
     HashMap<String,List<String>> listDataChild;
     private int lastExpandable= -1;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareListData();

        expandableListView = findViewById(R.id.exlistviewid);
        customAdapter = new CustomAdapter(this, listDataHeader, listDataChild);
        expandableListView.setAdapter(customAdapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                String groupName=listDataHeader.get(groupPosition);
                Toast.makeText(getApplicationContext(),groupName,Toast.LENGTH_SHORT).show();

                return false;
            }
        });
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                String groupName=listDataHeader.get(groupPosition);
                Toast.makeText(getApplicationContext(),groupName,Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String childString=listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);
                Toast.makeText(getApplicationContext(),childString,Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                if (lastExpandable!=-1 && lastExpandable!=groupPosition)
                {
                    expandableListView.collapseGroup(lastExpandable);
                }
                lastExpandable=groupPosition;
            }
        });

    }


    public void prepareListData()
    {

       listDataHeader=new ArrayList<>();
       listDataChild=new HashMap<>();

        listDataHeader.add(getResources().getString(R.string.robin));
        listDataHeader.add(getResources().getString(R.string.kazi));
        listDataHeader.add(getResources().getString(R.string.jashim));
        listDataHeader.add(getResources().getString(R.string.micel));
        listDataHeader.add(getResources().getString(R.string.jibon));
        listDataHeader.add(getResources().getString(R.string.issor));
        listDataHeader.add(getResources().getString(R.string.kaykobad));
        listDataHeader.add(getResources().getString(R.string.suku));
        listDataHeader.add(getResources().getString(R.string.sukanto));
        listDataHeader.add(getResources().getString(R.string.soten));

        List<String>robichild=new ArrayList<>();
        robichild.add(getResources().getString(R.string.robinji));
        robichild.add(getResources().getString(R.string.robilist));

        List<String>kazichild=new ArrayList<>();
        kazichild.add(getResources().getString(R.string.kaziji));
        kazichild.add(getResources().getString(R.string.kazilist));

        List<String>jashimchild=new ArrayList<>();
        jashimchild.add(getResources().getString(R.string.jashimji));
        jashimchild.add(getResources().getString(R.string.jashimlist));

        List<String>micelchild=new ArrayList<>();
        micelchild.add(getResources().getString(R.string.micelji));
        micelchild.add(getResources().getString(R.string.micellist));

        List<String>jibonchild=new ArrayList<>();
        jibonchild.add(getResources().getString(R.string.jibonji));
        jibonchild.add(getResources().getString(R.string.jibonlist));

        List<String>issorchild=new ArrayList<>();
        issorchild.add(getResources().getString(R.string.issorji));
        issorchild.add(getResources().getString(R.string.issorlist));

        List<String>kaykochild=new ArrayList<>();
        kaykochild.add(getResources().getString(R.string.kaykobadji));
        kaykochild.add(getResources().getString(R.string.kaykobadlist));

        List<String>sukuchild=new ArrayList<>();
        sukuchild.add(getResources().getString(R.string.sukuji));
        sukuchild.add(getResources().getString(R.string.sukulist));

        List<String>sukantochild=new ArrayList<>();
        sukantochild.add(getResources().getString(R.string.sukantoji));
        sukantochild.add(getResources().getString(R.string.sukantoji));

        List<String>sotenchild=new ArrayList<>();
        sotenchild.add(getResources().getString(R.string.sotenji));
        sotenchild.add(getResources().getString(R.string.sotenlist));

        listDataChild.put(listDataHeader.get(0),robichild);
        listDataChild.put(listDataHeader.get(1),kazichild);
        listDataChild.put(listDataHeader.get(2),jashimchild);
        listDataChild.put(listDataHeader.get(3),micelchild);
        listDataChild.put(listDataHeader.get(4),jibonchild);
        listDataChild.put(listDataHeader.get(5),issorchild);
        listDataChild.put(listDataHeader.get(6),kaykochild);
        listDataChild.put(listDataHeader.get(7),sukuchild);
        listDataChild.put(listDataHeader.get(8),sukantochild);
        listDataChild.put(listDataHeader.get(9),sotenchild);

    }

}
