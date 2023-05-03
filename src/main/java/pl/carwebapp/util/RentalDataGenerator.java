package pl.carwebapp.util;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import pl.carwebapp.data.RenterRepository;
import pl.carwebapp.model.Renter;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static pl.carwebapp.util.DataGenerator.randomPersonalIdNumber;
import static pl.carwebapp.util.DataGenerator.randomPhoneNumber;

@Component
public class RentalDataGenerator {

    private final RenterRepository renterRepository;

    private final List<String> names = List.of("Adam", "Tomasz", "Bartosz", "Bartłomiej", "Dawid", "Krzysztof", "Cezary");
    private final List<String> lastNames = List.of("Adamski", "Tomski", "Bartczak", "Bartodziej", "Dawidowicz", "Kowalski", "Czajka");
    private final List<String> placeOfResidence = List.of("Belchatow", "Borowa", "Bogdanow", "Mosczenica", "Piotrkow", "Lodz", "Zelow", "Szczercow");


    public RentalDataGenerator(RenterRepository renterRepository) {
        this.renterRepository = renterRepository;
    }

    @PostConstruct
    public void generateRenters() {
        long count = renterRepository.count();
        if (count == 0) {
            List<Renter> renters = IntStream.range(0, 50)
                    .mapToObj(i -> new Renter(randomOfList(names), randomOfList(lastNames), randomOfList(placeOfResidence), randomPersonalIdNumber(), randomPhoneNumber()))
                    .collect(Collectors.toList());
            renterRepository.saveAll(renters);
        }
    }

    private String randomOfList(List<String> strings) {
        return strings.get(ThreadLocalRandom.current().nextInt(0, strings.size()));
    }
}
