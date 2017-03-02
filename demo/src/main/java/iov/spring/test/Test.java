package iov.spring.test;

import iov.spring.dao.DeviceMapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

//	@Autowired
//	 SqlSessionTemplate sqlSession;
//	public SqlSession getSqlSession() {
//		System.out.println("11111111111"+sqlSession);
//		return sqlSession;
//		
//	}
//
//	public void setSqlSession(SqlSessionTemplate sqlSession) {
//		System.out.println("00000000000");
//		this.sqlSession = sqlSession;
//	}
//	
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");  
		  
	        context.start();  
	    
	        SqlSessionTemplate sqlSession =  (SqlSessionTemplate) context.getBean("sqlSessionTemplate");  
	        
		Test test=new Test();
		
		
		
		
		

		String a=DeviceMapper.class.getName()+".selectByPrimaryKey";
		System.out.println("name is ---"+sqlSession);
		
		  List   list=  sqlSession.selectList(a);
		
		  System.out.println("-----"+list.size());
		  
		  
		
		
	}
	
	
}
