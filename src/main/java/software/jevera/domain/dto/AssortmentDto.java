package software.jevera.domain.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class AssortmentDto {
    @Length(max = 40, min = 2)
    private String name;
    @Length(max = 300)
    private String description;
    private Integer price;

}
