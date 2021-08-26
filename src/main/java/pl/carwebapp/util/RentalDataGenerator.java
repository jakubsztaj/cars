package pl.carwebapp.util;

import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Component;
import pl.carwebapp.data.RenterRepository;
import pl.carwebapp.model.Renter;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static pl.carwebapp.util.CarDataGenerator.randomPersonalIdNumber;

@Component
public class RentalDataGenerator {

    private final RenterRepository renterRepository;

    private final List<String> names = ImmutableList.of("Adam", "Tomasz", "Bartosz", "Bartłomiej", "Dawid", "Krzysztof", "Cezary");
    private final List<String> lastNames = ImmutableList.of("Adamski", "Tomski", "Bartczak", "Bartodziej", "Dawidowicz", "Kowalski", "Czajka");

    public RentalDataGenerator(RenterRepository renterRepository) {
        this.renterRepository = renterRepository;
    }

    @PostConstruct
    public void generateRenters() {
        long count = renterRepository.count();
        if (count == 0) {
            List<Renter> renters = IntStream.range(0, 50)
                    .mapToObj(i -> new Renter(randomOfList(names), randomOfList(lastNames), randomPersonalIdNumber()))
                    .collect(Collectors.toList());
            renterRepository.saveAll(renters);
        }
    }

    private String randomOfList(List<String> strings) {
        return strings.get(ThreadLocalRandom.current().nextInt(0, strings.size()));
    }
}
