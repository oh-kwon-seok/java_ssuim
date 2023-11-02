package com.springboot.java_jangan.data.entity;


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
    private String name;

    @ManyToOne
    @JoinColumn(name="unit_uid")
    private Unit unit;

    @ManyToOne
    @JoinColumn(name="type_uid")
    private Type type;
    @ManyToOne
    @JoinColumn(name="origin_uid")
    private Origin origin;
    @ManyToOne
    @JoinColumn(name="standard_uid")
    private Standard standard;


}
