package com.vtxlab.demo.helloworld.demo_sb_customer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// ! Spring: Convention Over Configuration
// 以下做法遵循了（約定優於配置）原則*
// 通過遵循一些約定和標準，減少了開發者對配置的需求，同時提高了開發效率

// ! Entity (Define Table Structure by Java)
// ! Hibernate -> rely on provided driver, generate corresponding SQL (DDL)
// Hibernate 可以根據實體類別的定義來生成對應的 SQL 語句，並根據提供的驅動程序來生成資料庫表
// 開發者可以專注於定義實體類別和屬性，而不需要過多關注底層的資料庫操作

// ! mvn install -> test -> create table
// PK, FK, auto_increment, column name, field size

@Entity // 這個註解標記了這個類別是一個 JPA 實體類別，表示它對應到資料庫中的一個表
@Table(name = "Customers")  //  這個註解指定了將這個實體映射到名為 "Customers" 的資料庫表
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
// 使用 Spring Framework 和 Hibernate 框架來定義資料庫表結構的實體類別 CustomerEntity
public class CustomerEntity {
  @Id // 這個註解標記了這個屬性是主鍵（Primary Key），用來唯一識別每一條記錄

  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
  // 這個註解指定了生成主鍵值的策略，使用 IDENTITY 策略表示主鍵值是自動增加

  // 這兩個註解指定了將 Java 類的屬性對應到資料庫表中的列，
// 分別對應到資料庫表中的 customer_name 和 customer_email 列
  private Long id;
  @Column(name = "customer_name")
  private String name;
  @Column(name = "customer_email")
  private String email;
}