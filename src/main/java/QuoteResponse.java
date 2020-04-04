/* *****************************************************************************
 *  Name:              Artem Slyusarenko
 *  Last modified:     06/02/2020
 **************************************************************************** */

import java.util.List;

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
