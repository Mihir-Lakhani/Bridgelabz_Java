package Java_DesignPatterns.Singleton;

import java.util.*;


class Logger{

    private static Logger instance;
    private static String message;
    private Logger(){

    }

    static Logger getInstance(){
        if (instance == null){
            instance = new Logger();
        }
        return instance;
    }

    void log(String message){
        Logger.message = message;
    }

    public static String getMessage() {
        return message;
    }
}

public class LoggerMain {
    public static void main(String[] args) {

        Logger newLog = Logger.getInstance();
        newLog.log("Hello this is the first instance");
        System.out.println(Logger.getMessage());
    }
}