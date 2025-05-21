package guru.springframework.springaifunctions.model;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

@JsonClassDescription("Stock Quote API response")
public record StockQuoteResponse(
        @JsonProperty("Stock or index ticker symbol (e.g., AAPL or ^DJI) to quote.")
        String ticker,
        @JsonProperty("Name of the stock or index.")
        String name,
        @JsonProperty("Last price of the stock or index.")
        BigDecimal price,
        @JsonProperty("The exchange the stock is traded in.")
        String exchange,
        @JsonProperty("The last time the stock was updated (the date format is Epoch time).")
        Integer updated,
        @JsonProperty("The currency of the stock.")
        String currency) {
}
