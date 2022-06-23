package com.l3azh.management.SpendingManagement.Entities;

import lombok.AllArgsConstructor;
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
@Table(name = "Transaction")
@Data
@Builder
public class TransactionEntity {

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "UUID_transaction", columnDefinition = "VARCHAR(50)")
    private UUID uuidTransaction;

    @Column(name = "Description")
    private String description;

    @Column(name = "Amount")
    private Double amount;

    @Column(name = "CreateDate")
    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "FK_Wallet_UUID_wallet")
    private WalletEntity walletOfTransaction;

    @ManyToOne
    @JoinColumn(name = "FK_TransType_UUID_transType")
    private TransTypeEntity transType;

    @PrePersist
    public void defaultValue(){
        if(Objects.isNull(createDate)){
            createDate = Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC));
        }
    }
}
