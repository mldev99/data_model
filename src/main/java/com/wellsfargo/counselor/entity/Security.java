package com.wellsfargo.counselor;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "securities")
public class Security {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long securityId;

    private String ticker;
    private String name;
    private String category;

    @OneToMany(mappedBy = "security", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Holding> holdings;

    public Security(String ticker, String name, String category) {
        this.ticker = ticker;
        this.name = name;
        this.category = category;
    }

    public Security() {}

    // Getters & Setters
    public Long getSecurityId() { return securityId; }
    public String getTicker() { return ticker; }
    public void setTicker(String ticker) { this.ticker = ticker; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public List<Holding> getHoldings() { return holdings; }
    public void setHoldings(List<Holding> holdings) { this.holdings = holdings; }
}
