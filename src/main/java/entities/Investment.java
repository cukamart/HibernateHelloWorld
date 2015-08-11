package entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="INVESTMENT")
@DiscriminatorColumn(name="INVESTMENT_TYPE")
public class Investment {

	@Id
	@GeneratedValue
	@Column(name = "INVESTMENT_ID")
	private Long investmentId;

	@JoinColumn(name = "PORTFOLIO_ID")
	@ManyToOne(cascade = CascadeType.ALL)
	private Portfolio portfolio;

	@Column(name = "NAME")
	private String name;

	@Column(name = "ISSUER")
	private String issuer;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PURCHASE_DATE")
	private Date purchaseDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Long getInvestmentId() {
		return investmentId;
	}

	public void setInvestmentId(Long investmentId) {
		this.investmentId = investmentId;
	}

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}

}
