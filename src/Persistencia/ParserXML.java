/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Usuario;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.digester3.Digester;
import org.apache.commons.digester3.binder.DigesterLoader;
import org.apache.commons.digester3.xmlrules.FromXmlRulesModule;
import org.xml.sax.SAXException;

/**
 *
 * @author Rayan
 */
public class ParserXML {
    private Usuario retorno = null;
    public ParserXML(String arquivo) {
        DigesterLoader digesterLoader = DigesterLoader.newLoader(new FromXmlRulesModule() {
            @Override
            protected void loadRules() {
                loadXMLRules(new File("src/xml/digester-catalog-rules.xml")); //getClass().getResource("/digester-catalog-rules.xml")

            }
        });
        Digester digester = digesterLoader.newDigester();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        digester.push(usuarios);

        try {
            ArrayList<Usuario> resultado = digester.parse(new File(arquivo));            
            retorno = resultado.get(0);
        } catch (IOException | SAXException e) {
            System.out.println("" + e.getMessage());
        }
   }
    public Usuario pegarUsuario(){
        return retorno;
    }
}
