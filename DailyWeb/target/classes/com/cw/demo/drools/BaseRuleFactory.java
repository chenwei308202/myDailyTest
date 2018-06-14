package com.cw.demo.drools;

import org.drools.RuleBase;
import org.drools.RuleBaseFactory;

/**
 * 规则工厂
 *
 * @author chenwei
 * @create 2018-06-13 16:10
 **/

public class BaseRuleFactory {

    private static RuleBase ruleBase=null;

    public static RuleBase getRuleBase(){

        return ruleBase==null? RuleBaseFactory.newRuleBase():ruleBase;
    }

}
