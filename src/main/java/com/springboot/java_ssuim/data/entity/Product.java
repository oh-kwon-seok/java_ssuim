package com.springboot.java_ssuim.data.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name="product")
public class Product extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long uid;

    @Column(nullable = false)
    private Integer sk_uid;

    @Column(nullable = false)
    private String ship_name;

    @Column(nullable = false)
    private String origin_name;

    private String inbox;
    private String outbox;
    @Column(nullable = false)
    private Integer qty;
    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer used;








}
