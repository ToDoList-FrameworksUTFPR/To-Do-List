package Modelo;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;

public class Usuario {

    /**
     * @param aInstance the instance to set
     */
    private String login;
    private String senha;
    private String nome;
    private ArrayList<Lista> listas;

    public Usuario(){
        listas = new ArrayList<>();
    }
    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
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
     * @return the listas
     */
    public ArrayList<Lista> getListas() {
        return listas;
    }
    
    public void adicionarLista(Lista l){
        listas.add(l);
    }
    public Lista encontrarLista(String nome){
        for(Lista l : listas){
            if(l.getNome().equals(nome)){
                return l;
            }
        }
        return null;
    }
    public void removerLista(Lista l){
        listas.remove(l);
    }
}
