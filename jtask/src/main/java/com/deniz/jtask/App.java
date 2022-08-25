package com.deniz.jtask;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App 
{
    public static void main( String[] args )
    {
    	/*
    	 * Create
    	 */
    	/*
    	create(new Customer("Deniz"));
    	create(new Customer("Ali"));
    	create(new Customer("Ayşe"));

    	create(new Account("Deposit", 1000.0, 1));
    	create(new Account("Checking", 1000.0, 1));
    	create(new Account("Deposit", 1000.0, 2));
    	create(new Account("Deposit", 1000.0, 3));
    	
    	create(new Address("Asd Mahallaesi Zxc Sokak No:12/2 Atasehir/Istanbul", "Atasehir", "Istanbul", "Marmara", "Turkey", 1));
    	create(new Address("Asd Mahallaesi Zxc Sokak No:15/5 Kadikoy/Istanbul", "Kadikoy", "Istanbul", "Marmara", "Turkey", 2));
    	create(new Address("Asd Mahallaesi Zxc Sokak No:12/6 Besiktas/Istanbul", "Besiktas", "Istanbul", "Marmara", "Turkey", 3));

    	
    	create(new Telephone("Mobile", "+905555555555", 1));
    	create(new Telephone("Work", "+905555555556", 2));
    	create(new Telephone("Home", "+905555555557", 3));
    	*/
    	
    	
    	/*
    	 * 	Read
    	 */
    	/*
    	//Read All
    	
    	System.out.println("*******************");
    	for(Object object: getAll(Account.class)) {
    		System.out.println(object.toString());
    	}
    	System.out.println("*******************");

    	
    	System.out.println("*******************");

    	for(Object object: getAll(Customer.class)) {
    		System.out.println(object.toString());
    	}
    	System.out.println("*******************");

    	
    	//Read by Id
    	
    	System.out.println(getById(1, Account.class).toString());
    	System.out.println(getById(3, Customer.class).toString());

    	/*
    	 * Update
    	 */
    	/*
    	Account account = (Account) getById(3, Account.class);
    	account.setAccountType("Checking");
    	account.setAccountBalance(1500);
    	
    	update(account);
    	
    	System.out.println(getById(3, Account.class).toString());

    	/*
    	 * Delete
    	 */
    	/*
    	delete(account);
    	
    	System.out.println("*******************");
    	for(Object object: getAll(Account.class)) {
    		System.out.println(object.toString());
    	}
    	System.out.println("*******************");
    	*/
    	/*
    	String cls = "Customer";
    	String mtd = "public static void com.deniz.jtask.AppDao.create(java.lang.Object)";
    	
    	


			try {
				Method mtd1 = Object.class.getDeclaredMethod(mtd, Object.class);
				mtd1.invoke(null, new Customer("Deniz from Reflection1"));
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
	    	

    	
    	/*Method[] methods = AppDao.class.getDeclaredMethods();
    	
    	for(Method method: methods) {
    		System.out.println(method.toString());
    	}
    	
    	try {
            Class<?> cls = Class.forName("com.deniz.jtask.Customer");
             Constructor<?> ct 
               = cls.getConstructor(String.class);
             
             System.out.println(ct.newInstance("Deniz").toString());

          }
          catch (Throwable e) {
             System.err.println(e);
          }*/
    	
    	//methods[2].invoke(, args)
    	
    	//Class[] 
    	
    	CommandExecuter ce = new CommandExecuter();
    	ce.execute("CreateCustomer");
    	
    	
	}
    
    
}
