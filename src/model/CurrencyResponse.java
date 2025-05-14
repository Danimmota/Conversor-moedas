package model;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public record CurrencyResponse(
        String result,
        @SerializedName("time_last_update_utc")
        String timeLastUpdateUtc,
        @SerializedName("base_code")
        String baseCode,
        @SerializedName("target_code")
        String targetCode,
        @SerializedName("conversion_rate")
        double conversionRate,
        @SerializedName("conversion_rates")
        Map<String, Double> conversion_rates,
        @SerializedName("conversion_result")
        double conversionResult) {
}
