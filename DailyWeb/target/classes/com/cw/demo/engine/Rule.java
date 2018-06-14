package com.cw.demo.engine;

public interface Rule extends Comparable<Rule>{

    String getName();

    String getAction();

    String getDescription();

    String getCondition();

    int getPriority();

    boolean validate();

}
