package oop.exams.generator;

import oop.exams.exception.BadRegionException;

import java.util.ArrayList;
import java.util.Random;

public class NorthLicensePlateGenerator implements LicensePlateGenerator {
    private ArrayList<String> allowedStateCodes = new ArrayList<>();

    public NorthLicensePlateGenerator() {
        allowedStateCodes.add("BCN");
        allowedStateCodes.add("BCS");
        allowedStateCodes.add("CHH");
        allowedStateCodes.add("COA");
        allowedStateCodes.add("NLE");
        allowedStateCodes.add("SON");
        allowedStateCodes.add("TAM");
    }

    @Override
    public String generate(String state) throws BadRegionException{
        String sequence = "";
        Random random = new Random();

        for (int i = 0; i < 2; i++) {
            sequence = sequence + random.nextInt(9);
        }

        try {
            validateStateCode(state);
        } catch(BadRegionException e) {
            throw e;
        }
        return '1' + state + sequence;
    }

    public void validateStateCode(String state) throws BadRegionException{
        if (allowedStateCodes.contains(state)) {
            return;
        }
        throw new BadRegionException("Allowed state codes: BCN, BCS, CHH, COA, NLE, SON, TAM");
    }
}
