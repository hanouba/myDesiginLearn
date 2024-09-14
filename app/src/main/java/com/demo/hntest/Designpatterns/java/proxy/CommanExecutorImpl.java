package com.demo.hntest.Designpatterns.java.proxy;

public class CommanExecutorImpl implements CommandExecutor{
    @Override
    public void runCommand(String cmd) throws Exception {
        Runtime.getRuntime().exec(cmd);
        System.out.println("Command executed : " + cmd);
    }
}
