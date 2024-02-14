package de.ait.fitlio.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
@Entity
@Table(name = "fit_users_profile")
public class UserProfile {


    // Предварительный обработчик для установки значения по умолчанию перед сохранением
    @PrePersist
    public void perPersist(){
        if(dateOfBirth == null){
            dateOfBirth = LocalDate.now().minusYears(40);
        }
        if (weight == null){
            weight = 65.0;
        }
        if (height == null){
            height = 170;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "varchar(50) 'First name'")
    private String firstName;
    @Column(columnDefinition = "varchar(100) 'Last name'")
    private String lastName;
    @Column
    private Boolean gender = true;
    @Column
    private LocalDate dateOfBirth;//возраст вычислим отдельно
    @Column
    private Double weight;
    @Column
    private Integer height;
    @Column
    private Boolean allowance = true;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
}
