public class EnumAdvanced {
	enum SeasonCustomized {

		WINTER(1),
		SPRING(2),
		SUMMER(3),
		FALL(4);
		private int code;

		public int getCode() {
			return code;
		}

		private SeasonCustomized(int code) {
			this.code = code;
		}

		public static com.in28minutes.java.enums.EnumAdvanced.SeasonCustomized valueOf(int code) {
			for (com.in28minutes.java.enums.EnumAdvanced.SeasonCustomized season : com.in28minutes.java.enums.EnumAdvanced.SeasonCustomized.values()) {
				if (season.getCode() == code) {
					return season;
				}
			}
			throw new java.lang.RuntimeException("value not found");
		}

		public int getExpectedMaxTemperature() {
			switch (this) {
				case WINTER :
					return 5;
				case SPRING :
				case FALL :
					return 10;
				case SUMMER :
					return 20;
			}
			return -1;
		}
	}

	public static void main(java.lang.String[] args) {
		com.in28minutes.java.enums.EnumAdvanced.SeasonCustomized season = com.in28minutes.java.enums.EnumAdvanced.SeasonCustomized.WINTER;
		java.lang.System.out.println(season.getCode());
		java.lang.System.out.println(season.getExpectedMaxTemperature());
		java.lang.System.out.println(com.in28minutes.java.enums.EnumAdvanced.SeasonCustomized.valueOf(4));
	}
}