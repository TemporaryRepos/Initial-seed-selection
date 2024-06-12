public class ConsoleSQLInterpreter {
	private static java.sql.Connection conn = null;

	public static void main(java.lang.String[] args) {
		try {
			java.sql.Driver d = new org.vanilladb.core.remote.jdbc.JdbcDriver();
			org.vanilladb.core.util.ConsoleSQLInterpreter.conn = d.connect("jdbc:vanilladb://localhost", null);
			java.io.Reader rdr = new java.io.InputStreamReader(java.lang.System.in);
			java.io.BufferedReader br = new java.io.BufferedReader(rdr);
			while (true) {
				java.lang.System.out.print("\nSQL> ");
				java.lang.String cmd = br.readLine().trim();
				java.lang.System.out.println();
				java.lang.String[] str = cmd.split(" ");
				java.lang.String cmdf = str[0].toUpperCase();
				if (cmd.startsWith("exit") || cmd.startsWith("EXIT")) {
					break;
				} else if (cmdf.startsWith("SELECT") || cmdf.startsWith("EXPLAIN")) {
					org.vanilladb.core.util.ConsoleSQLInterpreter.doQuery(cmd, cmdf);
				} else {
					org.vanilladb.core.util.ConsoleSQLInterpreter.doUpdate(cmd);
				}
			} 
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (org.vanilladb.core.util.ConsoleSQLInterpreter.conn != null) {
					org.vanilladb.core.util.ConsoleSQLInterpreter.conn.close();
				}
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static void doQuery(java.lang.String cmd, java.lang.String cmdf) {
		try {
			java.sql.Statement stmt = org.vanilladb.core.util.ConsoleSQLInterpreter.conn.createStatement();
			java.sql.ResultSet rs = stmt.executeQuery(cmd);
			java.sql.ResultSetMetaData md = rs.getMetaData();
			int numcols = md.getColumnCount();
			int totalwidth = 0;
			for (int i = 1; i <= numcols; i++) {
				int width = md.getColumnDisplaySize(i);
				totalwidth += width;
				java.lang.String fmt = ("%" + width) + "s";
				if (cmdf.startsWith("EXPLAIN")) {
					java.lang.System.out.format("%s", md.getColumnName(i));
				} else {
					java.lang.System.out.format(fmt, md.getColumnName(i));
				}
			}
			java.lang.System.out.println();
			for (int i = 0; i < totalwidth; i++) {
				java.lang.System.out.print("-");
			}
			if (!cmdf.startsWith("EXPLAIN")) {
				java.lang.System.out.println();
			}
			rs.beforeFirst();
			while (rs.next()) {
				for (int i = 1; i <= numcols; i++) {
					java.lang.String fldname = md.getColumnName(i);
					int fldtype = md.getColumnType(i);
					java.lang.String fmt = "%" + md.getColumnDisplaySize(i);
					if (fldtype == java.sql.Types.INTEGER) {
						java.lang.System.out.format(fmt + "d", rs.getInt(fldname));
					} else if (fldtype == java.sql.Types.BIGINT) {
						java.lang.System.out.format(fmt + "d", rs.getLong(fldname));
					} else if (fldtype == java.sql.Types.DOUBLE) {
						java.lang.System.out.format(fmt + "f", rs.getDouble(fldname));
					} else {
						java.lang.System.out.format(fmt + "s", rs.getString(fldname));
					}
				}
				java.lang.System.out.println();
			} 
			rs.close();
		} catch (java.sql.SQLException e) {
			java.lang.System.out.println("SQL Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private static void doUpdate(java.lang.String cmd) {
		try {
			java.sql.Statement stmt = org.vanilladb.core.util.ConsoleSQLInterpreter.conn.createStatement();
			int howmany = stmt.executeUpdate(cmd);
			java.lang.System.out.println(howmany + " records processed");
		} catch (java.sql.SQLException e) {
			java.lang.System.out.println("SQL Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}