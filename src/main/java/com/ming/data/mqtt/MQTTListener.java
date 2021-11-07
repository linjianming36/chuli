package com.ming.data.mqtt;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;



@Slf4j
@Component
public class MQTTListener implements ApplicationListener<ContextRefreshedEvent> {

    @Value("$mqtt.username")
    private String username;

    @Value("$mqtt.password")
    private String password;

    private final MQTTConnect server;
    private final Callback callback;

    @Autowired
    public MQTTListener(MQTTConnect server, Callback callback) {
        this.server = server;
        this.callback = callback;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            server.setMqttClient("admin", "public", new Callback());
            server.sub("/ge/dataixinxifabu/10316DA2204F4793991877DCAABDB9CC");
        } catch (MqttException e) {
            log.error(e.getMessage(), e);
        }

    }

}
