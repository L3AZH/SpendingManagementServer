package com.l3azh.management.SpendingManagement.Entities;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "TransType")
@Data
@Builder
public class TransTypeEntity {

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "UUID_transType", columnDefinition = "VARCHAR(50)")
    private UUID uuidTransType;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "CreateDate")
    private Date createDate;

    @OneToMany(mappedBy = "transType")
    private List<TransactionEntity> listTransaction;

    @PrePersist
    public void defaultValue(){
        if(Objects.isNull(createDate)){
            createDate = Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC));
        }
    }
}
