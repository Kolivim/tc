package ru.skilllbox.diplom.group40.social.service.resource;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.skilllbox.diplom.group40.social.service.dto.CreateItemInfoDTO;
import ru.skilllbox.diplom.group40.social.service.dto.PersonDto;
import ru.skilllbox.diplom.group40.social.service.dto.business.object.Type;
import ru.skilllbox.diplom.group40.social.service.dto.drawing.DrawingDto;
import ru.skilllbox.diplom.group40.social.service.service.load.LoadService;

import java.util.UUID;

/**
 * PersonResourceImpl
 *
 * @author Your name
 */

@Getter
@Setter
@RestController
@RequiredArgsConstructor
public class PersonResourceImpl implements PersonResourse {

    private final LoadService loadService;

//    @Override
//    public PersonDto getById(UUID id) {
//        return null;
//    }

    @Override
    public void createDrawing(@RequestBody DrawingDto drawingDto) {
        loadService.create(drawingDto);
    }

    @Override
    public void createDrawing1(@RequestBody DrawingDto drawingDto) {

        CreateItemInfoDTO createItemInfoDTO = new CreateItemInfoDTO<>();
        createItemInfoDTO.setData(drawingDto);
        createItemInfoDTO.setType1("VA49_SI_Drawing");
        createItemInfoDTO.setType(Type.VA49_SI_Drawing);

        loadService.create(createItemInfoDTO);
    }

}
