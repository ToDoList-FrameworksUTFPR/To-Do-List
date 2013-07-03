package Modelo;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.text.DateFormat;
import java.util.ArrayList;
import javafx.beans.property.SimpleBooleanProperty;

/**
 *
 * @author Rayan
 */
public class Item {
    private SimpleBooleanProperty selected;
    private String nome;
    private String local;
    private int prioridade;
    private String dataCriacao;
    private String dataFinalizar;
    private String dataFinalizado;
    private String descricao;
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
    @Override
    public String toString() {
        String dtCriacao = null;
        String dtFinalizar = null;
        String dtFinalizado = null;
        if (dataCriacao != null) {
            dtCriacao = DateFormat.getDateInstance().format(dataCriacao);
        }
        if (dataFinalizar != null) {
            dtFinalizar = DateFormat.getDateInstance().format(dataFinalizar);
        }
        if (dataFinalizado != null) {
            dtFinalizado = DateFormat.getDateInstance().format(dataFinalizado);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[Item nome=");
        sb.append(nome);
        sb.append(" local=");
        sb.append(local);
        sb.append(" prioridade=");
        sb.append(prioridade);
        sb.append(" descricao=");
        sb.append(descricao);
        sb.append(" dataCriacao=");
        sb.append(dtCriacao);
        sb.append(" dataFinalizar=");
        sb.append(dtFinalizar);
        sb.append(" dataFinalizado=");
        sb.append(dtFinalizado);
        sb.append("]");
        return sb.toString();
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
