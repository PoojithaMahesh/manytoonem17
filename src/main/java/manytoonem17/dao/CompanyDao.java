package manytoonem17.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mysql.cj.xdevapi.DbDoc;

import manytoonem17.dto.Company;

public class CompanyDao {
	public EntityManager getEntityManager() {
		return  Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}
	
	public void saveCompany(Company company) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(company);
		entityTransaction.commit();
	}
	
	public void updateCompany(int companyId,Company company) {
		EntityManager entityManager=getEntityManager();
		Company dbCompany=entityManager.find(Company.class, companyId);
		if(dbCompany!=null) {
//			company is present
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			company.setId(companyId);
			entityManager.merge(company);
			entityTransaction.commit();
			
		}else {
			System.out.println("Id is not present");
		}
	}
	
	
	
}
