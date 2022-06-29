package com.l3azh.management.SpendingManagement.Entities;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "Budget")
@Data
@Builder
public class BudgetEntity {

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "UUID_budget", columnDefinition = "VARCHAR(50)")
    private UUID uuidBudget;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "AmountEstimate")
    private Double amountEstimate;

    @Column(name = "TimeNoti")
    private Date timeNoti;

    @Column(name = "CreateDate")
    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "FK_Wallet_UUID_wallet")
    private WalletEntity walletOfBudget;

    @PrePersist
    public void defaultValue(){
        if(Objects.isNull(createDate)){
            createDate = Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC));
        }
    }
}
