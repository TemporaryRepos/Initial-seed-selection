public class ToArray {
	enum Country {

		FRENCH,
		POLISH;}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		java.util.Map<javaT.util.EnumMap.ToArray.Country, java.lang.String> m = new java.util.EnumMap<javaT.util.EnumMap.ToArray.Country, java.lang.String>(javaT.util.EnumMap.ToArray.Country.class);
		m.put(javaT.util.EnumMap.ToArray.Country.FRENCH, "connection");
		m.put(javaT.util.EnumMap.ToArray.Country.POLISH, "sausage");
		java.lang.Object[] z = m.entrySet().toArray();
		java.lang.System.out.println(java.util.Arrays.toString(z));
		if (!((((z.getClass() == java.lang.Object[].class) && (z.length == 2)) && (((java.util.Map.Entry) (z[0])).getKey() == javaT.util.EnumMap.ToArray.Country.FRENCH)) && (((java.util.Map.Entry) (z[1])).getKey() == javaT.util.EnumMap.ToArray.Country.POLISH))) {
			throw new java.lang.AssertionError();
		}
		java.util.Map.Entry[] x1 = new java.util.Map.Entry[3];
		x1[2] = m.entrySet().iterator().next();
		java.util.Map.Entry[] x2 = m.entrySet().toArray(x1);
		java.lang.System.out.println(java.util.Arrays.toString(x2));
		if (!((((x1 == x2) && (x2[0].getKey() == javaT.util.EnumMap.ToArray.Country.FRENCH)) && (x2[1].getKey() == javaT.util.EnumMap.ToArray.Country.POLISH)) && (x2[2] == null))) {
			throw new java.lang.AssertionError();
		}
		java.util.Map.Entry[] y1 = new java.util.Map.Entry[1];
		java.util.Map.Entry[] y2 = m.entrySet().toArray(y1);
		java.lang.System.out.println(java.util.Arrays.toString(y2));
		if (!((((y1 != y2) && (y2.length == 2)) && (y2[0].getKey() == javaT.util.EnumMap.ToArray.Country.FRENCH)) && (y2[1].getKey() == javaT.util.EnumMap.ToArray.Country.POLISH))) {
			throw new java.lang.AssertionError();
		}
	}
}