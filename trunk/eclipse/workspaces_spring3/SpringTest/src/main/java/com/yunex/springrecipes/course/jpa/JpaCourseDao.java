package com.yunex.springrecipes.course.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.yunex.springrecipes.course.Course;
import com.yunex.springrecipes.course.CourseDao;

public class JpaCourseDao implements CourseDao {

	private EntityManagerFactory entityManagerFactory;
	
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
	
	public JpaCourseDao() {
		entityManagerFactory = Persistence.createEntityManagerFactory("course");
	}
	
	@Override
	public void store(Course course) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		
		try {
			tx.begin();
			manager.merge(course);
			tx.commit();
		}
		catch (RuntimeException e) {
			tx.rollback();
			throw e;
		}
		finally {
			manager.close();
		}
	}

	@Override
	public void delete(Long courseId) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		
		try {
			tx.begin();
			Course course = manager.find(Course.class, courseId);
			tx.commit();
		}
		catch (RuntimeException e) {
			tx.rollback();
			throw e;
		}
		finally {
			manager.close();
		}
	}

	@Override
	public Course findById(Long courseId) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		try {
			return manager.find(Course.class, courseId);
		}
		finally {
			manager.close();
		}
	}

	@Override
	public List<Course> findAll() {
		EntityManager manager = entityManagerFactory.createEntityManager();
		try {
			Query query = manager.createQuery("select course from Course course");
			return query.getResultList();
		}
		finally {
			manager.close();
		}
	}

}
