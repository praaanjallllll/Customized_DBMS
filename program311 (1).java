import java.lang.*;
import java.util.*;

//create table student(RID int,Name varchar(255),Salary int);
//Database table / schema
class Student
{
	public int RID;
	public String Name;
	public int Salary;
	
	private static int Generator; //*
	
	static //execute before constructor //used to initialize static var
	{
		Generator = 0;
	}
	
	public Student(String str,int value)
	{
		this.RID = ++Generator; //each time generator get increase by 1
		this.Name = str;
		this.Salary = value;
	}
	
	public void Display()
	{
		System.out.println(" "+this.RID+ "\t" +this.Name+"\t"+this.Salary);
	}
	
}

class DBMS
{
	LinkedList<Student> lobj;  //caharacteristics
	
	public DBMS()
	{
		lobj= new LinkedList<>(); //allocate the resources
	}
	
	//insert into student Piyush 10000
	//select * from student
	//select * from student where Name = name
	//select * from student where RID = rid
	//select MIN (salary) from student
	public void StartDBMS()
	{
		Scanner scanobj = new Scanner(System.in);
		
		System.out.println("Customizd DBMS start successfully...! \n");
		
		System.out.println("For any query please type  'HELP' \n");
		
		String Query = "";
		while(true)
		{
			System.out.print("DBMS console >");
			//Query = Query.toLowerCase();
			Query = scanobj.nextLine().toLowerCase();
			
			String tokens[] = Query.split(" ");
			
			int QuerySize = tokens.length;
			
			if(QuerySize == 1)
			{
				if("help".equals(tokens[0]))
				{
					System.out.println("This application is used to demonstartes customized DBMS");
					System.out.println("Exit: Terminates DBMS");
					System.out.println("Display all data: Select * from Student");
					System.out.println("Display specific data (RID): Select * from Student where rid  = RID");
					System.out.println("Display specific data (Name): Select * from Student where name  = Name");
					System.out.println("Insert data: Insert into student Name Salary");
					System.out.println("Display Minimum Salary: select MIN (salary) from student");
					System.out.println("Display Maximum Salary: select MAX (salary) from student");
					System.out.println("Display Average Salary: select AVERAGE (salary) from student");
					System.out.println("Display count : select COUNT (salary) from student");
					System.out.println("Display Sum of Salary: select SUM (salary) from student");
					System.out.println("Delete by RID : delete from student where RID = rid");
					System.out.println("Delete by Name : delete from student where Name = name \n");
					
				}
				else if("exit".equals(tokens[0]))
				{
					System.out.println("Thank you for using DBMS !");
					break;
				}
			}
			else if(QuerySize == 2)
			{
				
			}
			else if(QuerySize == 4)
			{
				if("select".equals(tokens[0]))
				{
					if("*".equals(tokens[1]))
					{
						System.out.println("RID \t Name \t Salary");
						System.out.println("------------------------------------------");
						DisplayAll();
						System.out.println("------------------------------------------");
					}
					
				}
				
			}
			else if(QuerySize == 5)
			{
				if("insert".equals(tokens[0]))
				{
					InsertData(tokens[3],Integer.parseInt(tokens[4]));
				}
				if("select".equals(tokens[0]))
				{
					 if("min".equals(tokens[1]))
					{
						System.out.println("------------------------------------------");
						AggregateMin();
						System.out.println("------------------------------------------");
						
					}
				}
				if("select".equals(tokens[0]))
				{
					 if("max".equals(tokens[1]))
					{
						System.out.println("------------------------------------------");
						AggregateMax();
						System.out.println("------------------------------------------");
						
					}
				}
				if("select".equals(tokens[0]))
				{
					 if("average".equals(tokens[1]))
					{
						System.out.println("------------------------------------------");
						AggregateAverage();
						System.out.println("------------------------------------------");
						
					}
				}
				if("select".equals(tokens[0]))
				{
					 if("count".equals(tokens[1]))
					{
						System.out.println("------------------------------------------");
						AggregateCount();
						System.out.println("------------------------------------------");
						
					}
				}
				if("select".equals(tokens[0]))
				{
					 if("sum".equals(tokens[1]))
					{
						System.out.println("------------------------------------------");
						AggregateSum();
						System.out.println("------------------------------------------");
						
					}
				}
			}
			else if(QuerySize == 8)
			{
				if("select".equals(tokens[0]))
				{
					if("where".equals(tokens[4]))
					{
						System.out.println("RID \t Name \t Salary");
						System.out.println("------------------------------------------");
						DisplaySpecific(tokens[7]);
						System.out.println("------------------------------------------");
						
						
					}
					
				}
			}
			else if(QuerySize == 7)
			{
				if("select".equals(tokens[0]))
				{
					if("RID".equals(tokens[5]))
					{
						System.out.println("RID \t Name \t Salary");
						System.out.println("------------------------------------------");
						DisplaySpecific(Integer.parseInt(tokens[7]));
						System.out.println("------------------------------------------");
					
						
					}
					
				}
				
				if("delete".equals(tokens[0]))
				{
					if("rid".equals(tokens[4]))
					{
						
						DeleteSpecific(Integer.parseInt(tokens[6]));
						
					}
					
				}
				
				if("delete".equals(tokens[0]))
				{
					if("name".equals(tokens[4]))
					{
						DeleteSpecific(tokens[6]);
						
					}
					
				}
			}
			
			
			
		}
	}
	
	public void InsertData(String str,int value)
	{
		Student sobj = new Student(str,value);
		lobj.add(sobj);//add Student class object in LL
	}
	
	//Display all without condition
	public void DisplayAll()
	{
		for(Student sref:lobj)   //reference of object of Student class
		{
			sref.Display();
		}
	}
	
	//Display by RID
	public void DisplaySpecific(int rid)
	{
		for(Student sref:lobj)   
		{
			if(sref.RID == rid) //if entered rid is same as Student RID
			{
				sref.Display();
				break;
			}
		}
	}
	
	//Display by Name
	public void DisplaySpecific(String str)
	{
		for(Student sref:lobj)   
		{
			if(str.equals(sref.Name)) //if entered name is same as Student Name
			{
				sref.Display();
				//no need of break as there are multiple entries of same name
			}
		}
	}
	
	//delete by RID
	public void DeleteSpecific(int rid)
	{
		int index =0;
		for(Student sref:lobj)   
		{
			if(sref.RID == rid)
			{
				lobj.remove(index);
				break;
			}
			index++;
		}
	}
	
	////delete by Name
	public void DeleteSpecific(String str)
	{
		int index =0;
		for(Student sref:lobj)   
		{
			if(str.equals(sref.Name))
			{
				lobj.remove(index);
				break;
			}
			index++;
		}
	}
	
	//display minimum salary
	public void AggregateMin()
	{
		int min=(lobj.getFirst()).Salary;
		Student temp=lobj.getFirst();
		for(Student sref:lobj)   
		{
			if(sref.Salary < min)
			{
				min = sref.Salary;
				temp=sref;
			}
			
		}
		System.out.println("Information of Minimum salary : ");
		temp.Display();
	}
	
	//display maximun salary
	public void AggregateMax()
	{
		int max=0;
		Student temp=null;
		for(Student sref:lobj)   
		{
			if(sref.Salary > max)
			{
				max = sref.Salary;
				temp=sref;
			}
			
		}
		System.out.println("Information of Maximum salary : ");
		temp.Display();
	}
	
	//Sum of all salaries
	public void AggregateSum()
	{
		long sum=0;
		
		for(Student sref:lobj)   
		{
			sum = sum + sref.Salary;
			
		}
		System.out.println("Summation of salary : "+sum);
	}
	
	//Average of salaries
	public void AggregateAverage()
	{
		long sum=0;
		
		for(Student sref:lobj)   
		{
			sum = sum + sref.Salary;
			
		}
		System.out.println("Average of salary : "+sum/lobj.size());
	}
	
	public void AggregateCount()
	{
		
		System.out.println("Count is: "+lobj.size());
	}
}

class Program311
{
	public static void main(String arg[])
	{
			Scanner sc  = new Scanner(System.in);
			System.out.print("Enter password : ");
			String pass = sc.nextLine();
			
			if(pass.equals("dk"))
			{
				DBMS dobj = new DBMS();
				dobj.StartDBMS();
			}
			else
			{
				return;
			}
	}
}