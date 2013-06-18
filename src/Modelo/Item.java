/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Rayan
 */
public class Item {
    private String nome;
    private String local;
    private int prioridade;
    private Date dataCriacao;
    private Date dataFinalizar;
    private Date dataFinalizado;
    private String descricao;
    private List<Subitem> listaSubItens;

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
    public Date getDataCriacao() {
        return dataCriacao;
    }

    /**
     * @param dataCriacao the dataCriacao to set
     */
    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    /**
     * @return the dataFinalizar
     */
    public Date getDataFinalizar() {
        return dataFinalizar;
    }

    /**
     * @param dataFinalizar the dataFinalizar to set
     */
    public void setDataFinalizar(Date dataFinalizar) {
        this.dataFinalizar = dataFinalizar;
    }

    /**
     * @return the dataFinalizado
     */
    public Date getDataFinalizado() {
        return dataFinalizado;
    }

    /**
     * @param dataFinalizado the dataFinalizado to set
     */
    public void setDataFinalizado(Date dataFinalizado) {
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
    public List<Subitem> getListaSubItens() {
        return listaSubItens;
    }

    /**
     * @param listaSubItens the listaSubItens to set
     */
    public void setListaSubItens(List<Subitem> listaSubItens) {
        this.listaSubItens = listaSubItens;
    }
   
}
