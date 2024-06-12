public class DeadMain {
	public static void main(java.lang.String[] args) {
		akka.actor.ActorSystem system = akka.actor.ActorSystem.create("deadwatch", com.typesafe.config.ConfigFactory.load("samplehello.conf"));
		akka.actor.ActorRef worker = system.actorOf(akka.actor.Props.create(ch7.s4.MyWorker.class), "worker");
		system.actorOf(akka.actor.Props.create(ch7.s4.WatchActor.class, worker), "watcher");
		worker.tell(ch7.s4.MyWorker.Msg.WORKING, akka.actor.ActorRef.noSender());
		worker.tell(ch7.s4.MyWorker.Msg.DONE, akka.actor.ActorRef.noSender());
		worker.tell(akka.actor.PoisonPill.getInstance(), akka.actor.ActorRef.noSender());
	}
}