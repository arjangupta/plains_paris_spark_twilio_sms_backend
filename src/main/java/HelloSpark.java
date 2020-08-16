import static spark.Spark.*;

public class HelloSpark {
    public static void main(String[] args) {
        get("/", (req, res) -> "Test: This is the SMS backend of Plains Paris Referral App");
    }
}