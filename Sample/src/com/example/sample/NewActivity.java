package com.example.sample;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.content.*;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.*;

public class NewActivity extends ListActivity {

    ListView lista;
    Button btn2;
    ArrayList<String> fructe;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);
        
        lista = (ListView) findViewById(android.R.id.list);
        
        fructe = new ArrayList<String>();
        fructe.add("Mere"); fructe.add("Nectarine");
        fructe.add("Pere"); fructe.add("Portocale");
        fructe.add("Rodii"); fructe.add("Visine");
        fructe.add("Cirese"); fructe.add("Banane");
        
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, fructe);
        setListAdapter(adapter);
        
        lista.setOnItemClickListener(new OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> adapter, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(NewActivity.this, "Ai cumparat: "+ adapter.getItemAtPosition(position), Toast.LENGTH_SHORT).show()    ;
         }

        });  
        btn2 = (Button)findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {           
            	//Toast.makeText(getApplicationContext(), "Buton apasat!!!", Toast.LENGTH_LONG).show();
            	fructe.add("Piersici");
            	adapter.notifyDataSetChanged();
             }
        });
        lista.setOnItemLongClickListener(new OnItemLongClickListener() {

        @Override
        public boolean onItemLongClick(AdapterView<?> adaptor, View arg1, final int position, long id) {
        		fructe.remove(position);
        		adapter.notifyDataSetChanged();
        		return true;
            }
        });
    }

}
