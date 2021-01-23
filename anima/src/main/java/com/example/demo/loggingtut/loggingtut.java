package com.example.demo.loggingtut;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.logging.Level;

public class loggingtut {

    public static final Logger log1 = LogManager.getLogger(loggingtut.class);
    public static void main(String args[])
    {
        log1.trace("Trace Message!");
        log1.debug("Debug Message!");
        log1.info("Info Message!");
        log1.warn("Warn Message!");
        log1.error("Error Message!");
        log1.fatal("Fatal Message!");
    }
}
