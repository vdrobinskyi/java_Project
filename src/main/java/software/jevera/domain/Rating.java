package software.jevera.domain;

import lombok.*;
@Setter @Getter
@EqualsAndHashCode(of = "id")
@ToString
public class Rating {
    private Long id;
    private User author;
    private String text;
    private Assortment assortment;

    public Rating(User author, String text, Assortment assortment) {
        this.author = author;
        this.text = text;
        this.assortment = assortment;
    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public User getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(User author) {
//        this.author = author;
//    }
//
//    public String getText() {
//        return text;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }
//
//    public Assortment getAssortment() {
//        return assortment;
//    }
//
//    public void setAssortment(Assortment assortment) {
//        this.assortment = assortment;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Rating rating = (Rating) o;
//        return Objects.equals(id, rating.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
}
