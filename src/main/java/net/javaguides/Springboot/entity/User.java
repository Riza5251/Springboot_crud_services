package net.javaguides.Springboot.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // this is used to produce the getter methods
@Setter   // this is used to produce the setter methods
@NoArgsConstructor
@AllArgsConstructor

@Entity  // this specifies that this class has a jpa entity
@Table(name="users")
public class User {

    @Id  // to identify the primary key
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
@Column(nullable = false,unique = true)
    private String email;
}
