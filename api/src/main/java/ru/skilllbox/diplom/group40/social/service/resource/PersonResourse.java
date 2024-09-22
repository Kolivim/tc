package ru.skilllbox.diplom.group40.social.service.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skilllbox.diplom.group40.social.service.dto.PersonDto;
import ru.skilllbox.diplom.group40.social.service.dto.drawing.DrawingDto;

import java.util.UUID;

@RequestMapping("api/v1/test")
public interface PersonResourse {

    @PostMapping(value = "/drawing")
    void createDrawing(@RequestBody DrawingDto drawingDto);
//    PersonDto getById(@PathVariable(name = "id") UUID id);

    @PostMapping(value = "/drawing1")
    void createDrawing1(@RequestBody DrawingDto drawingDto);

}
