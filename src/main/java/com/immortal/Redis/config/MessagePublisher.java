package com.immortal.Redis.config;

public interface MessagePublisher {
    void publish(String message);
}
