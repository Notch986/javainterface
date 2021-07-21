package com.javabydeveloper;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.javabydeveloper.domain.Paciente;

public class App {

	public static void main(String[] args) {

		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		try {
			emf = Persistence.createEntityManagerFactory("jbd-pu");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			Paciente p = new Paciente();
			p.setPnames("John");


			entityManager.persist(p);

			transaction.commit();

			Query q = entityManager.createQuery("select s from Pac s");

			List<Paciente> resultList = q.getResultList();
			System.out.println("num of sudents:" + resultList.size());
			for (Paciente next : resultList) {
				System.out.println("next student: " + next);
			}

		} catch (Exception e) {
			System.out.println(e);
			transaction.rollback();
		} finally {
			entityManager.close();
			emf.close();
		}
	}
}
