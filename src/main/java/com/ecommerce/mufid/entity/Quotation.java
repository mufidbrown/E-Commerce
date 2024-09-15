package com.ecommerce.mufid.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "quotations")
public class Quotation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quotationId;

    private String nomor;

    @Enumerated(EnumType.STRING)
    private QuotationType quotationType;

    private int total;

    private int tax;

    private int additionalShipping;

    private int grandTotal;

    private double grandBerat;

    private int estimasiPengiriman;

    private int estimasiProduksi;

    private String notes;

    @Enumerated(EnumType.STRING)
    private FinanceStatus financeStatus;

    private String financeNote;

    @Enumerated(EnumType.STRING)
    private LogisticStatus logisticStatus;

    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "quotation")
    private List<DetailProduct> detailProducts;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "shipping_id")
    private Shipping shipping;


}
