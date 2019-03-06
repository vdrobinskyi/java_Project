package assortment;

import domain.Assortment;

public class InTheBasket extends AssortmentState {

    //Переходит в FAVORITES(избранное),
    //            SALES(куплено),
    //            REMOVE(удалить)


    @Override
    public AssortmentStateEnum getStatus() {
        return AssortmentStateEnum.IN_THE_BASKET;
    }

    @Override
    public void favorites(Assortment assortment) {
        assortment.setStatus(AssortmentStateEnum.FAVORITES);
    }

    @Override
    public void sales(Assortment assortment) {
//        assortment.getPurchases(). хз как правильно писать
        assortment.setStatus(AssortmentStateEnum.SALES);
    }

    @Override
    public void remove(Assortment assortment) {
        assortment.setStatus(AssortmentStateEnum.REMOVE);
    }
}
