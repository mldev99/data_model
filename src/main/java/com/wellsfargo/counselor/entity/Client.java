package com.wellsfargo.counselor;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String riskProfile;

    @ManyToOne
    @JoinColumn(name = "advisor_id")
    private FinancialAdvisor advisor;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Portfolio> portfolios;

    public Client(String firstName, String lastName, String email, String phone, String riskProfile) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.riskProfile = riskProfile;
    }

    public Client() {}

    // Getters & Setters
    public Long getClientId() { return clientId; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getRiskProfile() { return riskProfile; }
    public void setRiskProfile(String riskProfile) { this.riskProfile = riskProfile; }
    public FinancialAdvisor getAdvisor() { return advisor; }
    public void setAdvisor(FinancialAdvisor advisor) { this.advisor = advisor; }
    public List<Portfolio> getPortfolios() { return portfolios; }
    public void setPortfolios(List<Portfolio> portfolios) { this.portfolios = portfolios; }
}
