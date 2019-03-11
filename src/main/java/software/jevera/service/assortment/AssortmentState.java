package software.jevera.service.assortment;

import software.jevera.domain.Assortment;
import software.jevera.domain.Purchase;
import software.jevera.exceptions.StateTransitionException;

public abstract class AssortmentState {

    private void noStateTransition(Assortment assortment){
        throw new StateTransitionException("StateTransitionException Error" + assortment);
    }

    public abstract AssortmentStateEnum getStatus();

    public void upload(Assortment assortment){
        noStateTransition(assortment);
    }

    public void inTheBasket(Assortment assortment){
        noStateTransition(assortment);
    }

    public void favorites(Assortment assortment){
        noStateTransition(assortment);
    }

    public void sales(Assortment assortment){
        noStateTransition(assortment);
    }

    public void remove(Assortment assortment){
        noStateTransition(assortment);
    }

    public void usePurchase(Assortment assortment, Purchase purchase){
        throw new IllegalStateException(getStatus().name());
    }
}