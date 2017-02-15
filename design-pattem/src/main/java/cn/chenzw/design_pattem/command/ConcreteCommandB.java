package cn.chenzw.design_pattem.command;

/**
 * 具体的命令实现对象
 * @author chenzw
 * @date 2017年1月14日
 */
public class ConcreteCommandB implements ICommand{

	private Receiver receiver;
	
	ConcreteCommandB(Receiver receiver){
		this.receiver = receiver;
	}
	
	@Override
	public void execute() {
		receiver.actionOff();
	}

	@Override
	public void undo() {
		receiver.actionOn();
	}

}
