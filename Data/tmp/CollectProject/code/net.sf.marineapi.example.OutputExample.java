public class OutputExample {
	public static void main(java.lang.String[] args) {
		net.sf.marineapi.nmea.parser.SentenceFactory sf = net.sf.marineapi.nmea.parser.SentenceFactory.getInstance();
		net.sf.marineapi.nmea.sentence.MWVSentence mwv = ((net.sf.marineapi.nmea.sentence.MWVSentence) (sf.createParser(net.sf.marineapi.nmea.sentence.TalkerId.II, "MWV")));
		java.lang.System.out.println(mwv.toSentence());
		mwv.setAngle(43.7);
		mwv.setTrue(true);
		mwv.setSpeed(4.54);
		mwv.setSpeedUnit(net.sf.marineapi.nmea.util.Units.METER);
		mwv.setStatus(net.sf.marineapi.nmea.util.DataStatus.ACTIVE);
		java.lang.System.out.println(mwv.toSentence());
	}
}