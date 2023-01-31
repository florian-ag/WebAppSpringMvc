package fr.formation.inti.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository daoEmployee;

	@Override
	public List<Employee> findAll() {
		return daoEmployee.findAll();
	}

	public void deleteById(Integer id) {
		daoEmployee.deleteById(id);
		
	}

	@Override
	public Employee saveOrUpdate(Employee emp) {
		daoEmployee.save(emp);
		return emp;
	}

	@Override
	public Optional<Employee> findById(Integer id) {
		return daoEmployee.findById(id);
	}


}
