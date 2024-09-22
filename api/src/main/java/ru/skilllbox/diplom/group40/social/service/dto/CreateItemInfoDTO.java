package ru.skilllbox.diplom.group40.social.service.dto;

import lombok.Data;
import ru.skilllbox.diplom.group40.social.service.dto.business.object.Type;

import java.util.UUID;

@Data
public class CreateItemInfoDTO<T> {

//    @Schema(description = "Тип полученного объекта data (MESSAGE/NOTIFICATION)")
    private String type1;
//    @Schema(description = "id пользователя, для которого отправляется уведомление")
//    private UUID recipientId;
//    @Schema(description = "Объект уведомления/сообщения")
//    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class")
    private T data;

    private Type type;
}
