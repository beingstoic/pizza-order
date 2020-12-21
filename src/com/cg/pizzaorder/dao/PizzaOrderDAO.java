package com.cg.pizzaorder.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.pizzaorder.bean.Customer;
import com.cg.pizzaorder.bean.PizzaOrder;
import com.cg.pizzaorder.exception.PizzaException;

public class PizzaOrderDAO implements IPizzaOrderDAO {

	// declaring maps to store data of user and pizza
	Map<Integer, PizzaOrder> pizzaEntry = new HashMap<Integer, PizzaOrder>();
	Map<Integer, Customer> customerEntry = new HashMap<Integer, Customer>();


	// add data to map
	@Override
	public int placeOrder(Customer customer, PizzaOrder pizza)
			throws PizzaException {

		try {
			// create random customer ID
			int custID = (int) (Math.random() * 100);

			// create random pizza ID
			int orderID = (int) (Math.random() * 1000);
			System.out.println(custID +" "+ orderID);
			customer.setCustomerId(custID);
			pizza.setCustomerId(custID);
			pizza.setOrderId(orderID);

			// passing ids as keys to both the maps
			customerEntry.put(custID, customer);
			pizzaEntry.put(orderID, pizza);

			// return order id that was generated
			return orderID;
		} catch (Exception e) {
			//if cannot create customer and pizza entry
			throw new PizzaException("Cannot create order. Try again later");
			
		}
	}

	//to fetch 
	@Override
	public PizzaOrder getOrderDetails(int orderId) throws PizzaException {
		
		// Get order from user
		PizzaOrder pizza = pizzaEntry.get(orderId);
		System.out.println(pizza);
		//if valid then pass the pizzaorder object
		if (pizza != null)
			return pizza;
		else
			//if order id doesnt exits
			throw new PizzaException("No Order Found with this ID");
	}

}
