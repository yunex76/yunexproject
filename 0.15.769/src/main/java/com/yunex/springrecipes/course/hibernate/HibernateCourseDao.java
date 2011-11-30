package com.yunex.springrecipes.course.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.yunex.springrecipes.course.Course;
import com.yunex.springrecipes.course.CourseDao;

public class HibernateCourseDao implements CourseDao {

	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public HibernateCourseDao() {

	}

	@Transactional
	public void store(Course course) {
		hibernateTemplate.saveOrUpdate(course);
	}

	@Transactional
	public void delete(Long courseId) {
		Course course = (Course)hibernateTemplate.get(Course.class, courseId);
		hibernateTemplate.delete(course);
	}

	@Transactional(readOnly = true)
	public Course findById(Long courseId) {
		return (Course)hibernateTemplate.get(Course.class, courseId);
	}

	@Transactional(readOnly = true)
	public List<Course> findAll() {
		return hibernateTemplate.find("from Course");
	}

}
