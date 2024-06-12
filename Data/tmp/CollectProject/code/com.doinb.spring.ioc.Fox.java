public class Fox implements org.springframework.beans.factory.InitializingBean , org.springframework.beans.factory.DisposableBean {
	public Fox() {
		java.lang.System.out.println("【IoC源码学习】Construct~fox");
	}

	@javax.annotation.PostConstruct
	public void init() {
		java.lang.System.out.println("【IoC源码学习】@PostConstruct~init");
	}

	@javax.annotation.PostConstruct
	public void init2() {
		java.lang.System.out.println("【IoC源码学习】@PostConstruct~init2");
	}

	@java.lang.Override
	public void destroy() throws java.lang.Exception {
		java.lang.System.out.println("【IoC源码学习】destroy~");
	}

	@java.lang.Override
	public void afterPropertiesSet() throws java.lang.Exception {
		java.lang.System.out.println("【IoC源码学习】afterPropertiesSet~");
	}

	public static void main(java.lang.String[] args) {
	}
}