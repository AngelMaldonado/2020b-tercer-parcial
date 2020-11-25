package oop.exams.generator;

import oop.exams.exception.BadRegionException;

import java.util.ArrayList;
import java.util.Random;

public class SouthLicensePlateGenerator implements LicensePlateGenerator{
    private ArrayList<String> allowedStateCodes = new ArrayList<>();

    public SouthLicensePlateGenerator() {
        allowedStateCodes.add("CHP");
        allowedStateCodes.add("GRO");
        allowedStateCodes.add("MIC");
        allowedStateCodes.add("OAX");
    }

    @Override
    public String generate(String state) throws BadRegionException {
        String sequence = new String();
        Random random = new Random();

        try {
            validateStateCode(state);
        } catch(BadRegionException e) {
            throw e;
        }

        int randomIndex = random.nextInt(4) + 1;

        for (int i = 0; i < 3; i++) {
            sequence = sequence + random.nextInt(9);
        }

        StringBuffer generatedPlate = new StringBuffer("4" + sequence);

        generatedPlate.insert(randomIndex, state);

        return generatedPlate.toString();
    }

    public void validateStateCode(String state) throws BadRegionException{
        if (allowedStateCodes.contains(state)) {
            return;
        }
        throw new BadRegionException("Allowed state codes: CHP, GRO, MIC, OAX");
    }
}
