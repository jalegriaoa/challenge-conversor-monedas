package model;

public record MonedaRec(String base_code,
                        String target_code,
                        Double conversion_rate,
                        Double conversion_result) {
}
