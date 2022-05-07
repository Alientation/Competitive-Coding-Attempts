import java.util.Scanner;

public class PowerToPersevere {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		for (int testcase = console.nextInt(); testcase > 0; testcase--) {
			double diameter = console.nextDouble();
			double motorRevPerRotation = console.nextDouble();
			double powerPerRev = console.nextDouble();
			double revPerMin = console.nextDouble();
			double powerCap = console.nextDouble();
			double voltReq = console.nextDouble();
			double reqDistance = console.nextDouble() * 100;
			if (revPerMin == 0 || diameter == 0 || voltReq == 0) {
				System.out.println("Fail");
				continue;
			}
			
			double distancePerRot = diameter * Math.PI;
			double reqRot = reqDistance / distancePerRot;
			double reqRev = motorRevPerRotation * reqRot;
			double timeReq = reqRev / revPerMin;
			double totalPower = reqRev * powerPerRev;
			double amps = totalPower / voltReq;
			double power = amps * timeReq / 60;
			if (powerCap >= power) {
				System.out.println("Success " + String.format("%.4f", timeReq));
			} else {
				System.out.println("Fail");
			}
		}
		console.close();
	}
}
