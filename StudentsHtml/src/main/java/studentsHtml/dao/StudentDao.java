package studentsHtml.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import studentsHtml.dto.Student;

public class StudentDao {

		public Student saveStudent(Student student) {
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(student);
			entityTransaction.commit();
			
			return student;
			
		}

		public List<Student> getAllStudents() {
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			Query query=entityManager.createQuery("Select s from Student s");
			return query.getResultList();
		}

		public Student deleteStudent(int id) {
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			Student dbStudent=entityManager.find(Student.class, id);
			if(dbStudent!=null) {
				entityTransaction.begin();
				entityManager.remove(dbStudent);
				entityTransaction.commit();
				return dbStudent;
			}
			else {
				return null;
			}
			
		}

		public Student findStudent(int id) {
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			Student dbStudent=entityManager.find(Student.class, id);
			if(dbStudent!=null) {
				return dbStudent;
			}
			else {
			
			return null;
			}
		}

		public Student updateStudent(int id,Student student) {
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			Student dbStudent=entityManager.find(Student.class, id);
			if(dbStudent!=null) {
				EntityTransaction entityTransaction=entityManager.getTransaction();
				entityTransaction.begin();
				student.setId(id);
				entityManager.merge(student);
				entityTransaction.commit();
				return dbStudent;
			}
			else {
			return null;
			}
		}
	}

