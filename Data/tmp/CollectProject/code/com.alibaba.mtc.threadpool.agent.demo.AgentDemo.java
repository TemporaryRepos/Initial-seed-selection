public class AgentDemo {
	static com.alibaba.mtc.MtContextThreadLocal<java.lang.String> stringMtContextThreadLocal = new com.alibaba.mtc.MtContextThreadLocal<java.lang.String>();

	static com.alibaba.mtc.MtContextThreadLocal<com.alibaba.mtc.threadpool.agent.demo.AgentDemo.Person> personReferenceMtContextThreadLocal = new com.alibaba.mtc.MtContextThreadLocal<com.alibaba.mtc.threadpool.agent.demo.AgentDemo.Person>() {
		@java.lang.Override
		protected com.alibaba.mtc.threadpool.agent.demo.AgentDemo.Person initialValue() {
			return new com.alibaba.mtc.threadpool.agent.demo.AgentDemo.Person("unnamed", -1);
		}
	};

	static com.alibaba.mtc.MtContextThreadLocal<com.alibaba.mtc.threadpool.agent.demo.AgentDemo.Person> personCopyMtContextThreadLocal = new com.alibaba.mtc.MtContextThreadLocal<com.alibaba.mtc.threadpool.agent.demo.AgentDemo.Person>() {
		@java.lang.Override
		protected com.alibaba.mtc.threadpool.agent.demo.AgentDemo.Person copy(com.alibaba.mtc.threadpool.agent.demo.AgentDemo.Person parentValue) {
			return new com.alibaba.mtc.threadpool.agent.demo.AgentDemo.Person(parentValue.getName(), parentValue.getAge());
		}

		@java.lang.Override
		protected com.alibaba.mtc.threadpool.agent.demo.AgentDemo.Person initialValue() {
			return new com.alibaba.mtc.threadpool.agent.demo.AgentDemo.Person("unnamed", -1);
		}
	};

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.util.concurrent.ExecutorService executorService = java.util.concurrent.Executors.newFixedThreadPool(3);
		com.alibaba.mtc.threadpool.agent.demo.AgentDemo.expandThreadPool(executorService);
		com.alibaba.mtc.threadpool.agent.demo.AgentDemo.stringMtContextThreadLocal.set("foo - main");
		com.alibaba.mtc.threadpool.agent.demo.AgentDemo.personReferenceMtContextThreadLocal.set(new com.alibaba.mtc.threadpool.agent.demo.AgentDemo.Person("jerry - reference", 1));
		com.alibaba.mtc.threadpool.agent.demo.AgentDemo.personCopyMtContextThreadLocal.set(new com.alibaba.mtc.threadpool.agent.demo.AgentDemo.Person("Tom - value", 2));
		com.alibaba.mtc.threadpool.agent.demo.AgentDemo.printMtContextInfo("Main - Before execution of thread pool");
		java.util.concurrent.Future<?> submit = executorService.submit(new java.lang.Runnable() {
			@java.lang.Override
			public void run() {
				com.alibaba.mtc.threadpool.agent.demo.AgentDemo.printMtContextInfo("Thread Pool - enter");
				com.alibaba.mtc.threadpool.agent.demo.AgentDemo.stringMtContextThreadLocal.set("foo - modified in thread pool");
				com.alibaba.mtc.threadpool.agent.demo.AgentDemo.personReferenceMtContextThreadLocal.get().setName("jerry - reference - modified in thread pool");
				com.alibaba.mtc.threadpool.agent.demo.AgentDemo.personCopyMtContextThreadLocal.get().setName("Tom - value - modified in thread pool");
				com.alibaba.mtc.threadpool.agent.demo.AgentDemo.printMtContextInfo("Thread Pool - leave");
			}
		});
		submit.get();
		com.alibaba.mtc.threadpool.agent.demo.AgentDemo.printMtContextInfo("Main - After execution of thread pool");
		java.lang.System.exit(0);
	}

	public static void expandThreadPool(java.util.concurrent.ExecutorService executor) throws java.lang.Exception {
		java.util.List<java.util.concurrent.Future<?>> ret = new java.util.ArrayList<java.util.concurrent.Future<?>>();
		for (int i = 0; i < 3; ++i) {
			java.util.concurrent.Future<?> submit = executor.submit(new java.lang.Runnable() {
				@java.lang.Override
				public void run() {
					try {
						java.lang.Thread.sleep(1000);
					} catch (java.lang.InterruptedException e) {
						throw new java.lang.RuntimeException(e);
					}
				}
			});
			ret.add(submit);
		}
		for (java.util.concurrent.Future<?> future : ret) {
			future.get();
		}
	}

	static void printMtContextInfo(java.lang.String msg) {
		java.lang.System.out.println("====================================================");
		java.lang.System.out.println(msg);
		java.lang.System.out.println("====================================================");
		java.lang.System.out.println("stringMtContextThreadLocal: " + com.alibaba.mtc.threadpool.agent.demo.AgentDemo.stringMtContextThreadLocal.get());
		java.lang.System.out.println("personReferenceMtContextThreadLocal: " + com.alibaba.mtc.threadpool.agent.demo.AgentDemo.personReferenceMtContextThreadLocal.get());
		java.lang.System.out.println("personCopyMtContextThreadLocal: " + com.alibaba.mtc.threadpool.agent.demo.AgentDemo.personCopyMtContextThreadLocal.get());
	}

	public static class Person {
		java.lang.String name;

		int age;

		public java.lang.String getName() {
			return name;
		}

		public void setName(java.lang.String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public Person(java.lang.String name, int age) {
			this.name = name;
			this.age = age;
		}

		@java.lang.Override
		public java.lang.String toString() {
			return ((((("Person{" + "name='") + name) + '\'') + ", age=") + age) + '}';
		}
	}
}