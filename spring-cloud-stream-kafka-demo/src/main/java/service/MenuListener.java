package service;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import stream.MenuStreams;
import lombok.extern.slf4j.Slf4j;
import model.Menu;

@Component
@Slf4j
public class MenuListener {
	
	static Menu m = new Menu();
	
	  @StreamListener(MenuStreams.INPUT)
	    public void handleMenu(@Payload Menu menu) {
		  m =  menu;
	       log.info("Received menu: {}", menu);
	    }
	  
	  public static Menu returnStream() { 
		  
		  return m;
	  }

}
