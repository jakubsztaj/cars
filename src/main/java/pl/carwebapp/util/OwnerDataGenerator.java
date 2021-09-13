package pl.carwebapp.util;

import com.google.common.collect.ImmutableList;
import pl.carwebapp.data.OwnerRepository;
import pl.carwebapp.model.Owner;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static pl.carwebapp.util.CarDataGenerator.randomPersonalIdNumber;

public class OwnerDataGenerator {

    private final OwnerRepository ownerRepository;

    private final List<String> firstNames = ImmutableList.of("Krzysztof");
    private final List<String> lastNames = ImmutableList.of("Kowalski");

    public OwnerDataGenerator(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @PostConstruct
    public void generateOwners() {
        long count = ownerRepository.count();
        if (count == 0) {
            List<Owner> owners = IntStream.range(0, 20)
                    .mapToObj(i -> new Owner(randomOfList(firstNames), randomOfList(lastNames), randomPersonalIdNumber()))
                    .collect(Collectors.toList());
            ownerRepository.saveAll(owners);
        }
    }

    private String randomOfList(List<String> strings) {
        return strings.get(ThreadLocalRandom.current().nextInt(0, strings.size()));
    }
}
