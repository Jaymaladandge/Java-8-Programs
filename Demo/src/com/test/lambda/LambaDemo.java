package com.test.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class LambaDemo {

	public static void main(String[] args) {
		
		//lambda expressions implement the only abstract function and therefore implement functional interfaces
		
		Addable addable = (a,b)->{return a+b;};		 // Lambda expression with return keyword.    
		Addable addable2 = (a,b)->(a+b);			 // Lambda expression without return keyword.
		Addable addable3 =(int a, int b)->(a+b);	 // Multiple parameters with data type in lambda expression  
		Addable addable4 =(int a, int b)->a+b;		  //You can omit function parentheses
		
		System.out.println(addable.add(10, 20)+"  "+addable2.add(100, 200) +" "+addable3.add(100, 100)+" "+" "+addable4.add(200, 200));
		
		System.out.println("--------------------------------");
		
		
		List<String> list=new ArrayList<String>();  
        list.add("ankit");  
        list.add("mayank");  
        list.add("irfan");  
        list.add("jai");  
		
        list.forEach((a) -> {System.out.print(a+" ");});		    
        System.out.println("\n------------------------");
        list.forEach(a -> System.out.print(a+" "));				//You can omit function parentheses
        
        System.out.println("\n---------------------------------");
        
        Runnable runnable = () -> System.out.println("Lamba demo");
        new Thread(runnable).start();
        new Thread(()->System.out.println("Lamba demo")).start();
        
        System.out.println("-----------------------------");
        
        ArrayList<Product>products=new ArrayList<>();
        products.add(new Product(100, "laptop", 45000));
        products.add(new Product(102, "desktop", 55000));
        products.add(new Product(104, "keyboard", 7000));
        products.add(new Product(103, "mouse", 5000));
        
        Collections.sort(products, (p1,p2)->(p1.getName().compareTo(p2.getName()))   );		// Lambda expression without return keyword.
        
        products.forEach((n)->System.out.println(n));
        
        System.out.println("-------------=============------------");
        
        Optional<Product>opt = products.stream().max((p1,p2)->(p1.getId()-p2.getId()));
        System.out.println(opt.get());
        
        System.out.println("------------------------------------------");
        
        Stream<Product> stream=products.stream().filter(p->p.getPrice()>40000);
        stream.forEach(product->System.out.println(product));
        
	}
}


@FunctionalInterface
interface Addable{
	
	int add(int a, int b);
}

 