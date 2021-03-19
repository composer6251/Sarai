import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        BigDecimal ASTRONOMICAL_UNIT = BigDecimal.valueOf(93000000);
        BigDecimal DISTANCE_TO_SUN = BigDecimal.valueOf(93000000);
        BigDecimal DISTANCE_TO_PLUTO =  BigDecimal.valueOf(3248300000L);
        BigDecimal NSWR_MPS = BigDecimal.valueOf(18000);
        BigDecimal NSWR_KMS_PER_SECOND = BigDecimal.valueOf(66);
        BigDecimal PERSEVERANCE_KM_S = BigDecimal.valueOf(20000).divide(BigDecimal.valueOf(60), 20, RoundingMode.HALF_UP).divide(BigDecimal.valueOf(60),20, RoundingMode.HALF_UP);
        BigDecimal DISTANCE_TO_MARS_KM = BigDecimal.valueOf(216556513);
        BigDecimal DISTANCE_TO_EDGE_OF_SOLAR_SYSTEM = ASTRONOMICAL_UNIT.multiply(BigDecimal.valueOf(50));
        BigDecimal DISTANCE_TO_COLONY_PLANET;//todo: figure
        //todo: figure travel time for audio signals to reach the ship
        //todo: how to figure acceleration time for ships???
        //todo: What is maximum acceleration safe??

        timeToDestinationSpeedSeconds(DISTANCE_TO_EDGE_OF_SOLAR_SYSTEM, PERSEVERANCE_KM_S, "KM");
        figure91Days();

    }

    public static void timeToDestinationSpeedSeconds(BigDecimal distanceToPlanet, BigDecimal rocketDistancePerSecond, String unitOfMeasurement){
        System.out.println("distance to planet is: " + distanceToPlanet);
        BigDecimal secondsInYear =  BigDecimal.valueOf(31536000);

        if(unitOfMeasurement.equals("KM")){
            rocketDistancePerSecond = convertToMph(rocketDistancePerSecond);
        }

        BigDecimal rocketDistancePerYear = rocketDistancePerSecond.multiply(secondsInYear);

        System.out.println("Travel Time to destination is: " + distanceToPlanet.divide(rocketDistancePerYear, 6, RoundingMode.HALF_UP) + " years.");
    }

    public static BigDecimal convertToMph(BigDecimal distance){
        return distance.multiply(BigDecimal.valueOf(1.609));
    }

    public static void figure91Days(){
        System.out.println("91 one days after: " + LocalDate.of(2334, 7, 12).plusDays(91));

    }



}
