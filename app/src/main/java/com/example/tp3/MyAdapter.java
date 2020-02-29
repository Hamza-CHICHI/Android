package com.example.tp3;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {




    private ArrayList Etablissements ;
    private Context context;

    //Constructeur
    public MyAdapter(Context context, ArrayList Etablissements) {
        this.context = context;
        this.Etablissements = Etablissements;
    }
    //---------------------------------------------------------------------------------------------

    public int getItemCount() {
        return Etablissements.size();
    }

    //---------------------------------------------------------------------------------------------


    //crée la vue d'une cellule
    // parent pour créer la vu et int pour spécifier le type de la cellule si on a plusieurrs type (orgnaisation differts)
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }

    //---------------------------------------------------------------------------------------------

    //appliquer une donnée à une vue
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Etablissement Etab= (Etablissement) Etablissements.get(position);

        System.out.println("Vname =" + Etab.getName());
        System.out.println("position=" + position);

        holder.display(Etab);
    }

    //---------------------------------------------------------------------------------------------

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView label;
        private final TextView name;
        private final ImageView img;

        private Etablissement currentEtab;

        public MyViewHolder(final View itemView) {
            super(itemView);

            label = itemView.findViewById(R.id.label);
            name = itemView.findViewById(R.id.name);
            img =  itemView.findViewById(R.id.img);

            //Afficher les labels des etablissements dans un alertDialog apres avoir cliquer sur un item
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent;
                    intent = new Intent(view.getContext(),GoogleMapsActivity.class);
                    new AlertDialog.Builder(itemView.getContext())
                            .setTitle(currentEtab.getLabel());
                    intent.putExtra("name", currentEtab.getName());
                    intent.putExtra("label", currentEtab.getLabel());
                    intent.putExtra("lon", currentEtab.getLon());
                    intent.putExtra("lat", currentEtab.getLat());
                    view.getContext().startActivity(intent);
                }
            });
        }

        //Pour afficher les etablisements dans le recycler view
        public void display(Etablissement Etab) {
            currentEtab = Etab;
            name.setText(Etab.getName());
            label.setText(Etab.getLabel());
            img.setImageResource(Etab.getImg());

        }
    }

    //---------------------------------------------------------------------------------------------

}