package com.l3azh.management.SpendingManagement.Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TransType")
public class TransTypeEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "UUID_transType")
    private UUID uuidTransType;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "CreateDate")
    private String createDate;

    @OneToMany(mappedBy = "transType")
    private List<TransactionEntity> listTransaction;

    public TransTypeEntity() {
    }

    public TransTypeEntity(UUID uuidTransType, String name, String description, String createDate) {
        this.uuidTransType = uuidTransType;
        this.name = name;
        this.description = description;
        this.createDate = createDate;
    }

    public UUID getUuidTransType() {
        return uuidTransType;
    }

    public void setUuidTransType(UUID uuidTransType) {
        this.uuidTransType = uuidTransType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public List<TransactionEntity> getListTransaction() {
        return listTransaction;
    }

    public void setListTransaction(List<TransactionEntity> listTransaction) {
        this.listTransaction = listTransaction;
    }
}
