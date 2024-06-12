public abstract class MercatorProjection {
	public static void main(java.lang.String[] args) {
		java.io.BufferedReader buf = null;
		double latRad;
		double mercN;
		java.io.BufferedWriter bw = null;
		java.io.FileWriter fw = null;
		try {
			buf = new java.io.BufferedReader(new java.io.FileReader("all_nodes_small.csv"));
			java.lang.String line = new java.lang.String();
			java.lang.String[] wordsArray;
			java.io.File file = new java.io.File("AllNodesMercator.csv");
			fw = new java.io.FileWriter(file.getAbsoluteFile());
			bw = new java.io.BufferedWriter(fw);
			double largestLatitude = 85.051129;
			while ((line = buf.readLine()) != null) {
				if (line.length() > 0) {
					java.lang.String[] words = line.split("\t");
					double latitude = java.lang.Double.parseDouble(words[2]);
					if (java.lang.Math.abs(latitude) > largestLatitude) {
						continue;
					}
					double longitude = java.lang.Double.parseDouble(words[1]);
					double lambda = (longitude * java.lang.Math.PI) / 180;
					double phi = (latitude * java.lang.Math.PI) / 180;
					double x = (128 / java.lang.Math.PI) * (lambda + java.lang.Math.PI);
					double y = (128 / java.lang.Math.PI) * (java.lang.Math.PI - java.lang.Math.log(java.lang.Math.tan((java.lang.Math.PI / 4) + (phi / 2))));
					if (!file.exists()) {
						file.createNewFile();
					}
					java.lang.String data = (((((words[0] + "\t") + x) + "\t") + y) + "\t") + words[3];
					bw.write(data);
					bw.write("\n");
				}
			} 
		} catch (java.io.FileNotFoundException e) {
			e.printStackTrace();
		} catch (java.io.IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (java.io.IOException e) {
					e.printStackTrace();
				}
			}
			if (buf != null) {
				try {
					buf.close();
				} catch (java.io.IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}