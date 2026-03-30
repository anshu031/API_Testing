import io.restassured.path.json.JsonPath;

public class Practise_json {

    public static void main(String[] args) {
        JsonPath js = new JsonPath(complex_json.courses());
        int len=js.getInt("items.size()");
        int sum=0;
        for (int i=0;i<len;i++){
            double price=Double.parseDouble(js.getString("items["+i+"].price"));
            int quan=Integer.parseInt(js.getString("items["+i+"].quantity"));
            sum+= (price*quan);
            System.out.println(js.getString("items["+i+"].name"));
            System.out.println(js.getString("items["+i+"].price"));
        }
        System.out.println(sum);
        //System.out.println(js.getInt("customer.length()"));
    }
}
