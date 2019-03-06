package service.assortment;

import domain.Assortment;
import domain.Purchase;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StateMachine {

    private final Map<AssortmentStateEnum, AssortmentState> states = new ConcurrentHashMap<>();

    public StateMachine(List<AssortmentState> assortmentStates){
        assortmentStates.forEach(state -> states.put(state.getStatus(), state));
    }

    private AssortmentState getState(Assortment assortment){
        return states.get(assortment.getStatus());
    }

    public void upload(Assortment assortment){
        getState(assortment).upload(assortment);
    }

    public void inTheBasket(Assortment assortment){
        getState(assortment).inTheBasket(assortment);
    }

    public void favorites(Assortment assortment){
        getState(assortment).favorites(assortment);
    }

    public void sales(Assortment assortment){
        getState(assortment).sales(assortment);
    }

    public void remove(Assortment assortment){
        getState(assortment).remove(assortment);
    }

    public void usePurchase(Assortment assortment, Purchase purchase){
        getState(assortment).usePurchase(assortment, purchase);
    }


}
