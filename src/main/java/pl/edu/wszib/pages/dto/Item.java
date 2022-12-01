package pl.edu.wszib.pages.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class Item {
    UUID id;
    String message;
}
