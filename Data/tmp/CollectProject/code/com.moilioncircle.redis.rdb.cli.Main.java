public class Main {
	public static void main(java.lang.String[] args) {
		if (args.length == 0) {
			return;
		}
		java.lang.String command = args[0];
		if (command == null) {
			return;
		}
		java.lang.String[] ary = java.util.Arrays.copyOfRange(args, 1, args.length);
		if (command.equals("rct")) {
			com.moilioncircle.redis.rdb.cli.Rct.main(ary);
		} else if (command.equals("rdt")) {
			com.moilioncircle.redis.rdb.cli.Rdt.main(ary);
		} else if (command.equals("ret")) {
			com.moilioncircle.redis.rdb.cli.Ret.main(ary);
		} else if (command.equals("rmt")) {
			com.moilioncircle.redis.rdb.cli.Rmt.main(ary);
		} else if (command.equals("rst")) {
			com.moilioncircle.redis.rdb.cli.Rst.main(ary);
		} else if (command.equals("rcut")) {
			com.moilioncircle.redis.rdb.cli.Rcut.main(ary);
		} else if (command.equals("rmonitor")) {
			com.moilioncircle.redis.rdb.cli.RMonitor.main(ary);
		}
	}
}