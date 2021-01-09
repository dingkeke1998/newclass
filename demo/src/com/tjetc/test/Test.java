package com.tjetc.test;

import java.io.IOException;
import java.io.Reader;
import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.tjetc.dao.BooksDAO;
import com.tjetc.dao.PassportsDAO;
import com.tjetc.dao.PeoplesDAO;
import com.tjetc.dao.PressesDAO;
import com.tjetc.dao.UserDAO;
import com.tjetc.domain.Books;
import com.tjetc.domain.Passports;
import com.tjetc.domain.Peoples;
import com.tjetc.domain.Presses;
import com.tjetc.domain.User;



public class Test {
public static void main(String[] args) throws IOException {
 String resource = "mybatis-config.xml";
 Reader reader = Resources.getResourceAsReader(
			Test.class.getClassLoader(), resource);
 SqlSessionFactory sessionFactory  = new SqlSessionFactoryBuilder().build(reader);
 SqlSession session =sessionFactory.openSession();
 BooksDAO booksDAO = session.getMapper(BooksDAO.class);
 List<Books> list= booksDAO.findAll();
 for (Books books : list) {
	System.out.println(books.toString());
}
 session.close();
}
}
