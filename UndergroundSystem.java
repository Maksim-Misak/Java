package Java;
import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {
    Map<Integer, String> ident;
    Map<String, double[]> destToTime;

    public UndergroundSystem() {
        ident = new HashMap<>();
        destToTime = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        String temp = stationName + " " + Integer.toString(t);
        ident.put(id, temp);
    }

    public void checkOut(int id, String stationName, int t) {
        String[] stationTime = ident.get(id).split(" ");
        String dest = stationTime[0] + " " + stationName;
        int time = Integer.parseInt(stationTime[1]);
        destToTime.putIfAbsent(dest, new double[] { 0, 0 });
        destToTime.get(dest)[0] += t - time;
        destToTime.get(dest)[1]++;
    }

    public double getAverageTime(String startStation, String endStation) {
        double[] getTime = destToTime.get(startStation + " " + endStation);
        return getTime[0] / getTime[1];
    }

    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15); 
        undergroundSystem.checkOut(27, "Waterloo", 20); 
        undergroundSystem.checkOut(32, "Cambridge", 22); 
        undergroundSystem.getAverageTime("Paradise", "Cambridge");
        undergroundSystem.getAverageTime("Leyton", "Waterloo");
        undergroundSystem.checkIn(10, "Leyton", 24);
        undergroundSystem.getAverageTime("Leyton", "Waterloo"); 
        undergroundSystem.checkOut(10, "Waterloo", 38);
        undergroundSystem.getAverageTime("Leyton", "Waterloo");
        System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge"));
    }
}