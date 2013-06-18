/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;

/**
 *
 * @author Rayan
 */
public class Lista {
    private String nome;
    private List<Item> listaItens;

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
    public List<Item> getListaItens() {
        return listaItens;
    }

    /**
     * @param listaItens the listaItens to set
     */
    public void setListaItens(List<Item> listaItens) {
        this.listaItens = listaItens;
    }
    
}
