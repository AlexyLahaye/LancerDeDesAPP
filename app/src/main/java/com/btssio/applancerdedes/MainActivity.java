package com.btssio.applancerdedes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.sql.Types;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Types> listeTypes;
    private DatabaseManager dbm;
    ListView lvListe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listeTypes = new DatabaseManager(this).lectureTypes();

        lvListe = (ListView) findViewById((R.id.lvListe));

        lvListe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startViewActivity(i);
            }
        });
    }
        private void startViewActivity(int i) {
            Types unTypes = listeTypes.get(i);
            Intent intent = new Intent(this,JeuActivity.class);
        }

        @Override
        public void onResume(){
        super.onResume();
            ListeAdapter listeAdapter = new ListeAdapter(this, listeTypes);
            lvListe.setAdapter(listeAdapter);
        }
}