package com.victorcazorla.billing.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "db_invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Date cannot be null")
    @PastOrPresent(message = "Date cannot be in the future")
    @Column(name = "invoice_date", nullable = false)
    private LocalDate date;

    @NotNull(message = "Total cannot be null")
    @PositiveOrZero(message = "Total must be zero or positive")
    @Column(name = "invoice_total", nullable = false)
    private Long total;

    @NotNull(message = "Client cannot be null")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @NotNull(message = "User cannot be null")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InvoiceLine> invoiceLines = new ArrayList<>();

    public Invoice() {
    }

    public Invoice(LocalDate date, Long total, Client client, User user, List<InvoiceLine> invoiceLines) {
        this.date = date;
        this.total = total;
        this.client = client;
        this.user = user;
        this.invoiceLines = invoiceLines;
    }

    public Invoice(LocalDate date, Long total, Client client, User user) {
        this.date = date;
        this.total = total;
        this.client = client;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<InvoiceLine> getInvoiceLines() {
        return invoiceLines;
    }

    public void setInvoiceLines(List<InvoiceLine> invoiceLines) {
        this.invoiceLines = invoiceLines;
    }

    public void addInvoiceLine(InvoiceLine line) {
        invoiceLines.add(line);
        line.setInvoice(this);
    }

    public void removeInvoiceLine(InvoiceLine line) {
        invoiceLines.remove(line);
        line.setInvoice(null);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", date=" + date +
                ", total=" + total +
                ", client=" + client +
                ", user=" + user +
                ", invoiceLines=" + invoiceLines +
                '}';
    }
}
