package com.kamiljacko.task.algorithms;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/algorithms")
public class Resource {

    public static final String JSON_PREFIX = "{\"result\": \"";
    public static final String JSON_SUFFIX = "\"}";

    private final Service service;

    public Resource(Service service) {
        this.service = service;
    }

    @GetMapping("/v1/{number}")
    public String getNumberInBinarySystem(@PathVariable int number) {
        service.saveNumberInBinarySystem(number);
        return JSON_PREFIX + service.getNumberInBinarySystem(number) + JSON_SUFFIX;
    }

    @GetMapping("/v2/{number}")
    public String getSwitchedDigitsInOctalSystem(@PathVariable int number) {
        service.saveSwitchedDigitsInOctalSystem(number);
        return JSON_PREFIX + service.getSwitchedDigitsInOctalSystem(number) + JSON_SUFFIX;
    }

    @GetMapping("/v3/{number}")
    public String getReversedDigitsInHexadecimalSystem(@PathVariable int number) {
        service.saveReversedDigitsInHexadecimalSystem(number);
        return JSON_PREFIX + service.getReversedDigitsInHexadecimalSystem(number) + JSON_SUFFIX;
    }

    @GetMapping("/v4/{number}")
    public String getOnesOnLeftZerosOnRightReturnDecimal(@PathVariable int number) {
        service.saveOnesOnLeftZerosOnRightReturnDecimal(number);
        return JSON_PREFIX + service.getOnesOnLeftZerosOnRightReturnDecimal(number) + JSON_SUFFIX;
    }

    @GetMapping("/results")
    public List<String> getAllResults() {
        return service.getAllEntities().stream().map(Entity::getOutput).collect(Collectors.toList());
    }

}
