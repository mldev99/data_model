package com.wellsfargo.counselor;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "portfolios")
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;

    private String name;
    private String baseCurrency;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Holding> holdings;

    public Portfolio(String name, String baseCurrency) {
        this.name = name;
        this.baseCurrency = baseCurrency;
    }

    public Portfolio() {}

    // Getters & Setters
    public Long getPortfolioId() { return portfolioId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getBaseCurrency() { return baseCurrency; }
    public void setBaseCurrency(String baseCurrency) { this.baseCurrency = baseCurrency; }
    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }
    public List<Holding> getHoldings() { return holdings; }
    public void setHoldings(List<Holding> holdings) { this.holdings = holdings; }
}
