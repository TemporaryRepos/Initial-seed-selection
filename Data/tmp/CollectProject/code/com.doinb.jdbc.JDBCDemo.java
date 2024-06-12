public class JDBCDemo {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		com.doinb.jdbc.JDBCDemo jdbcDemo = new com.doinb.jdbc.JDBCDemo();
		for (int i = 0; i < 15; i++) {
			java.util.concurrent.TimeUnit.SECONDS.sleep(1);
			new java.lang.Thread(() -> {
				try {
					jdbcDemo.findAllUsers();
				} catch (java.lang.Exception e) {
					e.printStackTrace();
				}
			}, ("第" + i) + "个线程").start();
		}
	}

	public void findAllUsers() throws java.sql.SQLException, java.lang.ClassNotFoundException {
		java.lang.Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/sell?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false", "mysqldb", "123456");
		java.sql.Statement state = con.createStatement();
		java.sql.ResultSet result = state.executeQuery("select * from order_detail");
		while (result.next()) {
			java.lang.System.out.println("使用原生JDBC查询：" + result.getString("order_id"));
		} 
		result.close();
		state.close();
		con.close();
	}

	public void findAllUsersByDataSource() throws java.sql.SQLException {
		java.lang.System.out.println(java.lang.Thread.currentThread().getName() + "\t 进行调用");
		com.doinb.jdbc.MyDataSource dataSource = new com.doinb.jdbc.MyDataSource();
		java.sql.Connection conn = dataSource.getConnection();
		java.sql.Statement state = conn.createStatement();
		java.sql.ResultSet result = state.executeQuery("select * from order_detail");
		while (result.next()) {
			java.lang.System.out.println("使用连接池查询：" + result.getString("order_id"));
		} 
		result.close();
		state.close();
		dataSource.releaseConnection(conn);
	}
}