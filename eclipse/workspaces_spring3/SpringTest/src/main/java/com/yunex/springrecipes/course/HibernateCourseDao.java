package com.yunex.springrecipes.course;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateCourseDao implements CourseDao {

	private SessionFactory sessionFactory;
	
	public HibernateCourseDao() {
		// 하이버네이트 XML 매핑
		// Configuration configuration = new Configuration().configure();
		
		// JPA 애노테이션
		Configuration configuration = new AnnotationConfiguration().configure();
		
		sessionFactory = configuration.buildSessionFactory();
	}
	
	public void store(Course course) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.saveOrUpdate(course);
			tx.commit();
		}
		catch (RuntimeException e) {
			tx.rollback();
			throw e;
		}
		finally {
			session.close();
		}
	}

	public void delete(Long courseId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			Course course = (Course)session.get(Course.class, courseId);
			session.delete(course);
			tx.commit();
		}
		catch (RuntimeException e) {
			tx.rollback();
			throw e;
		}
		finally {
			session.close();
		}
	}

	public Course findById(Long courseId) {
		Session session = sessionFactory.openSession();
		try {
			return (Course)session.get(Course.class, courseId);
		}
		finally {
			session.close();
		}
	}

	public List<Course> findAll() {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from Course");
			return query.list();
		}
		finally {
			session.close();
		}
	}

}
