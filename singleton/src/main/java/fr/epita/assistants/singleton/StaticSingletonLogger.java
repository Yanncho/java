package fr.epita.assistants.singleton;

import fr.epita.assistants.logger.Logger;

import javax.enterprise.inject.Instance;

public class StaticSingletonLogger implements Logger {
    static int info = 0;
    static int warn = 0;
    static int error = 0;

    private StaticSingletonLogger() {
        reset();
    }

    private static class InstanceHolder {
        private static StaticSingletonLogger _INSTANCE = new StaticSingletonLogger();
    }

    public static StaticSingletonLogger getInstance() {
        return InstanceHolder._INSTANCE;
    }

    @Override
    public void log(Level level, String message) {
        if (level == Level.INFO)
            info++;
        else if (level == Level.WARN)
            warn++;
        else if (level == Level.ERROR)
            error++;
        System.err.println("[" + level + "] " + message);
    }

    @Override
    public int getInfoCounter() {
        return info;
    }

    @Override
    public int getWarnCounter() {
        return warn;
    }

    @Override
    public int getErrorCounter() {
        return error;
    }

    @Override
    public void reset() {
        info = 0;
        warn = 0;
        error = 0;
    }
}
