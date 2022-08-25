package com.deniz.jtask;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.type.StringType;

public class CommandExecuter {

	public void execute(String commandName) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		SQLQuery query = session.createSQLQuery("Select classname, methodname from commands where commandname = '" + commandName + "';");
		List results = query.list();
		Object[] row = (Object[]) results.get(0);
		String className = row[0].toString();
		String methodName = row[1].toString();
		session.close();

		
		if (commandName.equals("CreateCustomer")) {
			try {
				Class<?> cls = Class.forName(className);	
				Constructor<?> constructor =
				        cls.getConstructor(new Class[]{String.class});
				Customer newCustomer = (Customer) constructor.newInstance(":)))");
				Method mtd = cls.getDeclaredMethod("create", Customer.class);				
				mtd.invoke(newCustomer, newCustomer);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (commandName.equals("GetAllCustomers")) {
			try {
				Class<?> cls = Class.forName(className);	
				Constructor<?> constructor =
				        cls.getConstructor();
				Customer newCustomer = (Customer) constructor.newInstance();
				Method mtd = cls.getDeclaredMethod("getAll", null);
				System.out.println(mtd.invoke(newCustomer, null).toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (commandName.equals("GetCustomerById")) {
			try {
				Class<?> cls = Class.forName(className);	
				Constructor<?> constructor =
				        cls.getConstructor();
				Customer newCustomer = (Customer) constructor.newInstance();
				Method mtd = cls.getDeclaredMethod("getById", Integer.TYPE);
				System.out.println(mtd.invoke(newCustomer, 1).toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (commandName.equals("UpdateCustomer")) {
			try {
				Class<?> cls = Class.forName(className);	
				Constructor<?> constructor =
				        cls.getConstructor();
				Customer newCustomer = (Customer) constructor.newInstance();
				Method mtd = cls.getDeclaredMethod("getById", Integer.TYPE);
				Customer cust = (Customer) mtd.invoke(newCustomer, 1);
				
				cust.setCustomerName("asd");
				Method mtd2 = cls.getDeclaredMethod("update", Customer.class);
				mtd2.invoke(newCustomer, cust);
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (commandName.equals("DeleteCustomer")) {
			try {
				Class<?> cls = Class.forName(className);	
				Constructor<?> constructor =
				        cls.getConstructor();
				Customer newCustomer = (Customer) constructor.newInstance();
				Method mtd = cls.getDeclaredMethod("getById", Integer.TYPE);
				Customer cust = (Customer) mtd.invoke(newCustomer, 1);
				
				Method mtd2 = cls.getDeclaredMethod("delete", Customer.class);
				mtd2.invoke(newCustomer, cust);
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (commandName.equals("CreateAccount")) {
			try {
				Class<?> cls = Class.forName(className);	
				Constructor<?> constructor =
				        cls.getConstructor(String.class, Double.TYPE, Integer.TYPE);
				Account newAccount = (Account) constructor.newInstance("Deposit", 0.0, 2);
				Method mtd = cls.getDeclaredMethod("create", Account.class);				
				mtd.invoke(newAccount, newAccount);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (commandName.equals("GetAllAccounts")) {
			try {
				Class<?> cls = Class.forName(className);	
				Constructor<?> constructor =
				        cls.getConstructor();
				Account newAccount = (Account) constructor.newInstance();
				Method mtd = cls.getDeclaredMethod("getAll", null);
				System.out.println(mtd.invoke(newAccount, null).toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (commandName.equals("GetAccountById")) {
			try {
				Class<?> cls = Class.forName(className);	
				Constructor<?> constructor =
				        cls.getConstructor();
				Account newAccount = (Account) constructor.newInstance();
				Method mtd = cls.getDeclaredMethod("getById", Integer.TYPE);
				System.out.println(mtd.invoke(newAccount, 1).toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (commandName.equals("UpdateAccount")) {
			try {
				Class<?> cls = Class.forName(className);	
				Constructor<?> constructor =
				        cls.getConstructor();
				Account newAccount = (Account) constructor.newInstance();
				Method mtd = cls.getDeclaredMethod("getById", Integer.TYPE);
				Account acc = (Account) mtd.invoke(newAccount, 1);
				
				acc.setAccountBalance(1000.0);
				acc.setAccountType("Checking");
				Method mtd2 = cls.getDeclaredMethod("update", Account.class);
				mtd2.invoke(newAccount, acc);
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (commandName.equals("DeleteAccount")) {
			try {
				Class<?> cls = Class.forName(className);	
				Constructor<?> constructor =
				        cls.getConstructor();
				Account newAccount = (Account) constructor.newInstance();
				Method mtd = cls.getDeclaredMethod("getById", Integer.TYPE);
				Account cust = (Account) mtd.invoke(newAccount, 1);
				
				Method mtd2 = cls.getDeclaredMethod("delete", Account.class);
				mtd2.invoke(newAccount, cust);
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (commandName.equals("CreateAddress")) {
			try {
				Class<?> cls = Class.forName(className);	
				Constructor<?> constructor =
				        cls.getConstructor(String.class, String.class, String.class, String.class, String.class, Integer.TYPE);
				Address newAddress = (Address) constructor.newInstance("ASd", "asd", "zxc", "fdh", "ert", 2);
				Method mtd = cls.getDeclaredMethod("create", Address.class);				
				mtd.invoke(newAddress, newAddress);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (commandName.equals("GetAllAddresses")) {
			try {
				Class<?> cls = Class.forName(className);	
				Constructor<?> constructor =
				        cls.getConstructor();
				Address newAddress = (Address) constructor.newInstance();
				Method mtd = cls.getDeclaredMethod("getAll", null);
				System.out.println(mtd.invoke(newAddress, null).toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (commandName.equals("GetAddressById")) {
			try {
				Class<?> cls = Class.forName(className);	
				Constructor<?> constructor =
				        cls.getConstructor();
				Address newAddress = (Address) constructor.newInstance();
				Method mtd = cls.getDeclaredMethod("getById", Integer.TYPE);
				System.out.println(mtd.invoke(newAddress, 1).toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (commandName.equals("UpdateAddress")) {
			try {
				Class<?> cls = Class.forName(className);	
				Constructor<?> constructor =
				        cls.getConstructor();
				Address newAddress = (Address) constructor.newInstance();
				Method mtd = cls.getDeclaredMethod("getById", Integer.TYPE);
				Address acc = (Address) mtd.invoke(newAddress, 1);
				
				acc.setFullAddress("asasdasd");
				Method mtd2 = cls.getDeclaredMethod("update", Address.class);
				mtd2.invoke(newAddress, acc);
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (commandName.equals("DeleteAddress")) {
			try {
				Class<?> cls = Class.forName(className);	
				Constructor<?> constructor =
				        cls.getConstructor();
				Address newAddress = (Address) constructor.newInstance();
				Method mtd = cls.getDeclaredMethod("getById", Integer.TYPE);
				Address cust = (Address) mtd.invoke(newAddress, 1);
				
				Method mtd2 = cls.getDeclaredMethod("delete", Address.class);
				mtd2.invoke(newAddress, cust);
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (commandName.equals("CreateTelephone")) {
			try {
				Class<?> cls = Class.forName(className);	
				Constructor<?> constructor =
				        cls.getConstructor(String.class, String.class, Integer.TYPE);
				Telephone newTelephone = (Telephone) constructor.newInstance("Mobile", "55555555", 2);
				Method mtd = cls.getDeclaredMethod("create", Telephone.class);				
				mtd.invoke(newTelephone, newTelephone);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (commandName.equals("GetAllTelephones")) {
			try {
				Class<?> cls = Class.forName(className);	
				Constructor<?> constructor =
				        cls.getConstructor();
				Telephone newTelephone = (Telephone) constructor.newInstance();
				Method mtd = cls.getDeclaredMethod("getAll", null);
				System.out.println(mtd.invoke(newTelephone, null).toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (commandName.equals("GetTelephoneById")) {
			try {
				Class<?> cls = Class.forName(className);	
				Constructor<?> constructor =
				        cls.getConstructor();
				Telephone newTelephone = (Telephone) constructor.newInstance();
				Method mtd = cls.getDeclaredMethod("getById", Integer.TYPE);
				System.out.println(mtd.invoke(newTelephone, 1).toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (commandName.equals("UpdateTelephone")) {
			try {
				Class<?> cls = Class.forName(className);	
				Constructor<?> constructor =
				        cls.getConstructor();
				Telephone newTelephone = (Telephone) constructor.newInstance();
				Method mtd = cls.getDeclaredMethod("getById", Integer.TYPE);
				Telephone acc = (Telephone) mtd.invoke(newTelephone, 1);
				
				acc.setTelephoneNo("5555555555");
				acc.setTelephoneType("Home");
				Method mtd2 = cls.getDeclaredMethod("update", Telephone.class);
				mtd2.invoke(newTelephone, acc);
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (commandName.equals("DeleteTelephone")) {
			try {
				Class<?> cls = Class.forName(className);	
				Constructor<?> constructor =
				        cls.getConstructor();
				Telephone newTelephone = (Telephone) constructor.newInstance();
				Method mtd = cls.getDeclaredMethod("getById", Integer.TYPE);
				Telephone cust = (Telephone) mtd.invoke(newTelephone, 1);
				
				Method mtd2 = cls.getDeclaredMethod("delete", Telephone.class);
				mtd2.invoke(newTelephone, cust);
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		/*if (commandName.equals("CreateCustomer")) {
			try {
				Method mtd = AppDao.class.getDeclaredMethod("create", Object.class);
				Customer newCustomer = new Customer();
				newCustomer.setCustomerName("TEST");
				mtd.invoke(null, newCustomer);
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (commandName.equals("CreateAccount")) {
			try {
				Method mtd = AppDao.class.getDeclaredMethod("create", Object.class);
				Account newAccount = new Account();
				newAccount.setAccountBalance(0.0);
				newAccount.setAccountType("Deposit");
				newAccount.setCustomerId(1);
				mtd.invoke(null, newAccount);
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (commandName.equals("CreateAddress")) {
			try {
				Method mtd = AppDao.class.getDeclaredMethod("create", Object.class);
				Address newAddress = new Address();
				newAddress.setFullAddress("");
				newAddress.setCounty("");
				newAddress.setProvince("");
				newAddress.setRegion("");
				newAddress.setCountry("");
				newAddress.setCustomerId(0);
				mtd.invoke(null, newAddress);
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (commandName.equals("CreateTelephone")) {
			try {
				Method mtd = AppDao.class.getDeclaredMethod("create", Object.class);
				Telephone newTelephone = new Telephone();
				newTelephone.setTelephoneNo("");
				newTelephone.setTelephoneType("");
				newTelephone.setCustomerId(0);
				mtd.invoke(null, newTelephone);
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		


		
	}
}
