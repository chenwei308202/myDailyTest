package com.cw.demo.drools;

/**
 * 规则接口
 */
public interface PointRuleEngine {

    /**
     * 初始化规则引擎
     */
    public void initEngine()  ;

    /**
     * 刷新规则引擎
     */
    public void refreshEnginRule();

    /**
     * 执行规则引擎
     * @param pointDomain
     */
    public void executeRuleEngine(PointDomain pointDomain);



}
