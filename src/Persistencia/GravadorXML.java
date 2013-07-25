/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Log.Log;
import Modelo.Lista;
import Modelo.Usuario;
import java.beans.IntrospectionException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.betwixt.io.BeanWriter;
import org.apache.commons.betwixt.strategy.DecapitalizeNameMapper;
import org.xml.sax.SAXException;

/**
 *
 * @author Rayan
 */
public class GravadorXML {
    private static Log log = new Log(Autenticador.class);
    public GravadorXML(Usuario u){
        for(Lista l : u.getListas()){
            System.out.println("Quantidade de itens lista :" + l.getNome() + l.getListaItens().size());            
        }
        String arquivo = u.getLogin() + ".xml";
        log.info("[GravadorXML]", "Iniciado chamada de classe");
        BeanWriter writer = new BeanWriter();
        try {
            writer = new BeanWriter(new FileOutputStream(new File("src/xml/Usuarios/" + arquivo)));
        } catch (FileNotFoundException ex) {
            log.fatal("[GravadorXML]", "Erro ao gerar/substituir arquivo -> " + arquivo, ex);
        }
        writer.getXMLIntrospector().setAttributesForPrimitives(true);
        writer.enablePrettyPrint();
        writer.setWriteIDs(false);        
        writer.getXMLIntrospector().setElementNameMapper(new DecapitalizeNameMapper());
        
        try {                
            writer.write(u);
        } catch (IOException | SAXException | IntrospectionException ex) {
            log.fatal("[GravadorXML]", "Erro ao realizar a gravação de -> " + arquivo, ex);
        }
    }
    
}
