package Modelo;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Rayan
 */
public class Subitem implements Comparable<Subitem>{
    private String nome;
    private boolean realizado;

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
     * @return the realizado
     */
    public boolean isRealizado() {
        return realizado;
    }

    /**
     * @param realizado the realizado to set
     */
    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }

    @Override
    public int compareTo(Subitem o) {
        return this.getNome().toUpperCase().compareTo(o.getNome().toUpperCase());
    }
}
