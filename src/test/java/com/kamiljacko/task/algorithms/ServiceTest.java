package com.kamiljacko.task.algorithms;

import com.google.common.collect.Iterables;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ServiceTest {

    private Repository repository;
    private Service service;

    @BeforeEach
    public void setUp() {
        this.repository = Mockito.mock(Repository.class);
        this.service = new Service(repository);
    }

    @Test
    public void shouldReturnNumberInBinarySystem() {
        int number = 55;
        String expectedNumber = "110111";

        String numberInBinarySystem = service.getNumberInBinarySystem(number);

        assertEquals(expectedNumber, numberInBinarySystem);
    }

    @Test
    public void shouldSwitchDigitsReturnInOctalSystem() {
        int number = 55;
        String expectedNumber = "10";

        String switchedDigitsInOctalSystem = service.getSwitchedDigitsInOctalSystem(number);

        assertEquals(expectedNumber, switchedDigitsInOctalSystem);
    }

    @Test
    public void shouldReverseDigitsReturnHexadecimalSystem() {
        int number = 55;
        String expectedNumber = "3B";

        String reversedDigitsInHexadecimalSystem = service.getReversedDigitsInHexadecimalSystem(number);

        assertEquals(expectedNumber, reversedDigitsInHexadecimalSystem);
    }

    @Test
    public void shouldMoveOnesToLeftZerosTORightReturnDecimalSystem() {
        int number = 55;
        String expectedNumber = "62";

        String onesOnLeftZerosOnRightReturnDecimal = service.getOnesOnLeftZerosOnRightReturnDecimal(number);

        assertEquals(expectedNumber, onesOnLeftZerosOnRightReturnDecimal);
    }

    @Test
    public void shouldSaveTwoEntitiesInDatabase() {
        int expectedNumberOfSavedEntities = 2;
        Entity entity = new Entity();

        when(repository.findAll()).thenReturn(Arrays.asList(entity, entity));
        List<Entity> entities = service.getAllEntities();

        assertEquals(expectedNumberOfSavedEntities, entities.size());
    }

    @Test
    public void shouldRetrieveSavedNumbersFromDatabase() {
        int entityInput = 55;
        String entityOutput = "110111";
        Entity entity = new Entity();
        entity.setInput(entityInput);
        entity.setOutput(entityOutput);

        when(repository.findAll()).thenReturn(Collections.singletonList(entity));
        List<Entity> entities = service.getAllEntities();

        Entity retrievedEntity = Iterables.getOnlyElement(entities);
        assertEquals(entityInput, retrievedEntity.getInput());
        assertEquals(entityOutput, retrievedEntity.getOutput());
    }

}