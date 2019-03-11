package software.jevera.service.assortment;

import software.jevera.domain.Assortment;

import static software.jevera.service.assortment.AssortmentStateEnum.NEW;
import static software.jevera.service.assortment.AssortmentStateEnum.UPLOAD;


public class New extends AssortmentState {

    // Переходит только в UPLOAD(загружено)

    @Override
    public AssortmentStateEnum getStatus() {
        return NEW;
    }

    @Override
    public void upload(Assortment assortment) {
        assortment.setStatus(UPLOAD);
    }
}
