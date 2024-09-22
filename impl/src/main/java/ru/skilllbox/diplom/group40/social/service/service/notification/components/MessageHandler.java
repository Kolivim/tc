package ru.skilllbox.diplom.group40.social.service.service.notification.components;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.skilllbox.diplom.group40.social.service.service.notification.NotificationHandler;

/*
import ru.skillbox.diplom.group40.social.network.api.dto.notification.NotificationDTO;
import ru.skillbox.diplom.group40.social.network.api.dto.notification.Type;
import ru.skillbox.diplom.group40.social.network.domain.notification.EventNotification;
import ru.skillbox.diplom.group40.social.network.impl.mapper.notification.NotificationsMapper;
import ru.skillbox.diplom.group40.social.network.impl.service.notification.NotificationHandler;
import ru.skillbox.diplom.group40.social.network.impl.service.notification.NotificationSettingsService;
*/

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessageHandler implements NotificationHandler {

//    private final NotificationSettingsService notificationSettingsService;
//    private final NotificationsMapper notificationsMapper;

    @Override
    public List</*EventNotification*/ String> getEventNotificationList(/*NotificationDTO notificationDTO*/ String notificationDTO) {
        log.info("MessageHandler: getEventNotificationList(NotificationDTO notificationDTO) startMethod, " +
                "NotificationDTO : {}", notificationDTO);

        List</*EventNotification*/ String> listEventNotifications = new ArrayList<>();

        listEventNotifications.add("тест1");

        log.info("MessageHandler: getEventNotificationList(_):  Получен List listEventNotifications: {}" +
                "для NotificationDTO : {}", listEventNotifications, notificationDTO);
        return listEventNotifications;
    }

    @Override
    public /*Type*/ String myType() {
        /*return Type.MESSAGE;*/
        return "messageHandler";
    }
}
