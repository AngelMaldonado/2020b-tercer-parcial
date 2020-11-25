package oop.exams.generator;

import oop.exams.exception.BadRegionException;
import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CenterLicensePlateGeneratorTest {

    @Test
    public void givenACenterState_whenGenerate_thenLicensePlateStartsWith1() {

        // Given:
        LicensePlateGenerator licensePlateProvider = new CenterLicensePlateGenerator();
        String state = "SLP";

        // When:
        String licensePlate = licensePlateProvider.generate(state);

        // Then:
        assertThat(licensePlate).startsWith("5");
        assertThat(licensePlate).hasSize(8);
        assertThat(licensePlate).containsOnlyDigits();
    }

    @Test
    public void givenACenterState_whenGenerateTwice_thenLicensesAreDifferent() {

        // Given:
        LicensePlateGenerator licensePlateProvider = new CenterLicensePlateGenerator();

        // When:
        String licensePlate1 = licensePlateProvider.generate("ZAC");
        String licensePlate2 = licensePlateProvider.generate("ZAC");

        // Then:
        assertThat(licensePlate1).isNotEqualTo(licensePlate2);
    }

    @Test
    public void givenANonCenterState_whenGenerate_thenBadRegionExceptionIsThrown() {

        // Given:
        LicensePlateGenerator licensePlateProvider = new CenterLicensePlateGenerator();
        String randomStateAbbreviation = "X" + RandomString.make(2);

        // When:
        // Then:
        assertThatThrownBy(() -> licensePlateProvider.generate(randomStateAbbreviation))
                .isInstanceOf(BadRegionException.class)
                .hasMessage("Allowed state codes: AGU, CMX, DUR, GUA, HID, MEX, PUE, QUE, SLP, TLA, ZAC");
    }
}
