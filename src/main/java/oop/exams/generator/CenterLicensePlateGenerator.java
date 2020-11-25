package oop.exams.generator;

import oop.exams.exception.BadRegionException;

import java.util.ArrayList;
import java.util.Random;

public class CenterLicensePlateGenerator implements LicensePlateGenerator {
    private ArrayList<String> allowedStateCodes = new ArrayList<>();

    public CenterLicensePlateGenerator() {
        allowedStateCodes.add("AGU");
        allowedStateCodes.add("CMX");
        allowedStateCodes.add("DUR");
        allowedStateCodes.add("GUA");
        allowedStateCodes.add("HID");
        allowedStateCodes.add("MEX");
        allowedStateCodes.add("PUE");
        allowedStateCodes.add("QUE");
        allowedStateCodes.add("SLP");
        allowedStateCodes.add("TLA");
        allowedStateCodes.add("ZAC");
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

        for (int i = 0; i < 7; i++) {
            sequence = sequence + random.nextInt(9);
        }
        return '5' + sequence;
    }

    public void validateStateCode(String state) throws BadRegionException{
        if (allowedStateCodes.contains(state)) {
            return;
        }
        throw new BadRegionException("Allowed state codes: AGU, CMX, DUR, GUA, HID, MEX, PUE, QUE, SLP, TLA, ZAC");
    }
}
