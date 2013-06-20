/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Usuario;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rayan
 */
public final class Autenticador {
    
    protected List<Usuario> todosUsuarios = null;
    
    protected void instanciarUsuarios(){
        String localizacao = null;      
        try {
            localizacao = new File(".").getCanonicalPath(); //"C:\\TesteArquivos\\";
        } catch (IOException ex) {
            Logger.getLogger(Autenticador.class.getName()).log(Level.SEVERE, null, ex);
        }

        File arquivosUsuarios[] = new File(localizacao).listFiles(); 
        
        for(File u : arquivosUsuarios){
            //insere atraves de cada parser em cada arquivo na lista.
        }
        
        //atraves dos arquivos lidos, utilizar o parser do XML e realizar a leitura na variavel
        // para posteriormente verificar se é possivel autenticar ou nao
    }
    
    public Autenticador(){
        todosUsuarios = null;
        instanciarUsuarios();
    }
    
    public boolean verificarLogin(Usuario u){
        for(Usuario x : todosUsuarios){
            if(x.getLogin().equals(u.getLogin()) && x.getSenha().equals(u.getSenha()))
                return true;
        }
        return false;
    }
}
