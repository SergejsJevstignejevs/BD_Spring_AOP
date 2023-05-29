package com.sj.interfaces.impl;

import com.sj.interfaces.LoggingRecorder;

public class LoggingRecorderImpl implements LoggingRecorder {

    public void printMessage(String message) {
        System.out.println(message);
    }

}
