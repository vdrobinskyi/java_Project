package software.jevera.domain.dto;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import software.jevera.domain.Assortment;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-04-08T22:59:12+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11.0.1 (Oracle Corporation)"
)
@Component
public class AssortmentMapperImpl implements AssortmentMapper {

    @Override
    public Assortment toAssortment(AssortmentDto assortmentDto) {
        if ( assortmentDto == null ) {
            return null;
        }

        Assortment assortment = new Assortment();

        assortment.setName( assortmentDto.getName() );
        assortment.setDescription( assortmentDto.getDescription() );
        assortment.setPrice( assortmentDto.getPrice() );

        return assortment;
    }
}
