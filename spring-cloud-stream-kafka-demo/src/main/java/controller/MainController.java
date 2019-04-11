package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import org.springframework.http.HttpStatus;


import model.Menu;
import service.MenuListener;
import service.MenuService;

@RestController
public class MainController {
	private final MenuService menuService;

    public MainController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/menu")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void menu(@RequestParam("message") String message) {
        Menu menu = Menu.builder()
            .message(message)
            .timestamp(System.currentTimeMillis())
            .build();

        menuService.sendMenu(menu);
    }
    
    
    //to post order
    
    //grab the info from UI 
    	//grab menu item name
    	//menu item price
    	//menu item quantity
    	//order quantity
    
    //subtract current quantity from order quantity
    //create a menu payload
//    	Menu menu = Menu.builder()
//            .message(message)
//            .timestamp(System.currentTimeMillis())
//            .build();
    //send payload to topic
    	//menuService.sendMenu(menu);
    
    
    
    
  /*  @RequestMapping(value = { "/order" }, method = RequestMethod.POST)
    
    public void orderMenu(@RequestParam("message") String message) {
   
        Menu menu = Menu.builder()
            .message(message)
            .timestamp(System.currentTimeMillis())
            .build();

        menuService.sendMenu(menu);
    } */
    
    
   //Load menu on kafka topic 
    @GetMapping("/")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void menuNoParam() {
    	Menu newMenu = new Menu();
        Menu menu = Menu.builder()
            .message(newMenu.getMessage())
            .timestamp(System.currentTimeMillis())
            .build();

        menuService.sendMenu(menu);
    }
    
   //model and view
    @GetMapping("/index")
    public ModelAndView passParametersWithModelAndView() {
    	//attach (websocket, observable,....etc)
    		//update UI quantities based off of what has been emitted
    	
    	
    	//get menu items from stream
    	Menu newMenu = MenuListener.returnStream(); //Menu Object
    	System.out.println(newMenu.getMessage());
    	String[][] menu = newMenu.getMyArray(); //Is the double menu array
    	System.out.println(menu[0][1]);
            ModelAndView modelAndView = new ModelAndView("index");
            modelAndView.addObject("menu", menu);
            return modelAndView;
        }
    
    
    //AdminConsole = /admin
    //Add an item 
    	//createMenuItem(paremeter name, ......)
}