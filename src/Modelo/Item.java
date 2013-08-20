package Modelo;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import javafx.beans.property.SimpleBooleanProperty;

public class Item implements Comparable<Item>{
    private SimpleBooleanProperty selected;
    private String nome;
    private String local;
    private int prioridade;
    private String dataCriacao;
    private String dataFinalizar;
    private String dataFinalizado;
    private String descricao;
    private boolean realizado;
    private ArrayList<Subitem> listaSubItens;

    public Item(){
        listaSubItens = new ArrayList<>();
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
     * @return the local
     */
    public String getLocal() {
        return local;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(String local) {
        this.local = local;
    }

    /**
     * @return the prioridade
     */
    public int getPrioridade() {
        return prioridade;
    }

    /**
     * @param prioridade the prioridade to set
     */
    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    /**
     * @return the dataCriacao
     */
    public String getDataCriacao() {
        return dataCriacao;
    }

    /**
     * @param dataCriacao the dataCriacao to set
     */
    public void setDataCriacao(String dataCriacao) {
        /*DateFormat dt = new SimpleDateFormat("dd/MM/yyyy");  
        Date date = new Date();  
        try {
            date = (Date)dt.parse(dataCriacao);
        } catch (ParseException ex) {}*/
        this.dataCriacao = dataCriacao;
    }

    /**
     * @return the dataFinalizar
     */
    public String getDataFinalizar() {
        return dataFinalizar;
    }

    /**
     * @param dataFinalizar the dataFinalizar to set
     */
    public void setDataFinalizar(String dataFinalizar) {
        this.dataFinalizar = dataFinalizar;
    }

    /**
     * @return the dataFinalizado
     */
    public String getDataFinalizado() {
        return dataFinalizado;
    }

    /**
     * @param dataFinalizado the dataFinalizado to set
     */
    public void setDataFinalizado(String dataFinalizado) {
       
        this.dataFinalizado = dataFinalizado;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the listaSubItens
     */
    public ArrayList<Subitem> getListaSubItens() {
        return listaSubItens;
    }  
   
    public void adicionarSubitem(Subitem l){
        this.listaSubItens.add(l);
    }
    public Subitem encontrarSubitem(String nome){
        for(Subitem l : listaSubItens){
            if(l.getNome().equals(nome)){
                return l;
            }
        }
        return null;
    }
    public void removerSubItem(Subitem l){
        listaSubItens.remove(l);

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

    @Override
    public int compareTo(Item o) {
        return this.getPrioridade() - o.getPrioridade();
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
}
