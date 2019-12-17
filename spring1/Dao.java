package spring1;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


public class Dao {
	private JdbcTemplate t;

	public JdbcTemplate getCnnection() {
		try {
			BasicDataSource b=new BasicDataSource();
			b.setDriverClassName("com.mysql.cj.jdbc.Driver");
			b.setUsername("root");
			b.setPassword("root");
			b.setUrl("jdbc:mysql://localhost:3306/springdb");
			t=new JdbcTemplate();
			t.setDataSource(b);
		} catch (Exception e) {
			System.out.println("problem");
		}
		System.out.println("connection ready");
		return t;
	}
	public Employee selectSingleOne(int id) {
		getCnnection();
		getCnnection();
		String sql="select eid,depid,ename from first where eid=?";
		Object[] params= {id};
		BeanPropertyRowMapper<Employee> x=
				new BeanPropertyRowMapper<Employee>(Employee.class);
			Employee emp;
			try {
				emp=t.queryForObject(sql,params,x);
			} catch (Exception e) {
				emp=new Employee();
				emp.setDepid(0);
				//e.printStackTrace();
			}
		return emp;
	}
	public boolean addData(int id, int dept, String name) {
		try {
			t.update("insert into first values(?,?,?)",id,dept,name);
			return true;
		} catch (Exception e) {
			return false;
		}
		
		
	}
	public int update(int id,int dept, String name) {
		getCnnection();
		try {
			return t.update("update first set depid=?,ename=? where eid=?",dept,name,id); 
		} catch (Exception e) {
			return 0;
		}
	}
	public int deleteData(int id) {
		try {
			return t.update("delete from first where eid=?",id);
			
		} catch (Exception e) {
			return 0;
		}
	}
	public List<Employee> getAllData() {
		getCnnection();
		List<Employee> ll=null;
		try {
			BeanPropertyRowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
			String psc = "select * from first";
			ll=t.query(psc,rowMapper);
			System.out.println(ll);
		} catch (Exception e) {
			ll=new ArrayList<Employee>();
			e.printStackTrace();
		}
		return ll;
	}
	public List<Employee> getMultipleData(int obj) {
		getCnnection();
		List<Employee> ll2=null;
		Object [] ww= {obj};
		try {
			BeanPropertyRowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
			String psc = "select * from first where depid=?";
			ll2=t.query(psc,ww,rowMapper);
		} catch (Exception e) {
			ll2=new ArrayList<Employee>();
		}
		return ll2;
	}
}