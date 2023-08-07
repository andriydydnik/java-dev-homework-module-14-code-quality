package tic_tac_toe;

import java.util.logging.ConsoleHandler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerForMessage {



    public static  <T>Logger getCustomizedLogger(T obj){
        Logger logger = Logger.getLogger(obj.getClass().getName());
        logger.setUseParentHandlers(false);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter() {
            @Override
            public synchronized String format(LogRecord rec) {
                return rec.getMessage() + "\n";
            }
        });
        logger.addHandler(handler);
        return logger;
    }
}
