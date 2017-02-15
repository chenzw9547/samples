package cn.chenzw.design_pattem.command;

public class Test {

	public static void main(String[] args) {
		// 创建接收者
		Receiver receiver = new Receiver();
		// 创建命令对象，设定它的接收者
		ICommand commandA = new ConcreteCommandA(receiver);
		ICommand commandB = new ConcreteCommandB(receiver);
		ICommand commandC = new ConcreteCommandC(receiver);	
		// 创建Invoker，把命令对象设置进去
		Invoker invoker = new Invoker();
		//invoker.setCommand(commandA);
		invoker.setCommand(commandB);
		//invoker.setCommand(commandC);
		
		invoker.runCommand();
		invoker.undoCommand();
	}
}
