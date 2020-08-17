import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import static spark.Spark.get;
import static spark.Spark.post;

public class HelloSpark {
    public static void main(String[] args) {
        get("/", (req, res) -> "SMS Backend v0.1 of Plains Paris Referral App");

        // Instantiate REST client
        Twilio.init("AC6d2d5e845b62dbaa240a0d85c65a1726", "e22d6bef569003091aa4673d234e6fd2");

        // Add a POST request endpoint
        post("/sms", (req, res) -> {
            String body = req.queryParams("Body");
            String to = req.queryParams("To");
            String from = "+12057935447";

            Message message = Message.creator(
                    new PhoneNumber(to),
                    new PhoneNumber(from),
                    body).create();

            return message.getSid();
        });
    }
}