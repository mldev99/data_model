package com.wellsfargo.counselor;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "financial_advisors")
public class FinancialAdvisor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long advisorId;

    private String name;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "advisor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Client> clients;

    // Constructor
    public FinancialAdvisor(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public FinancialAdvisor() {}

    // Getters & Setters
    public Long getAdvisorId() { return advisorId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public List<Client> getClients() { return clients; }
    public void setClients(List<Client> clients) { this.clients = clients; }
}
