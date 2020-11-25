package oop.exams.generator;

import oop.exams.exception.BadRegionException;

import java.util.ArrayList;
import java.util.Random;

public class WestLicensePlateGenerator implements LicensePlateGenerator{
    private ArrayList<String> allowedStateCodes = new ArrayList<>();

    public WestLicensePlateGenerator() {
        allowedStateCodes.add("COL");
        allowedStateCodes.add("JAL");
        allowedStateCodes.add("NAY");
        allowedStateCodes.add("SIN");
    }

    @Override
    public String generate(String state) throws BadRegionException {
        String sequence = "";
        Random random = new Random();

        try {
            validateStateCode(state);
        } catch(BadRegionException e) {
            throw e;
        }

        sequence = sequence + random.nextInt(9);

        return '2' + sequence + state;
    }

    public void validateStateCode(String state) throws BadRegionException{
        if (allowedStateCodes.contains(state)) {
            return;
        }
        throw new BadRegionException("Allowed state codes: COL, JAL, NAY, SIN");
    }
}
