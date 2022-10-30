import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexHelper {

    //return the Ip address found in a String
    public static String getIpAddressFromString(String line) {
        String IPADDRESS_PATTERN = "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
        Pattern pattern = Pattern.compile(IPADDRESS_PATTERN);
        Matcher matcher = pattern.matcher(line);

        return matcher.find() ? matcher.group() : "";
    }

    //return URL found in a String
    public static String getUrlFromString(String line) {
        String URL_PATTERN = "(?<=GET|POST|PUT|DELETE|PATCH) ([^\\s]+)";
        Pattern pattern = Pattern.compile(URL_PATTERN);
        Matcher matcher = pattern.matcher(line);

        return matcher.find() ? matcher.group().trim() : "";
    }
}

