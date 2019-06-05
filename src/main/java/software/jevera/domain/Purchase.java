package software.jevera.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Purchase {
    private Long id;
    private Product product;
    private User user;
    private Integer amount;
//
    public Purchase(Long id,Product product, User user, Integer amount) {
        this.id = id;
        this.product = product;
        this.user = user;
        this.amount = amount;
    }
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public Integer getAmount() {
//        return amount;
//    }
//
//    public void setAmount(Integer amount) {
//        this.amount = amount;
//    }
}
