package spring1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

class demo {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext d=
				new ClassPathXmlApplicationContext("anything.xml");
		Presentation x=
				d.getBean(Presentation.class);
		x.getOperation();
		d.close();
		System.out.println("success");
	}

}