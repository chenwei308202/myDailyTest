package com.cw.demo.engine;

/**
 * @author chenwei
 * @create 2018-06-12 18:24
 **/

public class BasicRule implements Rule {

    protected String name;

    protected String description;

    protected int priortity;

    private String condition;

    private String action;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public int getPriority() {
        return priortity;
    }

    public void setPriortity(int priortity) {
        this.priortity = priortity;
    }
    @Override
    public String getCondition() {
        return condition;
    }

    @Override
    public boolean validate() {
        return false;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public int compareTo(Rule o) {
        if (this.priortity>o.getPriority()){
            return 1;
        }else if(this.priortity<o.getPriority()){
            return -1;
        }else {
            return 0;

        }
    }
}
