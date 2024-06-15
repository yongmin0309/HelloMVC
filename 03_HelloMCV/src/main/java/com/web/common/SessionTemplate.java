package com.web.common;
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.*;
public class SessionTemplate {
	public static SqlSession getSession() {
		SqlSession session=null;
		String fileName="mybatis-config.xml";
		try(InputStream is
				=Resources.getResourceAsStream(fileName);){
			session=new SqlSessionFactoryBuilder()
					.build(is).openSession(false);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return session;
	}
}
