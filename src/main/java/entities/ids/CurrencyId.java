package entities.ids;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CurrencyId implements Serializable {

	private String name;
	private String countryName;

	public CurrencyId() {

	}

	public CurrencyId(String name, String countryName) {
		this.name = name;
		this.countryName = countryName;
	}

	public String getName() {
		return name;
	}

	public String getCountryName() {
		return countryName;
	}

}
