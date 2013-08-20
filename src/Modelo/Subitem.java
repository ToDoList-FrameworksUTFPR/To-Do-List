package Modelo;

import javafx.beans.property.SimpleBooleanProperty;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


public class Subitem{
    private String nome;
    private boolean realizado;
    private SimpleBooleanProperty selected;

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

    /**
     * @return the selected
     */
    public SimpleBooleanProperty getSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(SimpleBooleanProperty selected) {
        this.selected = selected;
    }

}
