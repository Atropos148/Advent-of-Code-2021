public class Day3 {
	String test_report = "00100,11110,10110,10111,10101,01111,00111,11100,10000,11001,00010,01010";

	public void calculatePowerConsumption() {
		String[] reports = test_report.split(",");
		StringBuilder gammaRate = new StringBuilder();
		StringBuilder epsilonRate = new StringBuilder();

		for (int index = 0; index < reports[0].length(); index++) {
			int bitTotal = 0;
			for (String report: reports){
				bitTotal += Integer.parseInt(String.valueOf(report.charAt(index)));
			}
			if (bitTotal > reports.length/2) {
				gammaRate.append("1");
			} else {
				gammaRate.append("0");
			}
		}

		for (int bitIndex = 0; bitIndex < gammaRate.length(); bitIndex++) {
			if ('1' == gammaRate.charAt(bitIndex)) {
				epsilonRate.append("0");
			} else {
				epsilonRate.append("1");
			}
		}

		int gammaValue = Integer.parseInt(String.valueOf(gammaRate), 2);
		int epsilonValue = Integer.parseInt(String.valueOf(epsilonRate), 2);

		System.out.println("Power Consumption:  " + gammaValue*epsilonValue);
	}
}
