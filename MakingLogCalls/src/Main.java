import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {

    static LogManager logManager = LogManager.getLogManager();
    static Logger logger = logManager.getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static void main(String[] args) {
        logger.setLevel(Level.FINER);
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

        doWork();
        //logger.log(Level.INFO,"{0} is my favorite","Java");
        //logger.log(Level.INFO,"{0} is {1} days from {2}",new Object[]{"Wed",2,"Fri"});
        parameterisedLog("Jim","Jones");
    }

    private static void doWork(){

        logger.entering("com.jwhh.support.Other","doWork()");
        logger.logp(Level.WARNING,"com.jwhh.support.Other","doWork()","Empty Function");
        logger.exiting("com.jwhh.support.Other","doWork()");
    }

    private static void parameterisedLog(String left, String right){
        logger.entering("com.jwhh.support.Other","parameterisedLog()",new Object[]{left,right});
        String result = "< "+left+right+" >";
        logger.logp(Level.INFO,"this class","paramterisedLog","{0},{1} is name",new Object[]{left,right});
        logger.exiting("com.jwhh.support.Other","parameterisedLog()",result);
    }
}
