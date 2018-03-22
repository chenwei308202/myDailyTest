package com.cw.demo.fenbiao.user.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cw.demo.fenbiao.datasource.DataSourceThreadLocal;
import com.cw.demo.fenbiao.datasource.HashUtils;
import com.cw.demo.fenbiao.user.dao.UserDao;
import com.cw.demo.fenbiao.user.model.User;
import com.cw.demo.fenbiao.user.model.UserInfo;
import com.cw.demo.fenbiao.user.service.UserService;




@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	private String [] xingArr={"赵","钱","孙","李","周","吴","郑","王","冯",
			"蒋","沈","韩","杨","朱","秦","尤","许","何",
			"孔","曹","严","华","金","魏","陶","姜","戚",
			"柏","水","窦","章","云","苏","潘","葛","奚",
			"鲁","韦","昌","马","苗","凤","花","方","俞",
			"酆","鲍","史","唐","费","廉","岑","薛","雷",
			"滕","殷","罗","毕","郝","邬","安","常","乐",
			"皮","卞","齐","康","伍","余","元","卜","顾",
			"和","穆","萧","尹","姚","邵","湛","汪","祁",
			"米","贝","明","臧","计","伏","成","戴","谈",
			"熊","纪","舒","屈","项","祝","董","梁","杜",
			"席","季","麻","强","贾","路","娄","危","江",
			"梅","盛","林","刁","锺","徐","邱","骆","高",
			"樊","胡","凌","霍","虞","万","支","柯","昝",
			"经","房","裘","缪","干","解","应","宗","丁",
			"郁","单","杭","洪","包","诸","左","石","崔",
			"程","嵇","邢","滑","裴","陆","荣","翁","荀",
			"甄","麴","家","封","芮","羿","储","靳","汲",
			"井","段","富","巫","乌","焦","巴","弓","牧"};
	
	private String [] nameArr={
			"的","一","是","在","不","了","有","和","人","这","中","大","为","上","个","国","我","以","要","他",
			"时","来","用","们","生","到","作","地","于","出","就","分","对","成","会","可","主","发","年","动",
			"同","工","也","能","下","过","子","说","产","种","面","而","方","后","多","定","行","学","法","所",
			"民","得","经","十","三","之","进","着","等","部","度","家","电","力","里","如","水","化","高","自",
			"值","号","率","族","维","划","选","标","写","存","候","毛","亲","快","效","斯","院","查","江","型",
			"眼","王","按","格","养","易","置","派","层","片","始","却","专","状","育","厂","京","识","适","属",
			"圆","包","火","住","调","满","县","局","照","参","红","细","引","听","该","铁","价","严","龙","飞","陈"
	};
			
	
	public User getUserById(int id) {
		
		return userDao.selectOne(id);
	}

	public boolean batchAddUser(int i){
		
		try {
			User user=null;
			List<User> users=new LinkedList<User>();
				
				for (int j = 0; j < i; j++) {
					
					user=new User();
					user.setAge(new Random().nextInt(100));
					user.setUsername(xingArr[new Random().nextInt(i)%xingArr.length] +nameArr[new Random().nextInt(i)%nameArr.length]+(new Random().nextBoolean()?nameArr[new Random().nextInt(i)%nameArr.length]:""));
					user.setPassword("123456");
					users.add(user);
				userDao.batchInsert(users);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	public boolean batchAddUserPerTable(int i){
		
		try {
			UserInfo user=null;
			for (int j = 0; j < i; j++) {
				
				user=new UserInfo();
				user.setId(UUID.randomUUID().toString().replaceAll("-", ""));
				user.setAge(new Random().nextInt(100));
				user.setUsername(xingArr[new Random().nextInt(i)%xingArr.length] +nameArr[new Random().nextInt(i)%nameArr.length]+(new Random().nextBoolean()?nameArr[new Random().nextInt(i)%nameArr.length]:""));
				user.setPassword("123456");
				
				String id= user.getId();
				int tId=HashUtils.getHashCode(id, 5);
				DataSourceThreadLocal.setSignal(tId);
				user.setTid(tId);
				userDao.batchInsertPerTable(user);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public static void main(String[] args) {
		String idString="17efdea32a17461a8e44090b441a8989";
		int code=idString.hashCode();
		System.out.println( idString.hashCode());
		System.out.println(code%5);
	}
}
