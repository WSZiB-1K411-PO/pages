package pl.edu.wszib.pages.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;

import java.util.List;

@Value
@Builder
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class Page<T> {
    @Singular
    List<T> items;
    long totalElements;
}
