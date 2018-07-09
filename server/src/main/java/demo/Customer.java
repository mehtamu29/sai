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
    public Customer(long id, String first, String second, String email) {
    	this.id =id;
    	this.first=first;
    	this.second=second;
    	this.email=email;
	}

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

	public Long getId() {
		return id;
	}

	public String getFirst() {
		return first;
	}

	public String getSecond() {
		return second;
	}

	public String getEmail() {
		return email;
	}
    
}