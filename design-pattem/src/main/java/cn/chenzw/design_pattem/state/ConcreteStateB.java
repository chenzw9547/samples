package cn.chenzw.design_pattem.state;

public class ConcreteStateB extends State {

	@Override
	String next(Context context) {
		context.setState(new ConcreteStateC());
		return "This is B!";
	}

	@Override
	String request(Context context) {
		context.setState(new ConcreteStateA());
		return "request B!";
	}

}
