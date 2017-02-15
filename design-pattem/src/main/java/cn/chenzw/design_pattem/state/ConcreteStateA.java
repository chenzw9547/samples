package cn.chenzw.design_pattem.state;

public class ConcreteStateA extends State {

	@Override
	public String next(Context context) {
		context.setState(new ConcreteStateB());
		return "This is A!";
	}

	@Override
	String request(Context context) {
		context.setState(new ConcreteStateC());
		return "request A!";
	}

}
