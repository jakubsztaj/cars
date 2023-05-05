package pl.carwebapp.util;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import pl.carwebapp.data.UserRepository;
import pl.carwebapp.model.User;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static pl.carwebapp.util.DataGenerator.randomPersonalIdNumber;
import static pl.carwebapp.util.DataGenerator.randomPhoneNumber;


@Component
public class UserDataGenerator {

    private final UserRepository userRepository;

    private final List<String> names = List.of("Adam", "Tomasz", "Bartosz", "Bartłomiej", "Dawid", "Krzysztof", "Cezary");
    private final List<String> lastNames = List.of("Adamski", "Tomski", "Bartczak", "Bartodziej", "Dawidowicz", "Kowalski", "Czajka");
    private final List<String> placeOfResidence = List.of("Belchatow", "Borowa", "Bogdanow", "Mosczenica", "Piotrkow", "Lodz", "Zelow", "Szczercow");

    private final List<String> login = List.of("test1", "test2", "test3", "test4");

    private final List<String> password = List.of("test5", "test6", "test7", "test8");

    public UserDataGenerator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void generateRenters() {
        long count = userRepository.count();
        if (count == 0) {
            List<User> users = IntStream.range(0, 50)
                    .mapToObj(i -> new User(randomOfList(names), randomOfList(lastNames), randomOfList(placeOfResidence), randomPersonalIdNumber(), randomPhoneNumber(), randomOfList(login), randomOfList(password)))
                    .collect(Collectors.toList());
            userRepository.saveAll(users);
        }
    }

    private String randomOfList(List<String> strings) {
        return strings.get(ThreadLocalRandom.current().nextInt(0, strings.size()));
    }
}
