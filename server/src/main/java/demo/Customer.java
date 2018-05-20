package demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String first;
    @NotNull
    private String second;

    @Email
    @NotNull
    private String email;
}