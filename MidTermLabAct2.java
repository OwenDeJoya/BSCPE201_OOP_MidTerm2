import java.util.ArrayList;
import java.util.Scanner;

class DeJoyaMidTerm2 {
	private int id;
	private String name;
	private double rate;
    private String birthday;
	private String address;
	private String position;
	
	
	public DeJoyaMidTerm2 (final int id, final String name, final double rate, final String birthday, final String address, final String position) {
		this.id = id;
		this.name = name;
		this.rate = rate;
		this.birthday = birthday;
		this.address = address;
		this.position = position;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setRate(final Double rate) {
		this.rate = rate;
	}
	
	public void setBirthday(final String birthday) {
		this.birthday = birthday;
	}
	
	public void setAddress(final String address) {
		this.address = address;
	}
	
	public void setPosition(final String position) {
		this.position = position;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getRate() {
		return rate;
	}
	public String getBirthday() {
		return birthday;
	}
	public String getAddress() {
		return address;
	}
	public String getPosition() {
		return position;
	}
}

class Test {
	public static void main(final String[] args) {
		final ArrayList<DeJoyaMidTerm2> employees = new ArrayList<DeJoyaMidTerm2>();
		final Scanner scan = new Scanner(System.in);
		int id = 0;
		boolean exit = false;
		DeJoyaMidTerm2 e;
		
		do {
			System.out.println("Select Activity: ");
			System.out.println("1. Add Employee");
			System.out.println("2. Display all Employees");
			System.out.println("3. Update Employee");
			System.out.println("4. Delete Employee");
			System.out.println("5. Exit Console");

			System.out.print("Option: ");
			final int option = scan.nextInt();
			
			switch(option) {
				case 1: 
					int last_id = employees.isEmpty() ? 0 : 1 + employees.get(employees.size() - 1).getID();
					System.out.print(last_id);
					employees.add(addEmployee(last_id)); 
				break;
				case 2: displayEmployees(employees); break;
				case 3: 
					System.out.print("Enter Employee ID: ");
					id = scan.nextInt();
					e = searchEmployee(id, employees);
					if(e == null) {
						System.out.println("Could not find Employee.");
					} else {
						DeJoyaMidTerm2(e);
					}
				break;
				case 4: 
					System.out.print("Enter Employee ID: ");
					id = scan.nextInt();
					e = searchEmployee(id, employees);
					if(e == null) {
						System.out.println("Could not find Employee.");
					} else {
						employees.remove(e);
					}
				break;
				case 5: exit = true; break;
			}
		} while(!exit);
		scan.close();
	}

	public static DeJoyaMidTerm2 addEmployee(final int last_id) {
		final Scanner scan = new Scanner(System.in);
		System.out.print("Enter Employee Name: ");
		final String name = scan.nextLine();
		System.out.print("Enter Employee Birthday: ");
		final String birthday = scan.nextLine();
		System.out.print("Enter Employee Address: ");
		final String address = scan.nextLine();
		System.out.print("Enter Employee Position: ");
		final String position = scan.nextLine();
		System.out.print("Enter Employee Rate: ");
		final double rate = scan.nextDouble();
		return new DeJoyaMidTerm2(last_id, name, rate, birthday, address, position);
	}

	public static void DeJoyaMidTerm2(final DeJoyaMidTerm2 employee) {
		final Scanner scan = new Scanner(System.in);
		System.out.println("Select Field to Update: ");
		System.out.println("1. Name");
		System.out.println("2. Birthday");
		System.out.println("3. Address");
		System.out.println("4. Position");
		System.out.println("5. Rate");
		System.out.print("Option: ");
		final int option = scan.nextInt();
		
		System.out.print("Enter new value: ");
		String update = scan.next();
		switch(option) {
			case 1: employee.setName(update); break;
			case 2: employee.setBirthday(update); break;
			case 3: employee.setAddress(update); break;
			case 4: employee.setPosition(update); break;
			case 5: employee.setRate(Double.parseDouble(update)); break;
	
			
		}

	}

	public static DeJoyaMidTerm2 searchEmployee(final int id, final ArrayList<DeJoyaMidTerm2> employees) {
		for (final DeJoyaMidTerm2 employee : employees) {
			if (employee.getID() == id) {
				return employee;
			}
		}
		return null;
	}

	public static void displayEmployees(final ArrayList<DeJoyaMidTerm2> employees) {
		if (employees.isEmpty()) {
			System.out.println("Cannot find employee record.");
			return;
		}
		System.out.println("List of Employees:");
		for (final DeJoyaMidTerm2 employee : employees) {
			System.out.println("ID: " + employee.getID() + ", Name: " + employee.getName() + ", Rate: " + employee.getRate()
				+ ", Birthday: " + employee.getBirthday()+ ", Address: " + employee.getAddress()+ ", Position: " + employee.getPosition());
		}
	}
}


