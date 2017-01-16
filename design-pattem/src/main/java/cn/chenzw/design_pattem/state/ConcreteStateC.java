package cn.chenzw.design_pattem.state;

public class ConcreteStateC extends State {

	@Override
	String next(Context context) {
		context.setState(new ConcreteStateA());
		return "This is C!";
	}

	@Override
	String request(Context context) {
		context.setState(new ConcreteStateB());
		return "request C!";
	}

}
