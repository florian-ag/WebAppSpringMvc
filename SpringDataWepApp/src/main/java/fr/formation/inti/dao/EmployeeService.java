package fr.formation.inti.dao;

import java.util.List;
import java.util.Optional;

import fr.formation.inti.model.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public void deleteById(Integer id);
	
	public Employee saveOrUpdate(Employee emp);
	
	public Optional<Employee> findById(Integer id);
}
