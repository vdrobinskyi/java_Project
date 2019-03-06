package service.assortment;

import domain.Assortment;
import domain.Purchase;

public class Upload extends AssortmentState {

    //Переходит в FAVORITES(избранное),
    //            IN_THE_BASKET(в корзине),
    //            REMOVE(удалить)

    @Override
    public AssortmentStateEnum getStatus() {
        return AssortmentStateEnum.UPLOAD;
    }

    @Override
    public void favorites(Assortment assortment) {
        assortment.setStatus(AssortmentStateEnum.FAVORITES);
    }

    @Override
    public void remove(Assortment assortment) {
        assortment.setStatus(AssortmentStateEnum.REMOVE);
    }

    @Override
    public void inTheBasket(Assortment assortment) {
        assortment.setStatus(AssortmentStateEnum.IN_THE_BASKET);
    }
}
