package com.demo.hntest.Designpatterns.java.proxy;

/**
 * 抽象主题
 */
public interface CommandExecutor {
    public void runCommand(String cmd) throws Exception;
}
