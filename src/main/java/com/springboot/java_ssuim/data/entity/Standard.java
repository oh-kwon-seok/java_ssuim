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
@Table(name="standard")
public class Standard extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @Column(nullable = false)
    private Integer milkrun_qty;

    @Column(nullable = false)
    private Integer order_limit_qty;










}
