
package acme.entities.banners;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import acme.entities.roles.Patron;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Banner extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	@URL
	private String				picture;

	@NotBlank
	private String				slogan;

	@NotBlank
	@URL
	private String				url;

	private String				holderName;

	@CreditCardNumber
	private String				number;

	private String				brand;

	@Range(min = 1, max = 12)
	private Integer				monthExpiration;

	private Integer				yearExpiration;

	@Pattern(regexp = "^[0-9]{3,4}$")
	private String				cvv;

	// RELATIONSHIPS

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Patron				patron;
}
