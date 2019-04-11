package service;


import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import lombok.extern.slf4j.Slf4j;
import model.Menu;
import stream.MenuStreams;


@Service
@Slf4j
public class MenuService {
    private final MenuStreams menuStreams;

    public MenuService(MenuStreams menuStreams) {
        this.menuStreams = menuStreams;
    }

    public void sendMenu(final Menu menu) {
        log.info("Sending menu {}", menu);

        MessageChannel messageChannel = menuStreams.outboundMenu();
        messageChannel.send(MessageBuilder
                .withPayload(menu)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
    }
   
}
