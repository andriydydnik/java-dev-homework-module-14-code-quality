package game;

import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

public class CustomSimpleFormatter extends SimpleFormatter {
    @Override
    public String format(LogRecord logRecord) {
        return logRecord.getMessage() + System.lineSeparator();
    }
}

