public class Enum {
	enum Season {

		WINTER,
		SPRING,
		SUMMER,
		FALL;}

	public static void main(java.lang.String[] args) {
		com.in28minutes.java.enums.Enum.Season season = com.in28minutes.java.enums.Enum.Season.valueOf("FALL");
		java.lang.System.out.println(season.name());
		java.lang.System.out.println(com.in28minutes.java.enums.Enum.Season.WINTER.ordinal());
		java.lang.System.out.println(com.in28minutes.java.enums.Enum.Season.SPRING.ordinal());
		java.lang.System.out.println(com.in28minutes.java.enums.Enum.Season.SUMMER.ordinal());
		java.lang.System.out.println(com.in28minutes.java.enums.Enum.Season.FALL.ordinal());
		for (com.in28minutes.java.enums.Enum.Season season1 : com.in28minutes.java.enums.Enum.Season.values()) {
			java.lang.System.out.println(season1.name());
		}
		com.in28minutes.java.enums.Enum.Season season1 = com.in28minutes.java.enums.Enum.Season.FALL;
		com.in28minutes.java.enums.Enum.Season season2 = com.in28minutes.java.enums.Enum.Season.FALL;
		java.lang.System.out.println(season1 == season2);
		java.lang.System.out.println(season1.equals(season2));
	}
}