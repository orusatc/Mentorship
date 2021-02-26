package utils.lesson4.observer;

import org.apache.log4j.Logger;
import org.testng.ITestContext;

public class Log {
    //Initialize Log4j instance
    private static Logger Log = Logger.getLogger(Log.class.getName());

    //We can use it when starting tests
    public static void startLog (ITestContext iTestContext){
        //Log.info("Test is Starting...");
        Log.info("I am in onStart method " + iTestContext.getName());
    }

    //We can use it when ending tests
    public static void endLog (ITestContext iTestContext){
        Log.info("Test is Ending...");
    }

    //Info Level Logs
    public static void info (String message) {
        Log.info("\u001B[35m" + message.toUpperCase() + "\u001B[0m");
    }

}

