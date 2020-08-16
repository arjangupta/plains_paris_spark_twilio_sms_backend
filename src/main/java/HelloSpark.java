import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

import static spark.Spark.get;
import static spark.Spark.post;

public class HelloSpark {
    public static void main(String[] args) {
        get("/", (req, res) -> "This is the SMS backend of Plains Paris Referral App - READY TO SEND TEXTS");

        // Instantiate REST client
        TwilioRestClient client = new TwilioRestClient.Builder(System.getenv("AC6d2d5e845b62dbaa240a0d85c65a1726"), System.getenv("e22d6bef569003091aa4673d234e6fd2")).build();

        // Add a POST request endpoint
        post("/sms", (req, res) -> {
            String body = req.queryParams("Body");
            String to = req.queryParams("To");
            String from = "+12057935447";

            Message message = new MessageCreator(
                    new PhoneNumber(to),
                    new PhoneNumber(from),
                    body).create(client);

            return message.getSid();
        });
    }
}