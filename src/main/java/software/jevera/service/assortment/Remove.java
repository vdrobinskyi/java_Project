package software.jevera.service.assortment;

public class Remove extends AssortmentState {
    @Override
    public AssortmentStateEnum getStatus() {
        return AssortmentStateEnum.REMOVE;
    }
}
