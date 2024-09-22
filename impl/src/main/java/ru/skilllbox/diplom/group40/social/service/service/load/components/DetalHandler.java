package ru.skilllbox.diplom.group40.social.service.service.load.components;

import com.teamcenter.services.strong.core._2008_06.DataManagement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.skilllbox.diplom.group40.social.service.dto.CreateItemInfoDTO;
import ru.skilllbox.diplom.group40.social.service.dto.business.object.Type;
import ru.skilllbox.diplom.group40.social.service.dto.detal.DetalDto;
import ru.skilllbox.diplom.group40.social.service.dto.drawing.DrawingDto;
import ru.skilllbox.diplom.group40.social.service.service.load.ItemHandler;

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
public class DetalHandler implements ItemHandler {
//    private final NotificationSettingsService notificationSettingsService;
//    private final NotificationsMapper notificationsMapper;

    @Override
    public List</*EventNotification*/ String> getEventNotificationList(/*NotificationDTO*/ String notificationDTO) {
        log.info("UserBirthdayHandler: getEventNotificationList(NotificationDTO notificationDTO) startMethod, " +
                "NotificationDTO : {}", notificationDTO);

        List</*EventNotification*/ String> listEventNotifications = new ArrayList<>();

        listEventNotifications.add("тест1");

        log.info("UserBirthdayHandler: getEventNotificationList(_): Получен List listEventNotifications: {} " +
                "для NotificationDTO : {}", listEventNotifications, notificationDTO);
        return listEventNotifications;
    }


    @Override
    public Type /*String*/ myType() {
//        return "userBirthdayHandler";
        return Type.VA49_SI_Detal;
    }

    @Override
    public DataManagement.CreateIn[] getCreateIn(Object object) {

        DetalDto detalDto = (DetalDto) object;

        DataManagement.CreateIn createIn = new DataManagement.CreateIn();
        createIn.clientId = "AddDetalItem";

        DataManagement.CreateInput createInput = createIn.data;
        createInput.boName = detalDto.getCreateObjectType();
        createInput.stringProps.put("object_desc", detalDto.getName());
        createInput.stringProps.put("item_id", detalDto.getNumber());
        createInput.stringProps.put("object_name", detalDto.getNumber());

        DataManagement.CreateInput itemRevisionInput = new DataManagement.CreateInput();
        itemRevisionInput.boName = detalDto.getCreateObjectType().concat("Revision");
        itemRevisionInput.stringProps.put("va49_number", detalDto.getCode());
        itemRevisionInput.stringProps.put("item_revision_id", "00");    // TODO: исправить - принять из КОНСТАНТ

        createInput.compoundCreateInput.put("revision", new DataManagement.CreateInput[]{itemRevisionInput});
//        createInput.compoundCreateInput.put("revision", itemRevisionInput);

        DataManagement.CreateIn[] createObjectsInput = new DataManagement.CreateIn[]{createIn};

        return createObjectsInput;
    }

    @Override
    public DataManagement.CreateIn[] getCreateIn(CreateItemInfoDTO createItemInfoDTO) {

        DetalDto detalDto = (DetalDto) createItemInfoDTO.getData();

        DataManagement.CreateIn createIn = new DataManagement.CreateIn();
        createIn.clientId = "AddDetalItem";

        DataManagement.CreateInput createInput = createIn.data;
        createInput.boName = detalDto.getCreateObjectType();
        createInput.stringProps.put("object_desc", detalDto.getName());
        createInput.stringProps.put("item_id", detalDto.getNumber());
        createInput.stringProps.put("object_name", detalDto.getNumber());

        DataManagement.CreateInput itemRevisionInput = new DataManagement.CreateInput();
        itemRevisionInput.boName = detalDto.getCreateObjectType().concat("Revision");
        itemRevisionInput.stringProps.put("va49_number", detalDto.getCode());
        itemRevisionInput.stringProps.put("item_revision_id", "00");    // TODO: исправить - принять из КОНСТАНТ

        createInput.compoundCreateInput.put("revision", new DataManagement.CreateInput[]{itemRevisionInput});
//        createInput.compoundCreateInput.put("revision", itemRevisionInput);

        DataManagement.CreateIn[] createObjectsInput = new DataManagement.CreateIn[]{createIn};

        return createObjectsInput;
    }

}
