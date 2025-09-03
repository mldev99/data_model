package com.wellsfargo.counselor;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "holdings")
public class Holding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long holdingId;

    private LocalDate purchaseDate;
    private Double purchasePrice;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;

    @ManyToOne
    @JoinColumn(name = "security_id")
    private Security security;

    public Holding(LocalDate purchaseDate, Double purchasePrice, Integer quantity) {
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.quantity = quantity;
    }

    public Holding() {}

    // Getters & Setters
    public Long getHoldingId() { return holdingId; }
    public LocalDate getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(LocalDate purchaseDate) { this.purchaseDate = purchaseDate; }
    public Double getPurchasePrice() { return purchasePrice; }
    public void setPurchasePrice(Double purchasePrice) { this.purchasePrice = purchasePrice; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public Portfolio getPortfolio() { return portfolio; }
    public void setPortfolio(Portfolio portfolio) { this.portfolio = portfolio; }
    public Security getSecurity() { return security; }
    public void setSecurity(Security security) { this.security = security; }
}
