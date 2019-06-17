import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {

    static LogManager logManager = LogManager.getLogManager();
    static Logger logger = logManager.getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static void main(String[] args) {
        /*
        logger.log(Level.INFO,"My first log message");
        logger.log(Level.INFO,"Another message");
        */
        //logger.setLevel(Level.INFO);
        //logger.setLevel(Level.FINE);
        //logger.log(Level.WARNING,"Warning");
        //logger.log(Level.SEVERE,"Severe failure.");
        //logger.log(Level.INFO,"Info level");
        //logger.log(Level.CONFIG,"Configuration");
        //logger.log(Level.FINE,"Hey developer dude");
        //logger.log(Level.FINEST,"Special explanation");
        //logger.severe("severe level");
        logger.setLevel(Level.ALL);
        doWork();
    }

    private static void doWork(){

        logger.entering("com.jwhh.support.Other","doWork");
        logger.logp(Level.WARNING,"com.jwhh.support.Other","doWork","Empty Function");
        logger.exiting("com.jwhh.support.Other","doWork");
    }
}
