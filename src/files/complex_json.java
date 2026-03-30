public class complex_json {

    public static String courses(){

        return "{\n" +
                "  \"orderId\": \"ORD-992831\",\n" +
                "  \"customer\": {\n" +
                "    \"id\": 5501,\n" +
                "    \"name\": \"Arjun Kumar\",\n" +
                "    \"email\": \"arjun.k@example.in\",\n" +
                "    \"isPremium\": true\n" +
                "  },\n" +
                "  \"status\": \"PENDING\",\n" +
                "  \"currency\": \"INR\",\n" +
                "  \"summary\": {\n" +
                "    \"totalPrice\": 2550.00,\n" +
                "    \"tax\": 150.00,\n" +
                "    \"discount\": 100.00\n" +
                "  },\n" +
                "  \"items\": [\n" +
                "    {\n" +
                "      \"id\": \"PROD-001\",\n" +
                "      \"name\": \"Mechanical Keyboard\",\n" +
                "      \"details\": {\n" +
                "        \"brand\": \"Keychron\",\n" +
                "        \"color\": \"RGB Grey\",\n" +
                "        \"warrantyMonths\": 12\n" +
                "      },\n" +
                "      \"price\": 1200.00,\n" +
                "      \"quantity\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"PROD-002\",\n" +
                "      \"name\": \"Gaming Mouse\",\n" +
                "      \"details\": {\n" +
                "        \"brand\": \"Logitech\",\n" +
                "        \"color\": \"Black\",\n" +
                "        \"dpi\": 12000\n" +
                "      },\n" +
                "      \"price\": 800.00,\n" +
                "      \"quantity\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"PROD-003\",\n" +
                "      \"name\": \"USB-C Cable\",\n" +
                "      \"details\": {\n" +
                "        \"length\": \"2m\",\n" +
                "        \"braided\": true\n" +
                "      },\n" +
                "      \"price\": 275.00,\n" +
                "      \"quantity\": 2\n" +
                "    }\n" +
                "  ],\n" +
                "  \"metadata\": {\n" +
                "    \"region\": \"Odisha\",\n" +
                "    \"warehouseId\": \"WH-Bhubaneswar-01\"\n" +
                "  }\n" +
                "}";

    }
}
