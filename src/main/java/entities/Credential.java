package entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CREDENTIAL")
public class Credential {

	@Id
	@GeneratedValue
	@Column(name = "CREDENTIAL_ID")
	private Long credentialId;

	@OneToOne(cascade = CascadeType.ALL) // ked ulozime Credential tak sa persistne aj USER => BOTH ENTITIES ARE PERSIST AT THE SAME TIME
	@JoinColumn(name="USER_ID", referencedColumnName) // column that should be used to join tables - USER_ID je nazov atributu ktory spaja tabulky v tejto TABULKE, keby sa nejak inak volal v User tabulke tak treba specifikovat referencedColumnName...name coresponding to source entity referencedColumnName referencing to Target entity
	private User user; // user -> target credential -> source pretoze drzi FK

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	public Long getCredentialId() {
		return credentialId;
	}

	public void setCredentialId(Long credentialId) {
		this.credentialId = credentialId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
