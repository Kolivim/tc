package ru.skilllbox.diplom.group40.social.service.service.load;

import com.teamcenter.schemas.soa._2006_03.exceptions.ServiceException;
import com.teamcenter.services.strong.core.DataManagementService;
import com.teamcenter.services.strong.core.SessionService;
import com.teamcenter.services.strong.core._2008_06.DataManagement;
import com.teamcenter.soa.client.Connection;
import com.teamcenter.soa.common.ObjectPropertyPolicy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.skilllbox.diplom.group40.social.service.dto.CreateItemInfoDTO;
import ru.skilllbox.diplom.group40.social.service.dto.business.object.Type;
import ru.skilllbox.diplom.group40.social.service.dto.drawing.DrawingDto;
import ru.skilllbox.diplom.group40.social.service.repository.session.KolivimSession;
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

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class LoadService {

    //
    private DataManagement dataManagement;
    private Connection connection;
    private KolivimSession kolivimSession;
    //

    private final List<ItemHandler> notificationHandlerList;
    private final Map<Type /*String*/, ItemHandler> notificationHandlersMap;
//    private final EventNotificationRepository eventNotificationRepository;
//    private final KafkaService kafkaService;
//    private final NotificationsMapper notificationsMapper;
//    private final NotificationMapper notificationMapper;

    public LoadService(
            List<ItemHandler> notificationHandlerList
//            ,
//            EventNotificationRepository eventNotificationRepository,
//            KafkaService kafkaService,
//            NotificationsMapper notificationsMapper,
//            NotificationMapper notificationMapper
    ) {
        this.notificationHandlerList = notificationHandlerList;
        this.notificationHandlersMap = this.notificationHandlerList.stream().collect(Collectors.toMap(ItemHandler::myType,
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


    public void create(CreateItemInfoDTO createItemInfoDTO) {
        log.info("LoadService: create(CreateItemInfoDTO createItemInfoDTO) startMethod, CreateItemInfoDTO: {}", createItemInfoDTO);

        //
        String serverHost = ""; //TODO: дописать ХОСТ !!!
        KolivimSession kolivimSession = new KolivimSession(serverHost);
        Connection connection = kolivimSession.getConnection();
        //

        //
        DataManagement dataManagement = DataManagementService.getService(connection);;
        //

        setObjectPolicy2(connection, kolivimSession, createItemInfoDTO.getType1());

        DataManagement.CreateIn[] createObjectsIn = notificationHandlersMap.get(createItemInfoDTO.getType()).getCreateIn(createItemInfoDTO);

        try {
            DataManagement.CreateResponse createResponse = dataManagement.createObjects(createObjectsIn);
        } catch (ServiceException e) {
            System.out.println("    LoadService: create(CreateItemInfoDTO createItemInfoDTO) catch in *dataManagement.createObjects* : " + e.getMessage());
        }

    }


    public void create(DrawingDto drawingDto) {
        log.info("LoadService: create(DrawingDto drawingDto) startMethod, DrawingDto: {}", drawingDto);

        //
        String serverHost = ""; //TODO: дописать ХОСТ !!!
        KolivimSession kolivimSession = new KolivimSession(serverHost);
        Connection connection = kolivimSession.getConnection();
        //

        //
        DataManagement dataManagement = DataManagementService.getService(connection);;
        //
        setObjectPolicy2(connection, kolivimSession, drawingDto.getCreateObjectType());

        DataManagement.CreateIn[] createObjectsIn = notificationHandlersMap.get(drawingDto.getCreateObjectType1()).getCreateIn(drawingDto);

        try {
            DataManagement.CreateResponse createResponse = dataManagement.createObjects(createObjectsIn);
        } catch (ServiceException e) {
            System.out.println("    LoadService: create(DrawingDto drawingDto) catch in *dataManagement.createObjects* : " + e.getMessage());
        }

    }





    private void setObjectPolicy2(Connection connection, KolivimSession kolivimSession, String itemType){

        SessionService sessionService = SessionService.getService(connection);

        ObjectPropertyPolicy policy = new ObjectPropertyPolicy();

        policy.addType(itemType, new String[]{"va49_mdm_code", "item_id", "object_name", "object_desc", "revision_list", "item_master_tag"});
        policy.addType(itemType.concat("Revision"), new String[]{"item_revision_id", "va49_number"});

        String policyName = sessionService.setObjectPropertyPolicy(policy);

        System.out.println("CreateDrawing: setObjectPolicy2() set policy = " + policyName);
    }
}