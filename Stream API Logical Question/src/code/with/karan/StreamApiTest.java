package code.with.karan;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamApiTest {

	public static void main(String[] args) {

		List<Employee> listOfEmp = new ArrayList<Employee>();
		listOfEmp.add( new Employee(123,"karan",50000, 100, "active"));
		listOfEmp.add( new Employee(124,"vivek",60000, 200, "inactive"));
		listOfEmp.add( new Employee(123,"raja",50000, 300, "active"));
		listOfEmp.add( new Employee(125,"meera",40000, 200, "active"));
		listOfEmp.add( new Employee(126,"peter",90000, 100, "active"));

		//Q1) WAP to print employee details working in each department.		
		Map<Integer, List<Employee>> detailsOfEmp = listOfEmp.
				stream().collect(Collectors.
						groupingBy(Employee::getDepNo ,Collectors.toList()));

		//System.out.println(detailsOfEmp);
		detailsOfEmp.entrySet().forEach(e -> {
			System.out.println(e.getKey()+"  "+e.getValue());
		});

		//Q2) WAP to print employee count working in each department.

		Map<Integer, Long> countOfEmp = listOfEmp.stream()
				.collect(Collectors.
						groupingBy(Employee::getDepNo,Collectors.counting()));
		countOfEmp.entrySet().forEach(e -> {
			System.out.println(e.getKey()+"  "+e.getValue());
		});

		//Q3) WAP to print active and inactive employee details working in each department or in a collection.

		List<Employee> listOfActiveEmp = listOfEmp.stream().
				filter(e -> "active".equals(e.getStatus()))
				.collect(Collectors.toList());
		System.out.println(listOfActiveEmp);

		List<Employee> listOfInActiveEmp = listOfEmp.stream().
				filter(e -> "inactive".equals(e.getStatus()))
				.collect(Collectors.toList());
		System.out.println(listOfInActiveEmp);


		Optional<Employee> maxSalEmp = listOfEmp.stream().max(Comparator.comparing(Employee::getSal));
		System.out.println(maxSalEmp);

		Optional<Employee> minSalEmp = listOfEmp.stream().min(Comparator.comparing(Employee::getSal));
		System.out.println(minSalEmp);

		Map<Integer, Optional<Employee>> maxSalEmpInDep = listOfEmp.stream().collect(Collectors.groupingBy(Employee::getDepNo,Collectors.
				maxBy(Comparator.comparing(Employee::getSal))));
		System.out.println(maxSalEmpInDep);

	}//main
}//class
