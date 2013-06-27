package Modelo;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;

/**
 *
 * @author Rayan
 */
public class Lista {
    private String nome;
    private ArrayList<Item> listaItens;

    public Lista(){
        listaItens = new ArrayList<>();
    }
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the listaItens
     */
    public ArrayList<Item> getListaItens() {
        return listaItens;
    }    
    
    public void adicionarItem(Item l){
        listaItens.add(l);
    }
    public Item encontrarItem(String nome){
        for(Item l : listaItens){
            if(l.getNome().equals(nome)){
                return l;
            }
        }
        return null;
    }
    public void removerItem(Item l){
        listaItens.remove(l);
    }
}
