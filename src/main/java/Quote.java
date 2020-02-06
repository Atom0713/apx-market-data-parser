import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
/*
 *Created by Artem on 04/02/2020
 */
public class Quote {
    public String market;
    @JsonProperty("date_applied")
    public String dateApplied;
    @JsonProperty("values")
    private List<QuoteValue> quoteValues;

    public void setMarket(String market) {
        this.market = market;
    }

    public String getMarket() {
        return market;
    }

    public String getDateApplied(){
        return dateApplied;
    }
    public void setDateApplied(String input){
        this.dateApplied = input;
    }
    public List<QuoteValue> getQuoteValues(){
        return quoteValues;
    }
    public void setQuoteValues(List<QuoteValue> input){
        this.quoteValues = input;
    }

    @Override
    public String toString() {
        return "Quote{" +
                      "market='" + market + '\'' +
                      ", dateApplied='" + dateApplied + '\'' +
                      ", quoteValues=" + quoteValues +
                      '}';
    }
}