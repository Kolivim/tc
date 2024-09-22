package ru.skilllbox.diplom.group40.social.service.dto.drawing;

import lombok.Data;
import ru.skilllbox.diplom.group40.social.service.dto.business.object.Type;

@Data
public class DrawingDto {

    String code;
    String name;
    String number;
    String createObjectType;
    Type createObjectType1;

}
