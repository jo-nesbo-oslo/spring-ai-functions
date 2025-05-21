package guru.springframework.springaifunctions.model;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonClassDescription("Stock Quote API request")
public record StockQuoteRequest(@JsonProperty("Stock or index ticker symbol (e.g., AAPL or ^DJI) to quote.")
                                String ticker) {
}
