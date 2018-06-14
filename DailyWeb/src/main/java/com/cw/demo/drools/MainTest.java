package com.cw.demo.drools;

/**
 * @author chenwei
 * @create 2018-06-14 11:33
 **/

public class MainTest {


    public static void main(String[] args) {

        PointRuleEngine pointRuleEngine=new PointRuleEngineImpl();
        pointRuleEngine.initEngine();

        PointDomain pointDomain=new PointDomain();
        pointDomain.setUserName("陈伟");
        pointDomain.setBackMoney(100d);
        pointDomain.setBuyMoney(500d);
        pointDomain.setBackNums(1);
        pointDomain.setBuyNums(5);
        pointDomain.setBillThisMonth(5);
        pointDomain.setBirthDay(true);
        pointDomain.setPoint(0);


        pointRuleEngine.executeRuleEngine(pointDomain);

        System.out.println(pointDomain.toString());


    }

}
