package com.caveofprogramming.spring.test;

import org.springframework.beans.factory.annotation.Autowired;

/*
 * Dummy implementation of logger.
 */
public class Logger {

    private ConsoleWriter consoleWriter;
    private FileWriter fileWriter;

    @Autowired(required=false)
    public void setConsoleWriter(ConsoleWriter writer) {
        this.consoleWriter = writer;
    }

    @Autowired // byType
    public void setFileWriter(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    public void writeFile(String text) {
        fileWriter.write(text);
    }

    // Optional Beans
    public void writeConsole(String text) {
        if (consoleWriter != null) {
            consoleWriter.write(text);
        }
    }

}
