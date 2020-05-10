package model.data;

import java.util.ArrayList;

public class Logger
{
    ArrayList<String> log;

    public Logger()
    {
        log = new ArrayList<>();
    }

    public void add(String message)
    {
        this.log.add(message);
    }

    public void add(ArrayList<String> otherLog)
    {
        log.addAll(otherLog);
    }

    public ArrayList<String> getLog()
    {
        return log;
    }

    public ArrayList<String> getLogAndClear()
    {
        ArrayList<String> newLog = new ArrayList<>(log);
        log.clear();
        return newLog;
    }
}
