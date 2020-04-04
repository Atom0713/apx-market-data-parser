/* *****************************************************************************
 *  Name:              Artem Slyusarenko
 *  Last modified:     29/03/2020
 **************************************************************************** */

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/*
 *Created by Artem on 04/02/2020
 */
public class Main {

    public static void main(String[] args){
        try{
            readJson();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public static void readJson() throws JsonParseException, JsonMappingException, MalformedURLException, IOException{

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        objectMapper.configure(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS, false);

        // convert JSON file to `JsonNode`
        JsonNode quotesArray = objectMapper.readTree(Paths.get("src/main/data/apx-data.json").toFile());

        JsonNode quoteNodesArray = quotesArray.path("quote");

        List<Quote> newQuoteList = new ArrayList<>();

        for(JsonNode node : quoteNodesArray){
            Quote tempQuote = new Quote();
            tempQuote.setMarket(node.path("market").asText());

            //Convert milliseconds to date
            Date date = new Date(Long.parseLong(node.path("date_applied").asText()));
            SimpleDateFormat myDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            myDate.setTimeZone(TimeZone.getTimeZone("CEST"));
            String formatted = myDate.format(date);

            tempQuote.setDateApplied(formatted);

            List<QuoteValue> tempQuoteValueList= new ArrayList<>();

            JsonNode valuesNodeArray = node.path("values");
            for (JsonNode value : valuesNodeArray){
                QuoteValue tempQuoteValue = new QuoteValue();

                if(value.path("tLabel").asText().equals("Hour")){
                    tempQuoteValue.setTLabel(value.path("tLabel").asText());
                    tempQuoteValue.setValue(value.path("value").asText());

                    tempQuoteValueList.add(tempQuoteValue);
                }
                if(value.path("tLabel").asText().equals("Net Volume")){
                    tempQuoteValue.setTLabel(value.path("tLabel").asText());
                    tempQuoteValue.setValue(value.path("value").asText());

                    tempQuoteValueList.add(tempQuoteValue);
                }
                if(value.path("tLabel").asText().equals("Price")){
                    tempQuoteValue.setTLabel(value.path("tLabel").asText());
                    tempQuoteValue.setValue(value.path("value").asText());

                    tempQuoteValueList.add(tempQuoteValue);
                }
            }
            tempQuote.setQuoteValues(tempQuoteValueList);
            newQuoteList.add(tempQuote);
        }
        QuoteResponse quoteResponseNode = new QuoteResponse(newQuoteList);



        //print nodes
        for(Quote nodes: quoteResponseNode.getQuote()){
            System.out.println("\n"+nodes);
        }

    }

}
