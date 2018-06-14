package com.cw.demo.drools;

/**
 * 积分领域模型
 *
 * @author chenwei
 * @create 2018-06-13 14:48
 **/

public class PointDomain {
    //用户名
    private String userName;
    //是否生日
    private boolean birthDay;
    //积分
    private long point;
    //当月购买次数
    private int buyNums;
    //当月退货次数
    private int backNums;
    //当月购物总金额
    private double buyMoney;
    //当月退货总金额
    private double backMoney;
    //当月信用卡还款次数
    private int billThisMonth;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isBirthDay() {
        return birthDay;
    }

    public void setBirthDay(boolean birthDay) {
        this.birthDay = birthDay;
    }

    public long getPoint() {
        return point;
    }

    public void setPoint(long point) {
        this.point = point;
    }

    public int getBuyNums() {
        return buyNums;
    }

    public void setBuyNums(int buyNums) {
        this.buyNums = buyNums;
    }

    public int getBackNums() {
        return backNums;
    }

    public void setBackNums(int backNums) {
        this.backNums = backNums;
    }

    public double getBuyMoney() {
        return buyMoney;
    }

    public void setBuyMoney(double buyMoney) {
        this.buyMoney = buyMoney;
    }

    public double getBackMoney() {
        return backMoney;
    }

    public void setBackMoney(double backMondy) {
        this.backMoney = backMondy;
    }

    public int getBillThisMonth() {
        return billThisMonth;
    }

    public void setBillThisMonth(int billThisMonth) {
        this.billThisMonth = billThisMonth;
    }


    public void recordPointLog(String userName,String type){
        System.out.println("该用户 "+userName+ " 类型 "+ type+" 的操作");
    }

    @Override
    public String toString() {
        return "PointDomain{" +
                "userName='" + userName + '\'' +
                ", birthDay=" + birthDay +
                ", point=" + point +
                ", buyNums=" + buyNums +
                ", backNums=" + backNums +
                ", buyMoney=" + buyMoney +
                ", backMoney=" + backMoney +
                ", billThisMonth=" + billThisMonth +
                '}';
    }
}
