package com.example.tornado.listviewcustomz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tornado.listviewcustomz.adapter.CustomAdapter;
import com.example.tornado.listviewcustomz.model.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    CustomAdapter adapter;
    ArrayList<Contact> contacts=new ArrayList<Contact>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setListData();
        
        listView = (ListView) findViewById(R.id.listView);
        adapter = new CustomAdapter(this, contacts);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String text = "Item (" + position + ") Is " + contacts.get(position).getName();
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();

                contacts.get(position).setSeen(true);
                ((BaseAdapter) listView.getAdapter()).notifyDataSetChanged();

            }
        });


    }


    // dasty vared kardan info base on model
    private void setListData() {

        contacts.add(new Contact("Bashir", "img1", "Salam", "12:30 PM", false));
        contacts.add(new Contact("Mojtaba", "img2", "Salam Khubi? Mikhastam Barna...", "6:15 PM", false));
        contacts.add(new Contact("Amir", "img3", "ghorbanat kari nakardam", "Yesterday", true));
        contacts.add(new Contact("Mostafa", "img4", "ye sar ta pish ma ham bia ;)", "Mon", true));
        contacts.add(new Contact("Saeed", "img5", "bia inja man sherkatam", "Mon", true));
        contacts.add(new Contact("Ali", "img6", "salam 10 min dg mitunam j bedam", "Sat", true));
        contacts.add(new Contact("Ehsan", "img7", "salam adres site chie?", "Sep 1, 16", true));
        contacts.add(new Contact("Mohammad", "img8", "I'm bussy, I'll Call Back You Later", "Aug 30, 16", true));
        contacts.add(new Contact("Iman", "img9", "www.wiadevelopers.com", "Jul 6, 16", true));
    }
}
