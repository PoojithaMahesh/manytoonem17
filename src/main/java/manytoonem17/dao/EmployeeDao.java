package manytoonem17.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytoonem17.dto.Company;
import manytoonem17.dto.Employee;

public class EmployeeDao {
public EntityManager getEntityManager() {
	return  Persistence.createEntityManagerFactory("vinod").createEntityManager();
}
	
public void saveEmployee(int companyId,Employee employee) {
	EntityManager entityManager=getEntityManager();
	Company dbCompany=entityManager.find(Company.class, companyId);
	if(dbCompany!=null) {
//		company is presenr
		employee.setCompany(dbCompany);
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
	
	}else {
		System.out.println("Company is not present");
	}
}

public void updateEmployee(int employeeId,Employee employee) {
	EntityManager entityManager=getEntityManager();
	Employee dbEmployee=entityManager.find(Employee.class, employeeId);
	if(dbEmployee!=null) {
//		id is present
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		
		employee.setId(employeeId);
		employee.setCompany(dbEmployee.getCompany());
		entityManager.merge(employee);
		entityTransaction.commit();
		
		
	}else {
		System.out.println("id is not present");
	}
}







}
