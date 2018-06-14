package com.cw.demo.engine;

import java.util.Set;

/**
 * g规则引擎
 */
public interface RuleEngine {

    void registerRule();

    void unRegisterRule(Rule rule);

    void clearRules();

    Set<Rule> getRules();


}
