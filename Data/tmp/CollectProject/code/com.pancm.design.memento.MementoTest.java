public class MementoTest {
	public static void main(java.lang.String[] args) {
		int level = 1;
		int life = 100;
		com.pancm.design.memento.Player player = new com.pancm.design.memento.Player(level, life);
		java.lang.System.out.println("玩家xuwujing进入游戏!");
		player.getStatus();
		player.leveling();
		com.pancm.design.memento.GameSavePage savePage = new com.pancm.design.memento.GameSavePage();
		player.getStatus();
		java.lang.System.out.println("玩家xuwujing正在存档...");
		savePage.setSm(player.saveStateToMemento());
		java.lang.System.out.println("玩家xuwujing存档成功!");
		java.lang.System.out.println("玩家xuwujing挑战新手村的BOSS!");
		boolean flag = player.challengeBOSS();
		if (flag) {
			java.lang.System.out.println("玩家xuwujing挑战BOSS成功!");
			return;
		}
		java.lang.System.out.println("玩家xuwujing挑战BOSS失败!游戏结束！开始读取存档...");
		savePage.getSm();
		java.lang.System.out.println("玩家xuwujing读取存档成功!");
		player.leveling();
		player.getStatus();
		java.lang.System.out.println("玩家xuwujing挑战新手村的BOSS!");
		flag = player.challengeBOSS();
		if (flag) {
			java.lang.System.out.println("玩家xuwujing挑战BOSS成功!");
			return;
		}
	}
}