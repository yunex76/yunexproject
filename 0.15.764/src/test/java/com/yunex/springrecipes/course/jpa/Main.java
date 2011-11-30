package com.yunex.springrecipes.course.jpa;

import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yunex.springrecipes.course.Course;
import com.yunex.springrecipes.course.CourseDao;

public class Main {

	/**
	 * 돌릴때 hibernate.cfg.xml의 [하이버네이트 XML 매핑]부분을 주석처리
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans-jpa.xml");
		CourseDao courseDao = (CourseDao)context.getBean("courseDao");
		
		Course course = new Course();
		course.setTitle("Core Spring");
		course.setBeginDate(new GregorianCalendar(2007, 8, 1).getTime());
		course.setEndDate(new GregorianCalendar(2007, 9, 1).getTime());
		course.setFee(1000);
		courseDao.store(course);
		
		List<Course> courses = courseDao.findAll();
		Long courseId = courses.get(0).getId();
		
		course = courseDao.findById(courseId);
		System.out.println("Course Title: " + course.getTitle());
		System.out.println("Begin Date: " + course.getBeginDate());
		System.out.println("End Date: " + course.getEndDate());
		System.out.println("Fee: " + course.getFee());
		
		courseDao.delete(courseId);
	}

}
