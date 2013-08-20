/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Log;

import java.util.Date;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Log {
    private static Logger log;
    
    public Log(Class c){
        log = Logger.getLogger(c.getName());
        BasicConfigurator.configure();
    }
    public void error(String metodo, String msg, Throwable k){
        log.error("[" + metodo + "] " + new Date() + " : " + msg, k);
    }
    public void error(String metodo, String msg){
        log.error("[" + metodo + "] " + new Date() + " : " + msg);
    }
    public void fatal(String metodo, String msg, Throwable k){
        log.fatal("[" + metodo + "] " + new Date() + " : " + msg, k);
    }
    public void fatal(String metodo, String msg){
        log.fatal("[" + metodo + "] " + new Date() + " : " + msg);
    }
    public void warn(String metodo, String msg, Throwable k){
        log.warn("[" + metodo + "] " + new Date() + " : " + msg, k);
    }
    public void warn(String metodo, String msg){
        log.warn("[" + metodo + "] " + new Date() + " : " + msg);
    }
    public void info(String metodo, String msg, Throwable k){
        log.info("[" + metodo + "] " + new Date() + " : " + msg, k);
    }
    public void info(String metodo, String msg){
        log.info("[" + metodo + "] " + new Date() + " : " + msg);
    }
    public void debug(String metodo, String msg, Throwable k){
        log.debug("[" + metodo + "] " + new Date() + " : " + msg, k);
    }
    public void debug(String metodo, String msg){
        log.debug("[" + metodo + "] " + new Date() + " : " + msg);
    }
    public void trace(String metodo, String msg, Throwable k){
        log.trace("[" + metodo + "] " + new Date() + " : " + msg, k);
    }
    public void trace(String metodo, String msg){
        log.trace("[" + metodo + "] " + new Date() + " : " + msg);
    }
}
