package application;

import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws HeadlessException, ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String departmentName = JOptionPane.showInputDialog("Enter departament's name: ");
		String workerName = JOptionPane.showInputDialog("Name: ");
		String workerLevel = JOptionPane.showInputDialog("Level: ");
		Double baseSalary = Double.parseDouble(JOptionPane.showInputDialog("Base salary: "));
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		//Vai receber os dados do trabalhador
		int n = Integer.parseInt(JOptionPane.showInputDialog("How many contracts to this Worker? "));
		
		for (int i = 1; i <= n; i++) {
			Date contractDate = sdf.parse(JOptionPane.showInputDialog("Enter Date Contract dd/MM/yyyy"));
			double valuePerHour = Double.parseDouble(JOptionPane.showInputDialog("Value per Hour: "));
			int hours = Integer.parseInt(JOptionPane.showInputDialog("Hours"));

			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			//Vai receber os dados do contrato
			
			worker.addContract(contract);
			//Vai adicionar os dados do contrato na lista

		}
		
		String monthAndYear = JOptionPane.showInputDialog("Enter month and year to calculator income (MM/YYYY)");
		int month = Integer.parseInt(monthAndYear.substring(0,2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println("Name: "+worker.getName());
		System.out.println("Department: "+worker.getDepartment().getName());
		System.out.println("Worker Level: "+worker.getLevel());
		
		System.out.println("Income: "+monthAndYear+" : "+worker.income(year, month));
		//Vai passar o ano e o mes para serem verificados no income
		

	}

}
