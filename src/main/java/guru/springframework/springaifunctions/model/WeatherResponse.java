package guru.springframework.springaifunctions.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.math.BigDecimal;

/*
{
  "ticker": "AAPL",
  "name": "Apple Inc.",
  "price": 192.42,
  "exchange": "NASDAQ",
  "updated": 1706302801,
  "currency": "USD"
}
 */
public record WeatherResponse(@JsonPropertyDescription("WindSpeed in KMH") BigDecimal windSpeed,
                              @JsonPropertyDescription("Direction of wind") Integer windDegrees,
                              @JsonPropertyDescription("Current Temperature in Celsius") Integer temp,
                              @JsonPropertyDescription("Current Humidity") Integer humidity,
                              @JsonPropertyDescription("Epoch time of sunset GMT ") Integer sunset,
                              @JsonPropertyDescription("Epoch time of Sunrise GMT ") Integer sunrise,
                              @JsonPropertyDescription("Low Temperature in Celsius") Integer minTemp,
                              @JsonPropertyDescription("Cloud Coverage Percentage") Integer cloudPct,
                              @JsonPropertyDescription("Temperature in Celsius") Integer feelsLike,
                              @JsonPropertyDescription("MaximumTemperature in Celsius") Integer maxTemp) {
}
