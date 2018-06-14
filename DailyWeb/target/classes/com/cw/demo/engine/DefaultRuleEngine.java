package com.cw.demo.engine;

import java.util.Set;

/**
 * @author chenwei
 * @create 2018-06-12 18:56
 **/

public class DefaultRuleEngine implements RuleEngine {

    protected Set<Rule> rules;

    protected RuleContext context;


    public DefaultRuleEngine(){

    }



    @Override
    public void registerRule() {

    }

    @Override
    public void unRegisterRule(Rule rule) {

    }

    @Override
    public void clearRules() {

    }

    @Override
    public Set<Rule> getRules() {
        return null;
    }
}
