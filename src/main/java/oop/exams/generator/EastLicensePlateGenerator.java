package oop.exams.generator;

import oop.exams.exception.BadRegionException;

import java.util.ArrayList;
import java.util.Random;

public class EastLicensePlateGenerator implements LicensePlateGenerator {
    private ArrayList<String> allowedStateCodes = new ArrayList<>();

    public EastLicensePlateGenerator() {
        allowedStateCodes.add("CAM");
        allowedStateCodes.add("ROO");
        allowedStateCodes.add("TAB");
        allowedStateCodes.add("VER");
        allowedStateCodes.add("YUC");
    }

    @Override
    public String generate(String state) throws BadRegionException {
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

        return '3' + sequence + 'Z';
    }

    public void validateStateCode(String state) throws BadRegionException{
        if (allowedStateCodes.contains(state)) {
            return;
        }
        throw new BadRegionException("Allowed state codes: CAM, ROO, TAB, VER, YUC");
    }
}
