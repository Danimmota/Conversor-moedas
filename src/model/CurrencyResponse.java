package model;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public record CurrencyResponse(
        String result,
        String timeLastUpdateUtc,
        String baseCode,
        String targetCode,
        double conversionRate,
        Map<String, Double> conversionRates,
        double conversionResult) {
}
