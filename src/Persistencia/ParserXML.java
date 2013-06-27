/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Item;
import Modelo.Lista;
import Modelo.Subitem;
import Modelo.Usuario;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.digester3.Digester;
import org.xml.sax.SAXException;

/**
 *
 * @author Rayan
 */
public class ParserXML {
    private Usuario retorno = null;
    public ParserXML(String arquivo) {
        try {
         Digester digester = new Digester();
         digester.setValidating( false );

         digester.addObjectCreate( "usuario", Usuario.class );
		 digester.addSetProperties( "usuario", "login", "login" );
		 digester.addSetProperties( "usuario", "senha", "senha" );
		 digester.addSetProperties( "usuario", "nome", "nome" );

         digester.addObjectCreate( "usuario/listas/lista", Lista.class );
		 digester.addSetProperties( "usuario/listas/lista", "nome", "nome" );
                 
         digester.addObjectCreate( "usuario/listas/lista/item", Item.class );
                 
                digester.addBeanPropertySetter( "usuario/listas/lista/item", "nome" );
                digester.addBeanPropertySetter( "usuario/listas/lista/item", "local" );
                digester.addBeanPropertySetter( "usuario/listas/lista/item", "prioridade" );
                digester.addBeanPropertySetter( "usuario/listas/lista/item", "dataCriacao" );
                digester.addBeanPropertySetter( "usuario/listas/lista/item", "dataFinalizar" );
                digester.addBeanPropertySetter( "usuario/listas/lista/item", "dataFinalizado" );
                digester.addBeanPropertySetter( "usuario/listas/lista/item", "descricao" );
         
         digester.addObjectCreate( "usuario/listas/lista/item/subitens/subitem", Subitem.class );
                digester.addBeanPropertySetter( "usuario/listas/lista/item/subitens/subitem", "nome" );
                digester.addBeanPropertySetter( "usuario/listas/lista/item/subitens/subitem", "realizado" );
         
                


         File inputFile = new File(arquivo);
         retorno = (Usuario) digester.parse( inputFile );           

      } catch( IOException | SAXException exc ) {
      }
   }
    public Usuario pegarUsuario(){
        return retorno;
    }
}
