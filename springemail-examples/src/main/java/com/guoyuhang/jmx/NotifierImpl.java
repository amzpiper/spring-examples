package com.guoyuhang.jmx;

import org.springframework.jmx.export.annotation.ManagedNotification;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;
import org.springframework.stereotype.Component;

/**
 * 希望发送通知的MBean
 */
@Component
@ManagedResource("email:name=Controller")
@ManagedNotification(name = "TODO", notificationTypes = "")
public class NotifierImpl implements NotificationPublisherAware {

    @Override
    public void setNotificationPublisher(NotificationPublisher notificationPublisher) {
        
    }
}
