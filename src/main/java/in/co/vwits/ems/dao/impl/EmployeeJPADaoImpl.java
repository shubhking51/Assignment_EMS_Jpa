package in.co.vwits.ems.dao.impl;
import java.util.List;
import java.util.Optional;
import in.co.vwits.ems.dao.EmployeeDao;
import in.co.vwits.ems.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
public class EmployeeJPADaoImpl implements EmployeeDao{
private EntityManagerFactory factory;
	
	public EmployeeJPADaoImpl(){
		factory= Persistence.createEntityManagerFactory("emsapp");
	}
	
	//save method
	@Override
	public int save(Employee s) {
		// TODO Auto-generated method stub
		EntityManager  em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(s); 
		tx.commit();
		em.close();
		return 1;
		
	}
	
	//Find by employee id
	public Optional<Employee> findByEmpId(int empId) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Employee s = em.find(Employee.class, empId); //This fires select query.
		tx.commit();
		em.close();
		return Optional.of(s);
		
	}
	//Find all
	@Override
	public List<Employee> findAll() {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		String jpql="FROM Employee";
		TypedQuery<Employee> query = em.createQuery(jpql,Employee.class);
		List<Employee> employeeList = query.getResultList();
		tx.commit();
		em.close();
		return employeeList;
	}
	
	// Delete employee by their employee id
	@Override
	public void deleteByEmpId(int empId) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Employee.class, empId)); 
		tx.commit();
		em.close();
		
	}
	
	//update 
	/*
	 * public void updateByRollno(int empId, double modifiedSalary) { // TODO
	 * Auto-generated method stub EntityManager em = factory.createEntityManager();
	 * EntityTransaction tx = em.getTransaction(); tx.begin(); Employee s= new
	 * Employee(); s.setId(empId); s.setSalary(modifiedSalary); em.merge(s); //this
	 * fires update query tx.commit(); em.close();
	 * }
	 */
	
	public void updateSalary(Employee s) {
		// TODO Auto-generated method stub
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();		
		em.merge(s); //this fires update query 
		tx.commit();
		em.close();
	}
	
	@Override
	public List<Employee> findAllEmployeesSortedByName() {
		// TODO Auto-generated method stub
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		String jpql="FROM Employee ORDER BY name";
		TypedQuery<Employee> query = em.createQuery(jpql,Employee.class);
		List<Employee> employeeList = query.getResultList();
		tx.commit();
		em.close();
		return employeeList;
	
	}
	@Override
	public List<Employee> findAllEmployeesSortedBySalary() {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		String jpql="FROM Employee ORDER BY salary";
		TypedQuery<Employee> query = em.createQuery(jpql,Employee.class);
		List<Employee> employeeList = query.getResultList();
		tx.commit();
		em.close();
		return employeeList;
	}

	/*public void updateSalaryByEmpId(int empId, double modifiedSalary) {
		// TODO Auto-generated method stub
		
	}
*/
}



