package oop.exams.generator;

import oop.exams.model.Region;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LicensePlateGeneratorFactoryTest {

    private LicensePlateGeneratorFactory licensePlateGeneratorFactory;

    @BeforeEach
    public void setup(){
        licensePlateGeneratorFactory = new LicensePlateGeneratorFactory();
    }

    @Test
    public void givenANorthRegionState_whenGetInstance_thenNorthRegionGeneratorIsReturned() {
        // Given:
        String []northStates = {"BCN", "BCS", "CHH", "COA", "NLE", "SON", "TAM"};

        for(String state: northStates) {
            // When:
            LicensePlateGenerator instance = licensePlateGeneratorFactory.getInstance(state);
            LicensePlateGenerator instanceWithRegion = licensePlateGeneratorFactory.getInstance(Region.NORTH);

            // Then:
            assertThat(instance).isInstanceOf(NorthLicensePlateGenerator.class);
            assertThat(instanceWithRegion).isInstanceOf(NorthLicensePlateGenerator.class);
        }
    }

    @Test
    public void givenASouthRegionState_whenGetInstance_thenSouthRegionGeneratorIsReturned() {
        // Given:
        String []southStates = {"CHP", "GRO", "MIC", "OAX"};

        for(String state: southStates) {
            // When:
            LicensePlateGenerator instance = licensePlateGeneratorFactory.getInstance(state);
            LicensePlateGenerator instanceWithRegion = licensePlateGeneratorFactory.getInstance(Region.SOUTH);

            // Then:
            assertThat(instance).isInstanceOf(SouthLicensePlateGenerator.class);
            assertThat(instanceWithRegion).isInstanceOf(SouthLicensePlateGenerator.class);
        }
    }

    @Test
    public void givenAEastRegionState_whenGetInstance_thenEastRegionGeneratorIsReturned() {
        // Given:
        String []eastStates = {"CAM", "ROO", "TAB", "VER", "YUC"};

        for(String state: eastStates) {
            // When:
            LicensePlateGenerator instance = licensePlateGeneratorFactory.getInstance(state);
            LicensePlateGenerator instanceWithRegion = licensePlateGeneratorFactory.getInstance(Region.EAST);

            // Then:
            assertThat(instance).isInstanceOf(EastLicensePlateGenerator.class);
            assertThat(instanceWithRegion).isInstanceOf(EastLicensePlateGenerator.class);
        }
    }

    @Test
    public void givenAWestRegionState_whenGetInstance_thenWestRegionGeneratorIsReturned() {
        // Given:
        String []westStates = {"COL", "JAL", "NAY", "SIN"};

        for(String state: westStates) {
            // When:
            LicensePlateGenerator instance = licensePlateGeneratorFactory.getInstance(state);
            LicensePlateGenerator instanceWithRegion = licensePlateGeneratorFactory.getInstance(Region.WEST);

            // Then:
            assertThat(instance).isInstanceOf(WestLicensePlateGenerator.class);
            assertThat(instanceWithRegion).isInstanceOf(WestLicensePlateGenerator.class);
        }
    }

    @Test
    public void givenACenterRegionState_whenGetInstance_thenCenterGeneratorIsReturned() {
        // Given:
        String []centerStates = {"AGU", "CMX", "DUR", "GUA", "HID", "MEX", "PUE", "QUE", "SLP", "TLA", "ZAC"};

        for(String state: centerStates) {
            // When:
            LicensePlateGenerator instance = licensePlateGeneratorFactory.getInstance(state);
            LicensePlateGenerator instanceWithRegion = licensePlateGeneratorFactory.getInstance(Region.CENTER);

            // Then:
            assertThat(instance).isInstanceOf(CenterLicensePlateGenerator.class);
            assertThat(instanceWithRegion).isInstanceOf(CenterLicensePlateGenerator.class);
        }
    }
}