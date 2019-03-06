package service.assortment;

import domain.Assortment;

import static service.assortment.AssortmentStateEnum.NEW;
import static service.assortment.AssortmentStateEnum.UPLOAD;


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
