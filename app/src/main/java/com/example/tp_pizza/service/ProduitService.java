package com.example.tp_pizza.service;

import com.example.tp_pizza.classes.Produit;
import com.example.tp_pizza.dao.IDao;

import java.util.ArrayList;
import java.util.List;

public class ProduitService implements IDao<Produit> {
    private List <Produit> produits;
    private static ProduitService instance;

    private ProduitService() {
        this.produits = new ArrayList<>();
    }

    public static ProduitService getInstance() {
        if(instance == null)
            instance =  new ProduitService();
        return instance;
    }
    @Override
    public boolean create(Produit o) {
        return produits.add(o);
    }

    @Override
    public boolean update(Produit o) {
        return false;
    }

    @Override
    public boolean delete(Produit o) {
        return produits.remove(o);
    }

    @Override
    public List<Produit> findAll() {
        return produits;
    }

    @Override
    public Produit findById(int id) {
        for (Produit produit : produits){
            if(produit.getId() == id )
                return produit;
        }
        return null;
    }
}
