package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	private Department department;//Um funcionario tem um departamento
	private List<HourContract> contracts = new ArrayList<>();//Um funcionario pode ter varios contratos
	
	public Worker() {
		
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}
	
	public void addContract(HourContract contract) {
		
		contracts.add(contract);
		//Vai adicionar a lista o contrato passado como parametro!
		//'contracts' é nome que foi dado a lista e contract é nome do parametro que vai ser passado para a lista
	}
	
	public void removeContract(HourContract contract) {
		
		contracts.remove(contract);
		//Vai remover da lista o contrato passado como parametro!
		//'contracts' é nome que foi dado a lista e contract é nome do parametro que vai ser passado para a lista
	}
	
	public Double income(int year,int month) {
		
		//Salario base + o valor dos contratos
		
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();//Usado para manipular Data de forma livre, fica mais facil de moldar
		
		for (HourContract c : contracts) {
			cal.setTime(c.getDate());//A data do contrato vai ser a data do calendario
			int c_year = cal.get(Calendar.YEAR);//Vai ser o ano do contrato 'c'
			int c_month = 1+cal.get(Calendar.MONTH);//Vai ser o mes do contrato
			
			if (year == c_year && month == c_month) {//Vai verificar se o contrato é do mes e do ano especificado no parametro se for entra na soma
				
				sum += c.totalValue();
				
			}
		}
		
		return sum;
	}

}
