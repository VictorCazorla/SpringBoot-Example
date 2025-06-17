package com.victorcazorla.billing.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "db_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "product_name", nullable = false)
    String name;

    @Column(name = "description")
    String description;

    @Positive(message = "Price must be greater than zero")
    @Column(name = "price", nullable = false)
    double price;

    @NotNull(message = "Category must not be null")
    @ManyToOne
    @JoinColumn(name = "product_category", nullable = false)
    Category category;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<InvoiceLine> invoiceLines = new ArrayList<>();

    public Product() {}

    public Product(String name, String description, double price, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    public Category getCategory() { return category; }

    public void setCategory(Category category) { this.category = category; }

    public List<InvoiceLine> getInvoiceLines() { return invoiceLines; }

    public void setInvoiceLines(List<InvoiceLine> invoiceLines) { this.invoiceLines = invoiceLines; }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}
