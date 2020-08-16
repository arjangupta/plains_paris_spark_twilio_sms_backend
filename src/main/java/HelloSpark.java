import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import static spark.Spark.*;

public class HelloSpark {
    public static void main(String[] args) {
        get("/", (req, res) -> "Test: This is the SMS backend of Plains Paris Referral App");
    }
}