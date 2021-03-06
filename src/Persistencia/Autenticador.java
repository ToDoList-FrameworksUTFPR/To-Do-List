/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Log.Log;
import Modelo.Usuario;
import Visao.ProjetoFinal;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;

public final class Autenticador {
    
    protected ArrayList<Usuario> todosUsuarios = null;
    private static Log log = new Log(Autenticador.class);
    
    protected void instanciarUsuarios(){
        String local = "src/xml/Usuarios";
        ArrayList<File> listaArquivosUsuarios = new ArrayList<>();
        log.info("instanciarUsuarios", "Iniciou a funcao e instanciou variavel local e listaArquivosUsuarios");
        FilenameFilter filtro = new  FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".xml".toLowerCase());
            }
        };
        listaArquivosUsuarios.addAll(Arrays.asList(new File(local).listFiles(filtro)));
        log.info("instanciarUsuarios", "Retornou lista de arquivos com o filtro");
        for(File f : listaArquivosUsuarios){
            ParserXML parserUsuario = new ParserXML((f.getParent() + "\\"+ f.getName()));
            todosUsuarios.add(parserUsuario.pegarUsuario());
        }
    }
    
    public Autenticador(){
        todosUsuarios = new ArrayList<>();        
        instanciarUsuarios();
    }
    
    public boolean verificarLogin(Usuario u){
        for(Usuario x : todosUsuarios){
            if(x.getLogin().equals(u.getLogin()) && x.getSenha().equals(u.getSenha())){
                ProjetoFinal p = ProjetoFinal.getInstance();
                p.instanciarUsuario(x);
                return true;
            }
        }
        return false;
    }
}
