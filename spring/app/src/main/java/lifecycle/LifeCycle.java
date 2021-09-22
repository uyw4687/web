package lifecycle;

//public class LifeCycle implements InitializingBean, DisposableBean {
public class LifeCycle {
	
	private String host;
	
	public LifeCycle() {
		System.out.println("creating object");
	}

	public void customStart() {
		System.out.println("custom start");
	}
	
	public void customDestroy() {
		System.out.println("custom destroy");
	}
	
//	@Override
//	public void afterPropertiesSet() throws Exception {
//		System.out.println("after props set");
//	}
//	
//	@Override
//	public void destroy() throws Exception {
//		System.out.println("destroy");
//	}

	public void setHost(String host) {
		System.out.println("setting host");
		this.host = host;
	}

	public void whoami() {
		System.out.println("I am " + host);
	}
	
}
