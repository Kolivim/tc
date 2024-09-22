package ru.skilllbox.diplom.group40.social.service.service.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/*
import ru.skillbox.diplom.group40.social.network.api.dto.notification.*;
import ru.skillbox.diplom.group40.social.network.domain.notification.EventNotification;
import ru.skillbox.diplom.group40.social.network.domain.notification.EventNotification_;
import ru.skillbox.diplom.group40.social.network.impl.mapper.notification.NotificationMapper;
import ru.skillbox.diplom.group40.social.network.impl.mapper.notification.NotificationsMapper;
import ru.skillbox.diplom.group40.social.network.impl.repository.notification.EventNotificationRepository;
import ru.skillbox.diplom.group40.social.network.impl.service.kafka.KafkaService;
import ru.skillbox.diplom.group40.social.network.impl.utils.auth.AuthUtil;
import ru.skillbox.diplom.group40.social.network.impl.utils.specification.SpecificationUtils;
*/

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class NotificationService {
    private final List<NotificationHandler> notificationHandlerList;
    private final Map</*Type*/ String, NotificationHandler> notificationHandlersMap;
//    private final EventNotificationRepository eventNotificationRepository;
//    private final KafkaService kafkaService;
//    private final NotificationsMapper notificationsMapper;
//    private final NotificationMapper notificationMapper;

    public NotificationService(
            List<NotificationHandler> notificationHandlerList
//            ,
//            EventNotificationRepository eventNotificationRepository,
//            KafkaService kafkaService,
//            NotificationsMapper notificationsMapper,
//            NotificationMapper notificationMapper
    ) {
        this.notificationHandlerList = notificationHandlerList;
        this.notificationHandlersMap = this.notificationHandlerList.stream().collect(Collectors.toMap(NotificationHandler::myType,
                        notificationHandler -> notificationHandler));
        log.info("NotificationService: rrr");
//        this.eventNotificationRepository = eventNotificationRepository;
//        this.kafkaService = kafkaService;
//        this.notificationsMapper = notificationsMapper;
//        this.notificationMapper = notificationMapper;
    }

    public void create(/*NotificationDTO notificationDTO*/) {
        log.info("NotificationService: create(NotificationDTO notificationDTO) startMethod, notificationDTO: "
                /*notificationDTO*/);
//        send(eventNotificationRepository.saveAll(

                notificationHandlersMap.get(/* notificationDTO.getNotificationType()*/ "type")
                .getEventNotificationList(/*notificationDTO*/ "notificationDTO");

//        ));
    }


}