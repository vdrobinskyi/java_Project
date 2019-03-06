package assortment;

import domain.Assortment;

public class Sales extends AssortmentState {
    @Override
    public AssortmentStateEnum getStatus() {
        return AssortmentStateEnum.SALES;
    }

    @Override
    public void remove(Assortment assortment) {
        assortment.setStatus(AssortmentStateEnum.REMOVE);
    }
}
