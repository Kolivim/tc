package ru.skilllbox.diplom.group40.social.service.service.load;

/*
import ru.skillbox.diplom.group40.social.network.api.dto.notification.NotificationDTO;
import ru.skillbox.diplom.group40.social.network.api.dto.notification.Type;
import ru.skillbox.diplom.group40.social.network.domain.notification.EventNotification;
*/

import com.teamcenter.services.strong.core._2008_06.DataManagement;
import ru.skilllbox.diplom.group40.social.service.dto.CreateItemInfoDTO;
import ru.skilllbox.diplom.group40.social.service.dto.business.object.Type;

import java.util.List;

public interface ItemHandler {

    List</*EventNotification*/ String> getEventNotificationList(/*NotificationDTO*/ String notificationDTO);

    DataManagement.CreateIn[] getCreateIn(Object object);

    DataManagement.CreateIn[] getCreateIn(CreateItemInfoDTO createItemInfoDTO);

    Type /*String*/ myType();

}

