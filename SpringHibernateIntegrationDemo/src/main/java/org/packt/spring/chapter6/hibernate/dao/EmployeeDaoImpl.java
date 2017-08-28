package org.packt.spring.chapter6.hibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.packt.spring.chapter6.hibernate.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String hql = "FROM Employee";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Employee> emList = query.list();
		return emList;
	}
	
	@Transactional(readOnly=false)
	public void insertEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.save(employee);
	}

}
