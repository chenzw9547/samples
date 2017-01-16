package cn.chenzw.design_pattem.state;

public abstract class State {

	abstract String next(Context context);
	
	abstract String request(Context context);
}
