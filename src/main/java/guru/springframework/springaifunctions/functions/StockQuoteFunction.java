package guru.springframework.springaifunctions.functions;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.springaifunctions.model.StockQuoteRequest;
import guru.springframework.springaifunctions.model.StockQuoteResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestClient;

import java.util.function.Function;

@RequiredArgsConstructor
@Slf4j
public class StockQuoteFunction implements Function<StockQuoteRequest, StockQuoteResponse> {

    private static final String STOCK_QUOTE_URL = "https://api.api-ninjas.com/v1/stockprice";

    private  final String apiNinjasKey;

    @Override
    public StockQuoteResponse apply(StockQuoteRequest stockQuoteRequest) {
        RestClient restClient = RestClient.builder()
                .baseUrl(STOCK_QUOTE_URL)
                .defaultHeaders(httpHeaders -> {
                    httpHeaders.set("X-Api-Key", apiNinjasKey);
                    httpHeaders.set("Accept", "application/json");
                    httpHeaders.set("Content-Type", "application/json");
                }).build();

        JsonNode jsonNode = restClient.get().uri(uriBuilder -> {
            log.info("Building URI for stock quote request: " + stockQuoteRequest);

            uriBuilder.queryParam("symbol", stockQuoteRequest.ticker());

            return uriBuilder.build();
        }).retrieve().body(JsonNode.class);

        if(jsonNode.isEmpty()){
            log.error("No stock quote found for ticker: " + stockQuoteRequest.ticker());
            return new StockQuoteResponse(null, null, null, null, null, null);
        }
        return new ObjectMapper().convertValue(jsonNode.get(0), StockQuoteResponse.class);
    }
}
