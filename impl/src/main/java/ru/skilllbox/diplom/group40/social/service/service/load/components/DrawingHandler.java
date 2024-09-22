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

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class DrawingHandler implements ItemHandler {

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
    public Type /*String*/ myType() {
        return Type.VA49_SI_Drawing;
//        return Type.VA49_SI_Drawing.toString();
    }

    @Override
    public DataManagement.CreateIn[] getCreateIn(Object object) {

        DrawingDto drawingDto = (DrawingDto) object;

        DataManagement.CreateIn createIn = new DataManagement.CreateIn();
        createIn.clientId = "AddDrawingItem";

        DataManagement.CreateInput createInput = createIn.data;
        createInput.boName = drawingDto.getCreateObjectType();
        createInput.stringProps.put("object_desc", drawingDto.getName());
        createInput.stringProps.put("item_id", drawingDto.getNumber());
        createInput.stringProps.put("object_name", drawingDto.getNumber());

        DataManagement.CreateInput itemRevisionInput = new DataManagement.CreateInput();
        itemRevisionInput.boName = drawingDto.getCreateObjectType().concat("Revision");
        itemRevisionInput.stringProps.put("va49_number", drawingDto.getCode());
        itemRevisionInput.stringProps.put("item_revision_id", "00");    // TODO: исправить - принять из КОНСТАНТ

        createInput.compoundCreateInput.put("revision", new DataManagement.CreateInput[]{itemRevisionInput});
//        createInput.compoundCreateInput.put("revision", itemRevisionInput);

        DataManagement.CreateIn[] createObjectsInput = new DataManagement.CreateIn[]{createIn};

        return createObjectsInput;
    }

    private DataManagement.CreateIn[] getCreateIn1(String itemType, DrawingDto drawingDto) {

        DataManagement.CreateIn createIn = new DataManagement.CreateIn();
        createIn.clientId = "AddDrawingItem";

        DataManagement.CreateInput createInput = createIn.data;
        createInput.boName = drawingDto.getCreateObjectType();
        createInput.stringProps.put("object_desc", drawingDto.getName());
        createInput.stringProps.put("item_id", drawingDto.getNumber());
        createInput.stringProps.put("object_name", drawingDto.getNumber());

        DataManagement.CreateInput itemRevisionInput = new DataManagement.CreateInput();
        itemRevisionInput.boName = drawingDto.getCreateObjectType().concat("Revision");
        itemRevisionInput.stringProps.put("va49_number", drawingDto.getCode());
        itemRevisionInput.stringProps.put("item_revision_id", "00");    // TODO: исправить - принять из КОНСТАНТ

        createInput.compoundCreateInput.put("revision", new DataManagement.CreateInput[]{itemRevisionInput});
//        createInput.compoundCreateInput.put("revision", itemRevisionInput);

        DataManagement.CreateIn[] createObjectsInput = new DataManagement.CreateIn[]{createIn};

        return createObjectsInput;
    }

    @Override
    public DataManagement.CreateIn[] getCreateIn(CreateItemInfoDTO createItemInfoDTO) {

        DrawingDto drawingDto = (DrawingDto) createItemInfoDTO.getData();

        DataManagement.CreateIn createIn = new DataManagement.CreateIn();
        createIn.clientId = "AddDrawingItem";

        DataManagement.CreateInput createInput = createIn.data;
        createInput.boName = drawingDto.getCreateObjectType();
        createInput.stringProps.put("object_desc", drawingDto.getName());
        createInput.stringProps.put("item_id", drawingDto.getNumber());
        createInput.stringProps.put("object_name", drawingDto.getNumber());

        DataManagement.CreateInput itemRevisionInput = new DataManagement.CreateInput();
        itemRevisionInput.boName = drawingDto.getCreateObjectType().concat("Revision");
        itemRevisionInput.stringProps.put("va49_number", drawingDto.getCode());
        itemRevisionInput.stringProps.put("item_revision_id", "00");    // TODO: исправить - принять из КОНСТАНТ

        createInput.compoundCreateInput.put("revision", new DataManagement.CreateInput[]{itemRevisionInput});
//        createInput.compoundCreateInput.put("revision", itemRevisionInput);

        DataManagement.CreateIn[] createObjectsInput = new DataManagement.CreateIn[]{createIn};

        return createObjectsInput;
    }

}
