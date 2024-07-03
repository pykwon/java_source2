package controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.DataDao;
import model.DataDaoImpl;

public class ServiceMain {
	public static void main(String[] args) {
		// 전통적 방법
		// DB 처리 객체 생성
		DataDaoImpl impl = new DataDaoImpl();
		DataDao dataDao = impl;
		
		// BL 관련 객체 생성
		ProcessServiceImpl serviceImpl = new ProcessServiceImpl(dataDao);
		ProcessService processService = serviceImpl;
		processService.selectProcess();
		
		System.out.println("----------");
		// Spring 방법
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("init.xml");
		ProcessService processService2 = 
				(ProcessService)context.getBean("serviceImpl");
		processService2.selectProcess();
	}

}
