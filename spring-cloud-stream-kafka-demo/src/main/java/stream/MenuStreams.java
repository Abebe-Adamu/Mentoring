package stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MenuStreams {
	String INPUT = "menu-in";
    String OUTPUT = "menu-out";

    @Input(INPUT)
    SubscribableChannel inboundMenu();

    @Output(OUTPUT)
    MessageChannel outboundMenu();	

}
