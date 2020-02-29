package com.example.tp3;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class MyList extends AppCompatActivity {
    ArrayList Etablissements = new ArrayList<>(Arrays.asList(
            new Etablissement("ENSIAS", "Ecole Nationale Supérieure d'Informatique et d'Analyse des Systèmes", R.drawable.ens,33.984276, -6.867645),
            new  Etablissement("FMP", "Faculté de Medcine et de Pharmacie", R.drawable.md,33.983032, -6.855890),
            new  Etablissement ("FMD", "Faculté de Medcine Dentaire", R.drawable.logo,33.980725, -6.870307),
            new  Etablissement ("ENS", "Ecole Normale Supérieure", R.drawable.ulm,33.982902, -6.826594),
            new  Etablissement ("FS", "Faculté des sciences", R.drawable.fs,34.010206, -6.835685),
            new  Etablissement ("ESI", "Ecole de sciences de l'information",R.drawable.ic_launcher_background,33.982486, -6.865537)
    ));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mylist);

        getSupportActionBar().setTitle("Liste des établissements");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //	get	the	reference	of	RecyclerView
        RecyclerView rv	= findViewById(R.id.list);

        //	set	a	LinearLayoutManager	with	default	vertical	orientation
        rv.setLayoutManager(new LinearLayoutManager(MyList.this));

        //	call	the	constructor	of	MyAdapter	to	send	the	reference	and	data	to	Adapter

        MyAdapter myAdapter = new MyAdapter(this,	Etablissements);
        rv.setAdapter(myAdapter);
    }


    public	boolean	onCreateOptionsMenu(Menu menu)	{
        //	TODO	Auto-generated	method	stub
        MenuInflater inflater	=	getMenuInflater();
        inflater.inflate(R.menu.menu,	menu);
        return	super.onCreateOptionsMenu(menu);
    }

    public	boolean	onOptionsItemSelected(MenuItem item)	{
        switch(item.getItemId())	{
            //	On	peut	créer	le	menu	via	le	code
            case	R.id.item1:	Toast.makeText(this,	"À	propos",
                    Toast.LENGTH_LONG).show();	break;
            case	R.id.item2:	Toast.makeText(this,	"Ajouter un etablissement",
                    Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MyList.this,AddEtablissement.class);
                    startActivity(intent);
                    break;
            case	R.id.item3:	Toast.makeText(this,	"Supprimer un etablissement",
                    Toast.LENGTH_LONG).show();	break;
        }
        return	super.onOptionsItemSelected(item);
    }
}

