package ru.skilllbox.diplom.group40.social.service.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.skilllbox.diplom.group40.social.service.dto.PersonDto;
import ru.skilllbox.diplom.group40.social.service.dto.drawing.DrawingDto;

import java.util.UUID;

@RequestMapping("api/v1/test")
public interface PersonResourse {

    @GetMapping(value = "/drawing")
    void createDrawing(@RequestBody DrawingDto drawingDto);
//    PersonDto getById(@PathVariable(name = "id") UUID id);

    @GetMapping(value = "/drawing1")
    void createDrawing1(@RequestBody DrawingDto drawingDto);

}
