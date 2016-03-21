package bitcoinPrice;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bitcoin {

	@SerializedName("volume")
	@Expose
	private Double volume;
	@SerializedName("latest_trade")
	@Expose
	private Integer latestTrade;
	@SerializedName("bid")
	@Expose
	private Double bid;
	@SerializedName("high")
	@Expose
	private Double high;
	@SerializedName("currency")
	@Expose
	private String currency;
	@SerializedName("currency_volume")
	@Expose
	private Double currencyVolume;
	@SerializedName("ask")
	@Expose
	private Double ask;
	@SerializedName("close")
	@Expose
	private Double close;
	@SerializedName("avg")
	@Expose
	private Double avg;
	@SerializedName("symbol")
	@Expose
	private String symbol;
	@SerializedName("low")
	@Expose
	private Double low;

public Double getVolume() {
return volume;
}

public Integer getLatestTrade() {
return latestTrade;
}

public Double getBid() {
return bid;
}

public Double getHigh() {
return high;
}

public String getCurrency() {
return currency;
}

public Double getCurrencyVolume() {
return currencyVolume;
}

public Double getAsk() {
return ask;
}

	public Double getClose() {
		return close;
}

public Double getAvg() {
return avg;
}

public String getSymbol() {
return symbol;
}

public Double getLow() {
return low;
}

@Override
public String toString() {
	return String.format("%15s  ||  %15.2f %s  ||  %15.2f %s  ||  %15.2f %s  ||  %15.2f %s  ||  %20.2f %s%n", this.getSymbol(), this.getHigh(), this.getCurrency(), this.getLow(), this.getCurrency(), this.getBid(), this.getCurrency(),this.getAsk(), this.getCurrency(), this.getCurrencyVolume(), this.getCurrency());
}



}