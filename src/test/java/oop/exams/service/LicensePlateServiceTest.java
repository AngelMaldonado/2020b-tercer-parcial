package oop.exams.service;


import oop.exams.exception.NotAvailableLicensePlateException;
import oop.exams.generator.LicensePlateGenerator;
import oop.exams.generator.LicensePlateGeneratorFactory;
import oop.exams.model.Region;
import oop.exams.repository.LicensePlateRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class LicensePlateServiceTest {

    @Test
    public void givenAValidState_whenGenerate_thenLicensePlateIsReturned() throws NotAvailableLicensePlateException {
        // Given:
        LicensePlateGeneratorFactory factory = mock(LicensePlateGeneratorFactory.class);
        LicensePlateRepository repository = mock(LicensePlateRepository.class);
        LicensePlateGenerator generator = mock(LicensePlateGenerator.class);
        LicensePlateService licensePlateService = new LicensePlateService(factory, repository);
        String state = "SLP";
        String expectedLicensePlate = "ABC1234";

        when(repository.getRegionByState(state)).thenReturn(Region.CENTER);
        when(repository.countByRegion(Region.CENTER)).thenReturn(1);
        when(factory.getInstance(Region.CENTER)).thenReturn(generator);
        when(generator.generate(state)).thenReturn(expectedLicensePlate);

        // When:
        String licensePlate = licensePlateService.generate(state);

        // Then:
        assertThat(licensePlate).isEqualTo(expectedLicensePlate);
        verify(repository).getRegionByState(state);
        verify(repository).countByRegion(Region.CENTER);
        verify(factory).getInstance(Region.CENTER);
        verify(generator).generate(state);
        verify(repository).save(Region.CENTER, licensePlate);
        verifyNoMoreInteractions(repository, factory, generator);
    }

    /*
    @Test
    public void givenAValidState_whenGenerateWithFullPlates_thenNotAvailableLicensePlateExceptionIsReturned() throws NotAvailableLicensePlateException {
        // Given:
        LicensePlateGeneratorFactory factory = mock(LicensePlateGeneratorFactory.class);
        LicensePlateRepository repository = mock(LicensePlateRepository.class);
        LicensePlateGenerator generator = mock(LicensePlateGenerator.class);
        LicensePlateService licensePlateService = new LicensePlateService(factory, repository);
        String state = "SLP";
        String[]states = {"QUE", "CMX", "HID", "DUR", "PUE"};
        String[]expectedLicensePlates = {"ABC1234", "ABC1235", "ABC1236", "ABC1237", "ABC1238"};

        for(int i = 0; i < 5; i++) {
            when(repository.getRegionByState(states[i])).thenReturn(Region.CENTER);
            when(repository.countByRegion(Region.CENTER)).thenReturn(1);
            when(factory.getInstance(Region.CENTER)).thenReturn(generator);
            when(generator.generate(states[i])).thenReturn(expectedLicensePlates[i]);
        }

        // When:
        String []licensePlates = new String[5];
        for(int i = 0; i < 5; i++) {
            licensePlates[i] = licensePlateService.generate(states[i]);
        }
        // Then:
        /*
        for(int i = 0; i < 5; i++) {
            assertThat(licensePlates[i]).isEqualTo(expectedLicensePlates[i]);
            verify(repository).getRegionByState(states[i]);
            //verify(repository).countByRegion(Region.CENTER);
            //verify(factory).getInstance(Region.CENTER);
            verify(generator).generate(states[i]);
            verify(repository).save(Region.CENTER, licensePlates[i]);
            //verifyNoMoreInteractions(repository, factory, generator);
        }
        verify(repository).countByRegion(Region.CENTER);
        verify(factory).getInstance(Region.CENTER);
        verifyNoMoreInteractions(repository, factory, generator);
        assertThatThrownBy(() -> licensePlateService.generate(state))
                .isInstanceOf(BadRegionException.class)
                .hasMessage("Licencias no disponibles en region");

        verify(generator).generate(state);
        verify(repository).save(Region.CENTER, licensePlate);
        verifyNoMoreInteractions(repository, factory, generator);
    }
    */
}