public class EnumAdvanced2 {
	enum SeasonCustomized {

		WINTER(1) {
			public int getExpectedMaxTemperature() {
				return 5;
			}
		},
		SPRING(2),
		SUMMER(3) {
			public int getExpectedMaxTemperature() {
				return 20;
			}
		},
		FALL(4);
		private int code;

		public int getCode() {
			return code;
		}

		private SeasonCustomized(int code) {
			this.code = code;
		}

		public int getExpectedMaxTemperature() {
			return 10;
		}
	}

	public static void main(java.lang.String[] args) {
		com.in28minutes.java.enums.EnumAdvanced2.SeasonCustomized season = com.in28minutes.java.enums.EnumAdvanced2.SeasonCustomized.WINTER;
		java.lang.System.out.println(season.getExpectedMaxTemperature());
		java.lang.System.out.println(com.in28minutes.java.enums.EnumAdvanced2.SeasonCustomized.FALL.getExpectedMaxTemperature());
	}
}