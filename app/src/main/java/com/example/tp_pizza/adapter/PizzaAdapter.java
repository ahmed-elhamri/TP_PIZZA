package com.example.tp_pizza.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tp_pizza.R;
import com.example.tp_pizza.classes.Produit;

import java.util.List;

public class PizzaAdapter extends BaseAdapter {
    private List<Produit> produits;
    private LayoutInflater inflater;

    public PizzaAdapter(List<Produit> produits, Activity activity) {
        this.produits = produits;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return produits.size();
    }

    @Override
    public Object getItem(int position) {
        return produits.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position + 1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView ==  null)
            convertView = inflater.inflate(R.layout.item, null);

        TextView id = convertView.findViewById(R.id.id);
        TextView nom = convertView.findViewById(R.id.nom);
        TextView nbrIngredients = convertView.findViewById(R.id.nbrIngredients);
        TextView duree = convertView.findViewById(R.id.duree);
        ImageView image = convertView.findViewById(R.id.image);
        ImageView goTo = convertView.findViewById(R.id.goTo);
        ImageView dureeIcon = convertView.findViewById(R.id.dureeIcon);
        ImageView nbrIngredientsIcon = convertView.findViewById(R.id.nbrIngredientsIcon);

        id.setText(produits.get(position).getId()+"");
        nom.setText(produits.get(position).getNom());
        nbrIngredients.setText(produits.get(position).getNbrIngredients()+"");
        duree.setText(produits.get(position).getDuree());
        image.setImageResource(produits.get(position).getPhoto());
        dureeIcon.setImageResource(R.mipmap.timer);
        goTo.setImageResource(R.mipmap.go);
        nbrIngredientsIcon.setImageResource(R.mipmap.man);

        return convertView;
    }
}
