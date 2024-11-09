package com.aiTech.aispring.controller;


import com.aiTech.aispring.entity.Option;
import com.aiTech.aispring.service.IService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Option")
public class OptionController {


    public IService<Option> OptionService;


    // http://localhost:8081/projet/Option/retrieve-all-Options
    @Operation(description = "Ce web service permet de récupérer toutes les Options de la base de données")
    @GetMapping("/retrieve-all-Options")
    public List<Option> getOptions() {
        List<Option> listOptions = OptionService.retrieveAll();

        return listOptions;
    }

    // http://localhost:8081/projet/Option/retrieve-Option/8
    @GetMapping("/retrieve-Option/{Option-id}")
    public Option retrieveOption(@PathVariable("Option-id") String id) {
        Option Option = OptionService.retrieve(id);
        return Option;
    }

    // http://localhost:8081/projet/Option/add-Option
    @PostMapping("/add-Option")
    public Option addOption(@RequestBody Option c) {
        Option Option = OptionService.add(c);
        return Option;
    }

    // http://localhost:8081/projet/Option/remove-Option/{Option-id}
    @DeleteMapping("/remove-Option/{Option-id}")
    public void removeOption(@PathVariable("Option-id") String id) {
        OptionService.remove(id);
    }

    // http://localhost:8081/projet/Option/modify-Option
    @PutMapping("/modify-Option")
    public Option modifyOption(@RequestBody Option c) {
        Option Option = OptionService.modify(c);
        return Option;
    }
}

