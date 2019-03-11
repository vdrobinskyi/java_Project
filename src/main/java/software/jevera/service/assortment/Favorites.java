package software.jevera.service.assortment;

import software.jevera.domain.Assortment;

public class Favorites extends AssortmentState {

    //Переходит в REMOVE(удалить),
    //            IN_THE_BASKET(в корзине)

    @Override
    public AssortmentStateEnum getStatus() {
        return AssortmentStateEnum.FAVORITES;
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
