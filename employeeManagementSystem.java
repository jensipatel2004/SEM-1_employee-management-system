import java.util.Scanner;
import java.util.Date;
import java.util.InputMismatchException;
import java.text.SimpleDateFormat;


class Employee {
    int id;
    String name;
    int age;
    String phoneNumber;
    String emailAddress;
    String position;
    double salary;
    String type;
    String joiningDate;
    String resigningDate;
    Employee next;

    public Employee(int id,String name,int age,String phoneNumber,String emailAddress,String position,double salary,String type,String joiningDate,String resigningDate) {
        this.id = id;
        this.name=name;
        this.age=age;
        this.phoneNumber=phoneNumber;
        this.emailAddress=emailAddress;
        this.position=position;
        this.salary=salary;
        this.type=type;
        this.joiningDate=joiningDate;
        this.resigningDate=resigningDate;
        this.next = null;
    }
        // Getters and setters
    public int getEmployeeID() {
        return id;
    }

    public void setEmployeeID(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMobileNumber() {
        return phoneNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.phoneNumber = mobileNumber;
    }

    public String getEmail() {
        return emailAddress;
    }

    public void setEmail(String email) {
        this.emailAddress = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getResigningDate() {
        return resigningDate;
    }

    public void setResigningDate(String resigningDate) {
        this.resigningDate = resigningDate;
    }
}



class EmployeeList {
    Employee head;

    // method for insert employee
    public void addLast(int id, String name,int age,String phoneNumber,String emailAddress,String position,double salary,String type,String joiningDate,String resigningDate) {
       
        Employee newEmployee = new Employee(id, name,age,phoneNumber,emailAddress,position,salary,type,joiningDate,resigningDate);
        if (head == null) {
            head = newEmployee;
        } else {
            Employee current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newEmployee;
        }
        System.out.println("Employee added at the end: " + name);
   
    }  

    // method for stepwise print employee
    public void stepwisePrint(int n) {
        int counter=0;
        Employee current = head;
        System.out.println("Stepwise Employee List:");
        while (current != null) {
            if(counter % n == 0){
            System.out.print("ID: " + current.id + ", Name: " + current.name + "--> ");
            }
            counter++;
            current = current.next;
        }
        System.out.println("null");
    }

    // method for resign employee
    public void resignEmployee(int id)
    {
    if(head==null){
        System.out.println("Employee list is empty.");
        
    }
    Employee current=head;

    while(current!=null){       
        if (current.getEmployeeID() == id) {
                 
                Scanner sc = new Scanner(System.in);
		        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		        boolean isValidDateFormat = false;
		        String resigningDate;
				// Set Employee type as "Resign"
                current.setType("Resign");

                // Get input of Employee Resigning Date
				do {
					System.out.println("Enter resigning date of employee (Format should be 'dd-MM-yyyy')");
					resigningDate = sc.nextLine();
					try {
						Date formatDate = dateFormat.parse(resigningDate);
						if (resigningDate.equals(dateFormat.format(formatDate))) {
							isValidDateFormat = true;
						} else {
							System.out.println("Date is not in the correct format. Correct format is dd-MM-yyyy");
						}
					} catch (Exception e) {
						System.out.println("Invalid date format!");
					}
				} while (!isValidDateFormat);
                if (!resigningDate.isEmpty()) {
                    current.setResigningDate(resigningDate);
                }

                System.out.println("Employee with id:" + id + " (" + current.name + ") has resigned on" + current.resigningDate);
                
               }
               current=current.next;
               
            }
           
    }

    // method for modify employee details        
    public void update(int id) {
        Employee current = head;
        while (current != null && current.id != id) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Employee with ID " + id + " not found.");
            return;
        }
        
                Scanner sc = new Scanner(System.in);
		        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		        boolean isValidDateFormat = false;
		        String joiningDate;

               // enter id to update employee data
                if (current.getEmployeeID() == id) {
                // Get input of update employee name    
                System.out.println("Enter new employee name (or press Enter to skip):");
                String newName = sc.nextLine();
                if (!newName.isEmpty()) {
                    current.setName(newName);
                }

                // Get input of update employee age
                System.out.println("Enter new employee age (or press Enter to skip):");
                String newAge=sc.nextLine();
                if (!newAge.isEmpty()) {
                    int e_age=Integer.parseInt(newAge);
                    current.setAge(e_age);
                }

                // Get input of update Employee Contact Details (Mobile number)
                boolean isValidNumber = false;
					String contactNumber = "";
					do {
						System.out.println("Enter new employee mobile number(number between 0 to 9) (or press enter to skip):");
						contactNumber = sc.nextLine();
						try {
							if (contactNumber.matches("[0-9]+")) {
								if (contactNumber.length() == 10) {
									isValidNumber = true;
								} else {
									System.out.println("Mobile number should be 10 digits long!");
								}
							} else {
								System.out.println("Invalid Mobile number format!");
							}
						} catch (NumberFormatException e) {
							System.out.println("Invalid mobile number format!");
						}
					} while (!isValidNumber);
                if (!contactNumber.isEmpty()) {
                    current.setMobileNumber(contactNumber);
                }

                // Get input of update Employee Contact Details (Email ID)
                boolean isValidEmail = false;
					String emailAddress = "";
					do {
						System.out.println("Enter employee email(format: a@a.com) (or press Enter to skip): ");
						try {
							emailAddress = sc.nextLine();
							if (emailAddress.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
								isValidEmail = true;
							} else {
								System.out.println("Invalid email address format!");
							}
						} catch (Exception e) {
							System.out.println("Invalid email address format!");
							sc.nextLine(); // clear the input buffer
						}
					} while (!isValidEmail);
                if (!emailAddress.isEmpty()) {
                    current.setEmail(emailAddress);
                }

                // Get input of update Employee Designation/Position
                System.out.println("Enter new employee position (or press Enter to skip):");
                String e_position = sc.nextLine();
                if (!e_position.isEmpty()) {
                    current.setPosition(e_position);
                }

                // Get input of update Employee Payroll details
                System.out.println("Enter new employee salary (or press Enter to skip):");
                String salaryString = sc.nextLine();
                if (!salaryString.isEmpty()) {
                    double e_salary = Double.parseDouble(salaryString);
                    current.setSalary(e_salary);
                }

                // Get input of update Employee Type
                System.out.println("Enter new employee type (or press Enter to skip):");
                String e_type = sc.nextLine();
                if (!e_type.isEmpty()) {
                    current.setType(e_type);
                }

                 // Get input of update Employee Joining Date
                do {
					System.out.println("Enter new revised updated joining date of employee (Format should be 'dd-MM-yyyy') (or press Enter to skip)");
					joiningDate = sc.nextLine();
					try {
						Date formatDate = dateFormat.parse(joiningDate);
						if (joiningDate.equals(dateFormat.format(formatDate))) {
							isValidDateFormat = true;
						} else {
							System.out.println("Date is not in the correct format. Correct format is dd-MM-yyyy");
						}
					} catch (Exception e) {
						isValidDateFormat = true;
					}
				} while (!isValidDateFormat);
                if (!joiningDate.isEmpty()) {
                    current.setJoiningDate(joiningDate);
                }
        
            }
            else{
                System.out.println("employee not found");
            }
        
    }

    // method for search employee
   public Employee searchEmployee(int id) {
        Employee current = head;

        while (current != null && current.id != id) {
            current = current.next;
        }

        if (current == null) {
           
            return null;
        }

        return current;
    }

    // method for sorting by salary
    public void sortBySalary() {
        if (head == null || head.next == null) {
            return;
        }

        boolean swapped;
        Employee current;
        Employee next = null;

        do {
            swapped = false;
            current = head;

            while (current.next != next) {
                if (current.salary > current.next.salary) {
                    // Swap the employees
                    double tempSalary = current.salary;
                    current.salary = current.next.salary;
                    current.next.salary = tempSalary;

                    int tempId=current.id;
                    current.id=current.next.id;
                    current.next.id=tempId;

                    String tempName = current.name;
                    current.name = current.next.name;
                    current.next.name = tempName;

                    int tempAge=current.age;
                    current.age=current.next.age;
                    current.next.age=tempAge;

                    String tempPhoneNumber = current.phoneNumber;
                    current.phoneNumber = current.next.phoneNumber;
                    current.next.phoneNumber = tempPhoneNumber;

                    String tempEmail = current.emailAddress;
                    current.emailAddress = current.next.emailAddress;
                    current.next.emailAddress = tempEmail;

                    String tempPosition = current.position;
                    current.position = current.next.position;
                    current.next.position = tempPosition;

                    String tempType = current.type;
                    current.type = current.next.type;
                    current.next.type = tempType;

                    String tempJoiningDate = current.joiningDate;
                    current.joiningDate = current.next.joiningDate;
                    current.next.joiningDate = tempJoiningDate;

                    String tempResigningDate = current.resigningDate;
                    current.resigningDate = current.next.resigningDate;
                    current.next.resigningDate = tempResigningDate;

                    swapped = true;
                }
                current = current.next;
            }
            next = current;
        } while (swapped);
    }

    // method for see no. of employees in list
    public int length() {
        int count = 0;
        Employee current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // method for display employee by type
    public void displayEmployeeByType(String targetType){
        Employee current = head;
        boolean found=false;
        
        while (current != null) {
            if(current.type.equalsIgnoreCase(targetType)){
            System.out.println("ID: " + current.id + ", Name: " + current.name + ", age:" + current.age + ", phone number:" + current.phoneNumber + ", email Id:" + current.emailAddress + ", position:"+ current.position + ", salary:"+ current.salary + ", type:" + current.type + ", joining date:" + current.joiningDate + ", resigning date:"+ current.resigningDate);
            found=true;
            }
            current = current.next;
        }
        if(!found){
            System.out.println("no employee of type :"+ targetType + " found");
        }
    }
    
    // method for display employee
    public void displayAllEmployees() {
        Employee current = head;
        System.out.println("Employee List:");
        while (current != null) {
            System.out.println("ID: " + current.id + ", Name: " + current.name + ", age:" + current.age + ", phone number:" + current.phoneNumber + ", email Id:" + current.emailAddress + ", position:"+ current.position + ", salary:"+ current.salary + ", type:" + current.type + ", joining date:" + current.joiningDate + ", resigning date:"+ current.resigningDate);
            current = current.next;
        }
        System.out.println("null");
    }

    public void close() {
        Employee current = head;
        while (current != null) {
            Employee temp = current;
            current= current.next;
            temp = null; // Not strictly necessary in Java, due to automatic garbage collection
        }
        head = null;
    }
}

class employeeManagementSystem {
    public static void main(String[] args)  {
        EmployeeList employeeList = new EmployeeList();
        Scanner sc=new Scanner(System.in);

        while (true) {
            System.out.println("  ---------------------------------------------");
            System.out.println("  Welcome To Employee Management System Program");
            System.out.println("  ---------------------------------------------");
            System.out.println("1. login using username & password if login successful then user add employeedetails else exit from the program");
            System.out.println("2. Stepwise Print Employees");
            System.out.println("3. Resign Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Search Employee");
            System.out.println("6. Employee list sorted by salary");
            System.out.println("7. Get Length of Employee List");
            System.out.println("8. Display all Employees");
            System.out.println("9. Display employees by type:- trainee");
            System.out.println("10. Display employees by type:- probation");
            System.out.println("11. Display employees by type:- contract");
            System.out.println("12. Display employees by type:- permanent");
            System.out.println("13. Display employees by type:- resign");
            System.out.println("14. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    

         // Login functionality
        String username = "jensi"; // Replace with your actual username
        String password = "12345678"; // Replace with your actual password
        int attempts = 3; // Number of login attempts allowed

        while (attempts > 0) {
            System.out.print("Enter username: ");
            String enteredUsername = sc.nextLine();
            System.out.print("Enter password: ");
            String enteredPassword = sc.nextLine();

            if (enteredUsername.equals(username) && enteredPassword.equals(password)) {
                System.out.println("Login successful!");
                // Perform actions after successful login here

                  // Get input of Employee ID
					boolean isValidInt = false;
					int id = 0;
					do {
						System.out.println("Enter Employee ID:");
						try {
							id = sc.nextInt();
							sc.nextLine();
							isValidInt = true;
						} catch (InputMismatchException e) {
							System.out.println("Invalid Integer number format!");
							sc.nextLine(); // clear the input buffer
						}
					} while (!isValidInt);
                    
                    // Get input of employee name
                    System.out.print("Enter employee name: ");
                    String name = sc.nextLine();

                    // Get input of employee age
                    System.out.println("Enter employee age: ");
                    int age=sc.nextInt();
                    sc.nextLine();

                    // Get input of Employee Contact Details (Mobile number)
					boolean isValidNumber = false;
					String mobileNumber = "";
					do {
						System.out.println("Enter employee mobile number(number between 0 to 9):");
						mobileNumber = sc.nextLine();
						try {
							if (mobileNumber.matches("[0-9]+")) {
								if (mobileNumber.length() == 10) {
									isValidNumber = true;
								} else {
									System.out.println("Mobile number should be 10 digits long!");
								}
							} else {
								System.out.println("Invalid Mobile number format!");
							}
						} catch (NumberFormatException e) {
							System.out.println("Invalid mobile number format!");
						}
					} while (!isValidNumber);

                    // Get input of Employee Contact Details (Email ID)
					boolean isValidEmail = false;
					String email = "";
					do {
						System.out.println("Enter employee email(format: a@a.com): ");
						try {
							email = sc.nextLine();
							if (email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
								isValidEmail = true;
							} else {
								System.out.println("Invalid email address format!");
							}
						} catch (Exception e) {
							System.out.println("Invalid email address format!");
							sc.nextLine(); // clear the input buffer
						}
					} while (!isValidEmail);

                    // Get input of Employee Designation/Position
                    System.out.println("Enter employee position:");
                    String position = sc.nextLine();
						
					// Get input of Employee Payroll details
                    System.out.println("Enter employee salary:");
                    double salary = sc.nextDouble();
                    sc.nextLine();

					// Get input of Employee Type
                    System.out.println("Enter employee type (Trainee/Probation/Permanent/Contract)");
                    String type = sc.nextLine();

                    // Get input of Employee Joining Date
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
					boolean isValidDateFormat = false;
                    String joiningDate;
					do {
						System.out.println("Enter employee joining date (Format should be 'dd-MM-yyyy')");
						joiningDate = sc.nextLine();
						try {
							Date formatDate = dateFormat.parse(joiningDate);
							if (joiningDate.equals(dateFormat.format(formatDate))) {
								isValidDateFormat = true;
							} else {
								System.out.println("Date is not in the correct format. Correct format is dd-MM-yyyy");
							}
						} catch (Exception e) {
							System.out.println("Invalid date format!");
						}
					} while (!isValidDateFormat);
					
					// Set Resign Date as "Not Applicable"
					String resigningDate = "NA";

                    employeeList.addLast(id,name,age,mobileNumber,email,position,salary,type,joiningDate,resigningDate);
                    
                break; // Exit the loop since login was successful
            } else {
                attempts--;
                System.out.println("Invalid login credentials. Attempts left: " + attempts);
            }
        }

        if (attempts == 0) {
            System.out.println("Account locked.");
        }
                    break;

                case 2:
                    // stepwise print employee
                    System.out.println("Enter number to print specific step wise print");
                    int n=sc.nextInt();
                    employeeList.stepwisePrint(n);
                    break;

                case 3:
                    // resign employee
                    System.out.print("Enter employee ID to mark employee type as Resign in linked list: ");
                    int resignEmployeeID = sc.nextInt();
                    sc.nextLine();

                    Employee empToResign = employeeList.searchEmployee(resignEmployeeID);

                    if (empToResign != null) {
                        System.out.println("Employee found: " + empToResign.getEmployeeID());
                        employeeList.resignEmployee(resignEmployeeID);
                    } else {
                        System.out.println("Employee not found. Please try again.");
                    }
                    break;

                case 4:
                   // Modify employee details
					System.out.print("Enter employee ID to modify for: ");
					int modifyEmployeeID = sc.nextInt();
					sc.nextLine();

                    Employee empToModify = employeeList.searchEmployee(modifyEmployeeID);
                    
					if (empToModify != null) {
						System.out.println("Employee found: " + empToModify.getEmployeeID());
						employeeList.update(modifyEmployeeID);
						System.out.println("Headers: Employee ID, Name, Age, Mobile Number, Email ID, Position, Salary, Type, Joining Date, Resigning Date");
						System.out.println("Updated Employee Details: " + empToModify.getEmployeeID() + ", " + empToModify.getName() + ", " + empToModify.getAge() + ", " + empToModify.getMobileNumber() + ", " + empToModify.getEmail() + ", " + empToModify.getPosition() + ", " + empToModify.getSalary() + ", " + empToModify.getType() + ", " + empToModify.getJoiningDate() + ", " + empToModify.getResigningDate());
					} else {
						System.out.println("Employee not found. Please try again.");
					}

                    break;

                case 5:
                    // Get input from the user
					System.out.print("Enter the ID of the employee to search for: ");
					int searchEmployeeId = sc.nextInt();
					sc.nextLine();

					// Search for an employee by Employee ID
					Employee emp = employeeList.searchEmployee(searchEmployeeId);

					// Print the employee's details if found, or a message if not found
					if (emp != null) {
						System.out.println("Headers: Employee ID, Name, Address, Mobile Number, Email ID, Position, Salary, Type, Joining Date, Resigning Date");
						System.out.println("Employee found: " + emp.getEmployeeID() + ", " + emp.getName() + ", " + emp.getAge() + ", " + emp.getMobileNumber() + ", " + emp.getEmail() + ", " + emp.getPosition() + ", " + emp.getSalary() + ", " + emp.getType() + ", " + emp.getJoiningDate() + ", " + emp.getResigningDate());
					} else {
						System.out.println("Employee not found. Please try again.");
					}
                    break;

                case 6:
                    // sorted by salary
                    employeeList.sortBySalary();
                    break;

                case 7:
                    // get no. of employees in the list
                    int len = employeeList.length();
                    System.out.println("Length of Employee List: " + len);
                    break;

                case 8:
                    // display all employees
                    employeeList.displayAllEmployees();
                    break;

                case 9:
                    // display only trainee employees
                    employeeList.displayEmployeeByType("trainee");  
                    break;
                    
                case 10:
                    // display only probation employees
                    employeeList.displayEmployeeByType("probation"); 
                    break;
                    
                case 11:
                    // display only contract employees
                    employeeList.displayEmployeeByType("contract");  
                    break;
                    
                case 12:
                    // display only permanent employees
                    employeeList.displayEmployeeByType("permanent");  
                    break;  
                    
                case 13:
                    // display only resign employees
                    employeeList.displayEmployeeByType("Resign");  
                    break;      

                case 14:
                    // exit from the program
                    employeeList.close();
                    sc.close();
                    System.out.println("Thank you. New functionality/features coming soon.....");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }    
    }
}


