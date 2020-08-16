import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import spark.Spark;

import static spark.Spark.get;
import static spark.Spark.post;

public class HelloSpark {
    public static void main(String[] args) {
        get("/", (req, res) -> "Test: This is the SMS backend of Plains Paris Referral App");
    }

    TwilioRestClient client = new TwilioRestClient.Builder(System.getenv("TWILIO_ACCOUNT_SID"), System.getenv("TWILIO_AUTH_TOKEN")).build();
}