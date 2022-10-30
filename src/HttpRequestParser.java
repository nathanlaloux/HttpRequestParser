import java.io.Console;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HttpRequestParser {

    public static void main(String[] args) {
        System.out.println("\n*---------- HTTP Log Parser ----------*");

        //read lines from the Log File
        List<String> lines = LogFileHelper.readLinesFromFile("C:\\programming-task-example-data.log");

        Map<String,Integer> visitedUrls = new HashMap();
        Map<String, Integer> activeIpAddresses = new HashMap<>();

        for(String line : lines){
            String ipAddress = RegexHelper.getIpAddressFromString(line);
            String url = RegexHelper.getUrlFromString(line);

            //set and update visited url map
            updateMapRecord(visitedUrls, url);

            //set and update active ip address map
            updateMapRecord(activeIpAddresses, ipAddress);
        }

        //display number of unique addresses
        System.out.println("\nNumber of Unique Ip Addresses: " + activeIpAddresses.size());

        //display most visited URLs
        System.out.println("\nMost Visited URLs:");
        visitedUrls.entrySet().stream()
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .limit(3)
                .forEach(k -> System.out.println(k.getKey() + " ==> visited " + k.getValue() + " time(s)"));

        //Display most active Ip Addresses
        System.out.println("\nMost Active Ip Addresses:");
        activeIpAddresses.entrySet().stream()
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .limit(3)
                .forEach(k -> System.out.println(k.getKey() + " ==> active " + k.getValue() + " time(s)"));

        System.out.println("\n*---------- End of HTTP Log Parser ----------*");

    }

    private static void updateMapRecord(Map<String, Integer> map, String key){
        if(map.containsKey(key)){
            map.put(key, map.get(key) + 1);
        }else{
            map.put(key, 1);
        }
    }
}
