package software.jevera.domain.dto;

import org.mapstruct.Mapper;
import software.jevera.domain.Assortment;

@Mapper(componentModel = "spring")
public interface AssortmentMapper {
    Assortment toAssortment(AssortmentDto assortmentDto);
}
