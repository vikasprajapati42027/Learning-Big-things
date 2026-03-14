public class ChainDemo {
    private static AbstractLogger getChainOfLoggers(){
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();

        System.out.println("--- Level: INFO ---");
        loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");

        System.out.println("\n--- Level: DEBUG ---");
        loggerChain.logMessage(AbstractLogger.DEBUG, "This is a debug level information.");

        System.out.println("\n--- Level: ERROR ---");
        loggerChain.logMessage(AbstractLogger.ERROR, "This is an error information.");
    }
}
