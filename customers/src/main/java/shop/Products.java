package shop;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "products")
public class Products implements Serializable {
    private static final long serialVersionUID = -2750973356670718107L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "price")
    private int price;



    @ManyToMany
    @JoinTable(
            name = "orders",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )

    private List<Customers> customers;

    public List<Customers> getCustomers() { return customers; }
    public void setCustomers(List<Customers> customers) { this.customers = customers; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public Products() {
    }

    public Products(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("shop.products [id = %d, product_name = %s, price = %d]", id, productName, price);
    }
}
