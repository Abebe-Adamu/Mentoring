package config;

import org.springframework.cloud.stream.annotation.EnableBinding;

import stream.MenuStreams;

@EnableBinding(MenuStreams.class)
public class StreamConfiguration {

}
