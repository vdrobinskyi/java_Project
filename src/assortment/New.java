package assortment;

import domain.Assortment;

import static assortment.AssortmentStateEnum.*;

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
