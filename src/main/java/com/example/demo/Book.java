package com.example.demo;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
@Entity
@Table(name = "book")
public class Book {
    @Column(name = "name")
    String name;
    @Id
    @Column(name = "isbn")
    String isbn;
    @Column(name = "author")
    String author;

}
//
//    private long id;
//
//    private String title;
//
//    private String author;
//

//}
