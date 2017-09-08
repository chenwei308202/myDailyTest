package com.cw.fanshe.validate.domain;

public enum BankEnum {
	
	
	GDYH("CEB","光大银行"),
	NYYH("ABC","农业银行"),
	GSYH("ICBC","工商银行"),
	JSYH("CCB","建设银行"),
	MSYH("CMBC","民生银行"),
	YZCXYH("PSBC","邮政储蓄银行"),
	ZGYH("BOC","中国银行"),
	XYYH("CIB","兴业银行"),
	ZSYH("CMB","招商银行");
	
	BankEnum(String bankCode,String bankDesc){
		this.bankCode=bankCode;
		this.bankDesc=bankDesc;
	}
	
	public static String getDescByCode(String bankCode){
		for(BankEnum bank : BankEnum.values()){
            if(bank.bankCode.equals(bankCode)){
                return bank.bankDesc;
            }
        }
		
		return bankCode;
	}
	
	
	private String bankCode;
	
	
	private String bankDesc;
	
	
}
