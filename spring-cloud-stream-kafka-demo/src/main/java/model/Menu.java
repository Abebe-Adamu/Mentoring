package model;





//import org.assertj.core.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
//@NoArgsConstructor
@AllArgsConstructor
public class Menu {
	 private long timestamp;
	   private String message;
	  
	   
	   
	 //@Builder.Default
	   String[][] myArray;
	   
	 
	   
	   public Menu () {
		   
		   this.myArray = setup();
		   this.message = customToString(this.myArray);
	   }
	   
	  
	  
	   public String customToString(String[][] a) {
		   String result = "";
		   for(int i = 0; i < a.length; i++) {
			   String myArr = String.join(",", a[i]);
			   
			   result += myArr + ",";
			   //System.out.println(myArr);
		   }
		   
		  
		   return result;
	   }
	   //Creates a new MenuItem and adds it to the current menu => addMenuItem();
		/*   public void createMenuItem(String name, int available, int quantity, double price) {
			   String[] item = new String[4];
			   item[0] = name;
			   item [1] = available + "";
			   item[2] = quantity + "";
			   item[3] = price + "";
			   
			   addMenuItem(item);
		   }
		   
		   //Adds the created item to the menu array
		   public void addMenuItem(String[] item) {
			   String[] temp = new String[myArray.length + 1];
			   System.arraycopy(myArray, 0, temp, 0, myArray.length);
			   myArray[myArray.length - 1] = item;
		   }*/
		   
	   
	   public String[][] setup () {
		   String[][] myMenu = new String[4][4];
		   String[] burger = {"burger","10","0","4.00"};
		   String[] fries = {"fries","10","0","1.95"};
		   String[] salad = {"salad","10","0","2.00"};
		   String[] coffee = {"coffee","10","0","2.50"};
		   
		   myMenu[0] = burger;
		   myMenu[1] = fries;
		   myMenu[2] = salad;
		   myMenu[3] = coffee;
		   
		   return myMenu;
	   }
	    
	   public String getMessage() {
		   return this.message;
	   }
	    
	 
	  //method to update menu 
	   //m(){}
	    
	    }
	    
	    


