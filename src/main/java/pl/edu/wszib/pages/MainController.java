package pl.edu.wszib.pages;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wszib.pages.dto.Item;
import pl.edu.wszib.pages.dto.Page;
import pl.edu.wszib.pages.repository.ItemRepository;

@RequestMapping("/item")
@RestController
@AllArgsConstructor
public class MainController {
    private final ItemRepository repository;

    @GetMapping
    public Page<Item> getAll(
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "0") int page
    ) {
        var items = repository.findAll(Pageable.ofSize(pageSize).withPage(page))
                .map(
                        entity -> Item.builder()
                                .id(entity.getId())
                                .message(entity.getMessage())
                                .build()
                );

        return Page.<Item>builder()
                .items(items.getContent())
                .totalElements(items.getTotalElements())
                .build();
    }
}
