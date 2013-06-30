/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Log;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 *
 * @author Rayan
 */
public class Log {
    public static Logger log;
    
    public Log(Class c){
        log = Logger.getLogger(c.getName());
        BasicConfigurator.configure();
    }
    public void error(String metodo, String msg, Throwable k){
        log.error("[" + metodo + "] " + msg, k);
    }
    public void error(String metodo, String msg){
        log.error("[" + metodo + "] " + msg);
    }
    public void fatal(String metodo, String msg, Throwable k){
        log.fatal("[" + metodo + "] " + msg, k);
    }
    public void fatal(String metodo, String msg){
        log.fatal("[" + metodo + "] " + msg);
    }
    public void warn(String metodo, String msg, Throwable k){
        log.warn("[" + metodo + "] " + msg, k);
    }
    public void warn(String metodo, String msg){
        log.warn("[" + metodo + "] " + msg);
    }
    public void info(String metodo, String msg, Throwable k){
        log.info("[" + metodo + "] " + msg, k);
    }
    public void info(String metodo, String msg){
        log.info("[" + metodo + "] " + msg);
    }
    public void debug(String metodo, String msg, Throwable k){
        log.debug("[" + metodo + "] " + msg, k);
    }
    public void debug(String metodo, String msg){
        log.debug("[" + metodo + "] " + msg);
    }
    public void trace(String metodo, String msg, Throwable k){
        log.trace("[" + metodo + "] " + msg, k);
    }
    public void trace(String metodo, String msg){
        log.trace("[" + metodo + "] " + msg);
    }
}
