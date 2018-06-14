package com.cw.demo.drools;

import org.drools.RuleBase;
import org.drools.StatefulSession;
import org.drools.compiler.PackageBuilder;

import java.io.File;
import java.io.FileReader;

/**
 * 规则接口实现类
 *
 * @author chenwei
 * @create 2018-06-13 14:56
 **/

public class PointRuleEngineImpl implements PointRuleEngine {

    private RuleBase ruleBase;

    @Override
    public void initEngine() {

        System.setProperty("drools.dateformat", "yyyy-MM-dd HH:mm:ss");


        ruleBase=BaseRuleFactory.getRuleBase();
        try {
            PackageBuilder backageBuilder=new PackageBuilder();

            backageBuilder.addPackageFromDrl(new FileReader(new File(this.getClass().getResource("addpoint.drl").getFile())));
            backageBuilder.addPackageFromDrl(new FileReader(new File(this.getClass().getResource("subpoint.drl").getFile())));
            if (backageBuilder.hasErrors()){
                System.out.println(backageBuilder.getErrors());
                throw new Exception("解析不到规则定义文件");
            }
            ruleBase.addPackages(backageBuilder.getPackages());

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void refreshEnginRule() {

    }

    @Override
    public void executeRuleEngine(PointDomain pointDomain) {
        if (ruleBase.getPackages() == null || ruleBase.getPackages().length==0){
            return;
        }

        StatefulSession statefulSession =ruleBase.newStatefulSession();
        statefulSession.insert(pointDomain);

        statefulSession.fireAllRules();
        statefulSession.dispose();

    }

    private void getPackageBuilderFromDrlFile(){



    }
}
