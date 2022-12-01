package pl.edu.wszib.pages;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.edu.wszib.pages.repository.ItemRepository;
import pl.edu.wszib.pages.repository.entity.ItemEntity;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Configuration
@AllArgsConstructor
public class MainConfiguration {
    private final ItemRepository repository;

    @Bean
    public CommandLineRunner init() {
        return args -> {
            List<ItemEntity> entities = Stream.generate(() -> new ItemEntity(UUID.randomUUID(), UUID.randomUUID().toString()))
                    .limit(100)
                    .toList();

            repository.saveAllAndFlush(entities);
        };
    }
}
