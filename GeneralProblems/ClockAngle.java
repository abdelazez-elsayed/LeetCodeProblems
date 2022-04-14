package solutions.GeneralProblems;

public class ClockAngle {
    public double angleClock(int hour, int minutes) {
        int degPerHour = 360/12;
        double minPortion = (double)minutes/60;
        double hoursAngle = (hour%12) * degPerHour + minPortion * degPerHour;
        double degPerMin = 6;
        double minAngle = degPerMin*minutes;
        double ans = Math.abs(minAngle-hoursAngle);
        if(ans > 180){
            ans = 360-ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        ClockAngle a = new ClockAngle();
        System.out.println(a.angleClock(12,30));
    }
}
