package org.packt.spring;

import org.packt.spring.chapter6.hibernate.model.Employee;
import org.packt.spring.chapter6.hibernate.service.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHibernateMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/app-context.xml");
		EmployeeService employeeService = context.getBean("employeeServiceImpl", EmployeeService.class);
		
		Employee emp = new Employee();
		emp.setFirstName("Milos");
		emp.setLastName("Rajkovic");
		emp.setJobTitle("Java Developer");
		emp.setDepartment("Technology");
		emp.setSalary(3000);
		employeeService.insertEmployee(emp);
		
		for(Employee employee : employeeService.getAllEmployees())
			System.out.println(employee);
	}

}
