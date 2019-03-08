package iov.spring.test;

import iov.spring.dao.DeviceMapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");  
KJFDJFKSDJFKJDS
	    
	        SqlSessionTemplate sqlSession =  (SqlSessionTemplate) context.getBean("sqlSessionTemplate");  
	        
		Test test=new Test();
		
		
	JKJDFKLJSDKLFJKLSJ	
		
		

		String a=DeviceMapper.class.getName()+".selectByPrimaryKey";
		System.out.println("name is ---"+sqlSession);
		
		  List   list=  sqlSession.selectList(a);
		
		  System.out.println("-----"+list.size());
		  
		  
		
		
	}
	
	
}
