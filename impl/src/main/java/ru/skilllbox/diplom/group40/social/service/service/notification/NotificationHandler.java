package ru.skilllbox.diplom.group40.social.service.service.notification;

/*
import ru.skillbox.diplom.group40.social.network.api.dto.notification.NotificationDTO;
import ru.skillbox.diplom.group40.social.network.api.dto.notification.Type;
import ru.skillbox.diplom.group40.social.network.domain.notification.EventNotification;
*/

import java.util.List;

public interface NotificationHandler {

    List</*EventNotification*/ String> getEventNotificationList(/*NotificationDTO*/ String notificationDTO);

    /*Type*/ String myType();

}

