public class FakerUtils {
	private static final net.datafaker.Faker ZH_FAKER = new net.datafaker.Faker(new java.util.Locale("zh-CN"));

	private static final net.datafaker.Faker EN_FAKER = new net.datafaker.Faker();

	private static final java.time.format.DateTimeFormatter DATE_TIME_FORMATTER = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public static java.lang.String getRandomValue(com.yupi.sqlfather.core.model.enums.MockParamsRandomTypeEnum randomTypeEnum) {
		java.lang.String defaultValue = org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(2, 6);
		if (randomTypeEnum == null) {
			return defaultValue;
		}
		switch (randomTypeEnum) {
			case NAME :
				return com.yupi.sqlfather.core.utils.FakerUtils.ZH_FAKER.name().name();
			case CITY :
				return com.yupi.sqlfather.core.utils.FakerUtils.ZH_FAKER.address().city();
			case EMAIL :
				return com.yupi.sqlfather.core.utils.FakerUtils.EN_FAKER.internet().emailAddress();
			case URL :
				return com.yupi.sqlfather.core.utils.FakerUtils.EN_FAKER.internet().url();
			case IP :
				return com.yupi.sqlfather.core.utils.FakerUtils.ZH_FAKER.internet().ipV4Address();
			case INTEGER :
				return java.lang.String.valueOf(com.yupi.sqlfather.core.utils.FakerUtils.ZH_FAKER.number().randomNumber());
			case DECIMAL :
				return java.lang.String.valueOf(org.apache.commons.lang3.RandomUtils.nextFloat(0, 100000));
			case UNIVERSITY :
				return com.yupi.sqlfather.core.utils.FakerUtils.ZH_FAKER.university().name();
			case DATE :
				return com.yupi.sqlfather.core.utils.FakerUtils.EN_FAKER.date().between(java.sql.Timestamp.valueOf("2022-01-01 00:00:00"), java.sql.Timestamp.valueOf("2023-01-01 00:00:00")).toLocalDateTime().format(com.yupi.sqlfather.core.utils.FakerUtils.DATE_TIME_FORMATTER);
			case TIMESTAMP :
				return java.lang.String.valueOf(com.yupi.sqlfather.core.utils.FakerUtils.EN_FAKER.date().between(java.sql.Timestamp.valueOf("2022-01-01 00:00:00"), java.sql.Timestamp.valueOf("2023-01-01 00:00:00")).getTime());
			case PHONE :
				return com.yupi.sqlfather.core.utils.FakerUtils.ZH_FAKER.phoneNumber().cellPhone();
			default :
				return defaultValue;
		}
	}

	public static void main(java.lang.String[] args) {
		com.yupi.sqlfather.core.utils.FakerUtils.getRandomValue(null);
	}
}