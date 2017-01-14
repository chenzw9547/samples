package cn.chenzw.design_pattem.command;

/**
 * 具体的命令实现对象
 * @author chenzw
 * @date 2017年1月14日
 */
public class ConcreteCommandC implements ICommand{

	private Receiver receiver;
	
	ConcreteCommandC(Receiver receiver){
		this.receiver = receiver;
	}
	
	@Override
	public void execute() {
		receiver.actionOn();
	}

	@Override
	public void undo() {
		receiver.actionOff();
	}

}
