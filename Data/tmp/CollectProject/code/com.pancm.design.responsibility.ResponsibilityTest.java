public class ResponsibilityTest {
	public static void main(java.lang.String[] args) {
		java.lang.String name = "xuwujing";
		java.lang.String something = "去聚餐";
		java.lang.String something2 = "去旅游";
		com.pancm.design.responsibility.Leader leader1 = new com.pancm.design.responsibility.Supervisor(name, something);
		com.pancm.design.responsibility.Leader leader2 = new com.pancm.design.responsibility.BranchManager(name, something);
		com.pancm.design.responsibility.Leader leader3 = new com.pancm.design.responsibility.GeneralManager(name, something);
		leader1.setLeader(leader2);
		leader2.setLeader(leader3);
		leader1.handler(1);
		com.pancm.design.responsibility.Leader leader4 = new com.pancm.design.responsibility.Supervisor(name, something2);
		com.pancm.design.responsibility.Leader leader5 = new com.pancm.design.responsibility.BranchManager(name, something2);
		com.pancm.design.responsibility.Leader leader6 = new com.pancm.design.responsibility.GeneralManager(name, something2);
		leader4.setLeader(leader5);
		leader5.setLeader(leader6);
		leader4.handler(0);
	}
}