import java.util.List;
/*
 *Created by Artem on 04/02/2020
 */
public class QuoteResponse {
    private List<Quote> quote;

    public QuoteResponse(List<Quote> quote) {
        this.quote = quote;
    }

    public List<Quote> getQuote(){
        return quote;
    }
    public void setQuote(List<Quote> input){
        this.quote = input;
    }
    @Override
    public String toString(){
        return "QuoteResponse{" + "quote=" + quote + "}";
    }
}
