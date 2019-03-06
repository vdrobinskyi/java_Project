package domain;

import assortment.AssortmentStateEnum;
import assortment.AssortmentStateEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static assortment.AssortmentStateEnum.NEW;
import static assortment.AssortmentStateEnum.NEW;

public class Assortment {
    private Integer id;
    private String name;
    private String description;
    private Integer price;
    private Integer amount;
    private List<Purchase> purchases= new ArrayList<>();
    private AssortmentStateEnum status = NEW;
    private String kind;
    private User buyer;
    private User saler;

    public Assortment(){}

    public Assortment(Integer price, String name, String description, Integer amount) {
        this.price = price;
        this.name = name;
        this.description = description;
        this.amount = amount;
    }

    public Long getId() {
        return Long.valueOf(id);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public AssortmentStateEnum getStatus() {
        return status;
    }

    public void setStatus(AssortmentStateEnum status) {
        this.status = status;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public User getSaler() {
        return saler;
    }

    public void setSaler(User saler) {
        this.saler = saler;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assortment that = (Assortment) o;
        return Objects.equals(kind, that.kind);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kind);
    }
}
