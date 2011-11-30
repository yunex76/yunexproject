package com.yunex.springrecipes.course.jpa;

import java.util.List;

import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.yunex.springrecipes.course.Course;
import com.yunex.springrecipes.course.CourseDao;

public class JpaCourseDao implements CourseDao {

	private JpaTemplate jpaTemplate;
	
	public void setJpaTemplate(JpaTemplate jpaTemplate) {
		this.jpaTemplate = jpaTemplate;
	}
	
	public JpaCourseDao() {

	}
	
	@Transactional
	public void store(Course course) {
		jpaTemplate.merge(course);
	}

	@Transactional
	public void delete(Long courseId) {
		Course course = jpaTemplate.find(Course.class, courseId);
		jpaTemplate.remove(course);
	}

	@Transactional(readOnly = true)
	public Course findById(Long courseId) {
		return jpaTemplate.find(Course.class, courseId);
	}

	@Transactional(readOnly = true)
	public List<Course> findAll() {
		return jpaTemplate.find("from Course");
	}

}
