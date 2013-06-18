/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Usuario;
import org.apache.commons.digester3.Digester;

/**
 *
 * @author Rayan
 */
public class DigesterUsuario {
    public DigesterUsuario(){
        Usuario usuario = new Usuario();
        Digester digester = new Digester();
        
        digester.addObjectCreate(null, usuario.getClass());  
        digester.addSetProperties("Modelo/codigo", "id", "id"); 
    }
    
}
