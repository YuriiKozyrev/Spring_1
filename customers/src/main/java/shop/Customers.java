package shop;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customers implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "customer_name")
    private String customerName;


    @ManyToMany
    @JoinTable(
            name = "orders",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )

    private List<Products> products;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public List<Products> getProducts() { return products; }
    public void setProducts(List<Products> products) { this.products = products; }


    public Customers() {
    }

    public Customers(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return String.format("shop.customers [id = %d, customer_name = %s]", id, customerName);
    }
}
