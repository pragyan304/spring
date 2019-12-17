package spring1;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Presentation {
	private Dao y;
	Scanner sc=new Scanner(System.in);
	
	public void setDoaObj(Dao y) {
		System.out.println("Doa object is created");
		this.y=y;
	}
	
	public Presentation(){
		System.out.println("presentation object is created");
	}
	
	private String getmenu() {
		String menu="Enter 1...............to ADD\n";
				menu+="Enter 2............to UPDATE\n";
				menu+="Enter 3............to DELETE\n";
				menu+="Enter 4..........to FIND(ID)\n";
				menu+="Enter 5.....to FIND(DEPT ID)\n";
				menu+="Enter 6.....to SHOW ALL DATA\n";
				menu+="Enter 9..............to EXIT";
				return menu;
	}
	public void getOperation() {
		try {
			String menu=getmenu();
			boolean status=true;
			do {
				System.out.println(menu);
				int Choice=sc.nextInt();
				status=getJob(Choice);
			}while(status);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private boolean getJob(int choice) {
		switch(choice) {
		case 1: add(); break;
		case 2:	update(); break;
		case 3:	delete(); break;
		case 4:	singleSelect(); break;
		case 5:	multipleSelect(); break;
		case 6:	selectall(); break;
		case 9:
			default:return false;
		}
		return true;
	}
	private void multipleSelect() {
		System.out.println("enter deptid of employee");
		try {
			int obj =sc.nextInt();
			List<Employee> ll=y.getMultipleData(obj);
				if(ll.isEmpty()) {
					System.out.println("result not found");
				}
				Iterator<Employee> itr=ll.iterator();
				while(itr.hasNext()) {
					Employee temp=itr.next();
					System.out.println("Name: "+temp.getEname());
					System.out.println("DEPT.ID: "+temp.getDepid());
					System.out.println("ID: "+temp.getEid());
					System.out.println("*****************************");
				}
		} catch (Exception e) {
			System.out.println("illigal entry !try again");
		}
	}
	private void add() {
		System.out.println("Enter thr id,deptid,name");
		int id=sc.nextInt();
		int dept=sc.nextInt();
		String name=sc.next();
		if(y.addData(id,dept,name))
			System.out.println("entered succesfully");
		else
			System.out.println("error occure");
	}
	private void update() {
		System.out.println("enter the id");
		int id=sc.nextInt();
		int dept=sc.nextInt();
		String name=sc.next();
		int w=y.update(id,dept,name);
		if(w!=0)
			System.out.println("updated succesfully");
		else
			System.out.println("error occure");
		
	}
	private void delete() {
		System.out.println("enter the id");
		int id=sc.nextInt();
		int x=y.deleteData(id);
		if(x!=0)
			System.out.println("deleted succesfully");
		else
			System.out.println("no match found/error occure");
	}
	private void selectall() {
		List<Employee> arr=y.getAllData();
		if(arr!=null) {
			Iterator<Employee> itr=arr.iterator();
			while(itr.hasNext()) {
				Employee temp=itr.next();
				System.out.println("Name: "+temp.getEname());
				System.out.println("DEPT.ID: "+temp.getDepid());
				System.out.println("ID: "+temp.getEid());
				System.out.println("*****************************");
			}
		}
		else
			System.out.println("result not found");
	}
	private void singleSelect() {
		System.out.println("enter the id");
		int id=sc.nextInt();
		Employee e=y.selectSingleOne(id);
		if(e.getDepid()==0) {
			System.out.println("no match found");
		}
		else {
			System.out.println("Name: "+e.getEname());
			System.out.println("DEPT.ID: "+e.getDepid());
			System.out.println("ID: "+e.getEid());
			System.out.println("*****************************");
		}
		
		
	}
}