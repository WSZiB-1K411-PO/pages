package pl.edu.wszib.pages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.wszib.pages.repository.entity.ItemEntity;

import java.util.UUID;

public interface ItemRepository extends JpaRepository<ItemEntity, UUID> {
}
