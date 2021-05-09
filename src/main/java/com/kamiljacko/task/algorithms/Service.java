package com.kamiljacko.task.algorithms;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    private Entity entity;
    private final Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public void saveNumberInBinarySystem(int number) {
        entity = queryEntity(number, getNumberInBinarySystem(number));
        repository.save(entity);
    }

    public String getNumberInBinarySystem(int number) {
        return Integer.toBinaryString(number);
    }

    public void saveSwitchedDigitsInOctalSystem(int number) {
        entity = queryEntity(number, getSwitchedDigitsInOctalSystem(number));
        repository.save(entity);
    }

    public String getSwitchedDigitsInOctalSystem(int number) {
        String stringBinaryNumber = getNumberInBinarySystem(number);
        stringBinaryNumber = stringBinaryNumber.replaceAll("0", "2");
        stringBinaryNumber = stringBinaryNumber.replaceAll("1", "0");
        stringBinaryNumber = stringBinaryNumber.replaceAll("2", "1");
        int switchedDigits = Integer.parseInt(stringBinaryNumber, 2);
        return Integer.toOctalString(switchedDigits);
    }

    public void saveReversedDigitsInHexadecimalSystem(int number) {
        entity = queryEntity(number, getReversedDigitsInHexadecimalSystem(number));
        repository.save(entity);
    }

    public String getReversedDigitsInHexadecimalSystem(int number) {
        String stringBinaryNumber = getNumberInBinarySystem(number);
        StringBuilder stringReversedDigits = new StringBuilder(stringBinaryNumber).reverse();
        int reversedDigits = Integer.parseInt(stringReversedDigits.toString(), 2);
        return Integer.toHexString(reversedDigits).toUpperCase();
    }

    public void saveOnesOnLeftZerosOnRightReturnDecimal(int number) {
        entity = queryEntity(number, getOnesOnLeftZerosOnRightReturnDecimal(number));
        repository.save(entity);
    }

    public String getOnesOnLeftZerosOnRightReturnDecimal(int number) {
        String stringBinaryNumber = getNumberInBinarySystem(number);
        long countOnes = stringBinaryNumber.chars().filter(ch -> ch == '1').count();
        long countZeros = stringBinaryNumber.chars().filter(ch -> ch == '0').count();
        String ones = "1".repeat((int) countOnes);
        String zeros = "0".repeat((int) countZeros);

        return Integer.parseInt(ones + zeros, 2) + "";
    }

    public List<Entity> getAllEntities() {
        return repository.findAll();
    }

    private Entity queryEntity(int number, String algorithmResult) {
        entity = new Entity();
        entity.setInput(number);
        entity.setOutput("result: " + algorithmResult);
        return entity;
    }
}
