package software.jevera.domain;

public class Purchase {
    private Assortment assortment;
    private User user;
    private Integer amount;

    public Purchase(Assortment assortment, User user, Integer amount) {
        this.assortment = assortment;
        this.user = user;
        this.amount = amount;
    }

    public Assortment getAssortment() {
        return assortment;
    }

    public void setAssortment(Assortment assortment) {
        this.assortment = assortment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
