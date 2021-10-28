package firstemployee;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;
public class Employee {	
       int key = 1;
       HashMap<Integer, Details> employeedata=new HashMap<>();
       HashMap<Integer, Long> duration=new HashMap<>();
       long startTime;
       long endTime;
       long durationInMillis;
  public static void main(String[] args) {		
      System.out.println("Start");
      new Employee().calling();
  }	
  void insert() {
	 startTime = System.currentTimeMillis();
     Scanner s=new Scanner(System.in);
	 System.out.println("Enter Employee name");
	 String name= s.nextLine();
     System.out.println("Enter Employee Department");
	 String dept= s.nextLine();
     LocalDateTime date = LocalDateTime.now();
     Details emp1=new Details(key,name,dept,date);
	 employeedata.put(key, emp1);
	 endTime = System.currentTimeMillis();    
     durationInMillis = (endTime - startTime); 	 
	 duration.put(key, durationInMillis);
     key++;	
	 System.out.println("Employee Inserted");
	 System.out.println();
   }
  void get() {
	 Set empId=employeedata.keySet();		 
	 System.out.println("These employee ids are present : "+empId);
	 Scanner s=new Scanner(System.in);
	 System.out.println("Enter Employee id getting details");
	 Integer userkey= s.nextInt();
	 if(empId.contains(userkey)) {
	      Details d=employeedata.get(userkey);
		  Long durationInMillis=duration.get(userkey);
		  System.out.println("Employee id = "+d.id+"\n"+"Employee name = "+d.name+"\n"+"Employee Depatment = "+d.dept+"\n"+"When employee joined = "+d.date);
		  System.out.println("Total time duration of employee creation = " +durationInMillis+"ms");
		  System.out.println();
	 } else {
			 throw new nativeException("This is invalid Employee ID");
	   }
   }
  public void delete() {
	 Set empId=employeedata.keySet();
	 Scanner s=new Scanner(System.in);
	 System.out.println("Enter Employee id delete operation : ");
	 Integer userkey= s.nextInt();
	 if(empId.contains(userkey)) {
		   employeedata.remove(userkey);
		   duration.remove(userkey);
		   System.out.println("Deleted");
		   System.out.println();
	 } else {
			 throw new nativeException("This is invalid Employee ID");
	   } 		 
   }
   public void update() {
	  Scanner s=new Scanner(System.in);
	  System.out.println("Enter Employee id update operation : ");
	  Integer userkey= s.nextInt();
	  Set empId=employeedata.keySet();
	  if(empId.contains(userkey)) {
			 Details object=employeedata.get(userkey);
			 System.out.println("Update Employee name if dont want enter -  no : ");
			 String name=s.next();
			 System.out.println("Update Employee department if dont want enter no : ");
			 String dept=s.next();
			 if(name.equals("no")) {
			 } else 
				 object.name=name;
		     if(dept.equals("no")) {
		    	 
		     } else 
		    	 object.dept=dept;
		} else {
			 System.out.println("Invalid Employee please enter valid employee id !!!");
		  }
	   System.out.println();
	 }	 
     void calling() {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter your choice :"+"\n"+"1 : Add Employee"+"\n"+"2 : View employee details "+"\n"+"3 : Update employee details"+"\n"+"4 : Delete employee");
		Integer choice= s.nextInt();
		
		switch(choice) {
		 case 1: {			
			   insert();				
			   calling();
			   break;
		 }
		 case 2: {
			   get();
			   calling();
			   break;
		 }
		 case 3: {
			   update();
			   calling();
			   break;
		 }
		 case 4: {
			   delete();
			   calling();
			   break;
		 }
	   }
	 }
}
