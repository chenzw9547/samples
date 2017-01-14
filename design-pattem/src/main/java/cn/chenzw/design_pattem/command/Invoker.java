package cn.chenzw.design_pattem.command;

/**
 * 调用者(命令控制类)
 * 
 * @author chenzw
 * @date 2017年1月14日
 */
public class Invoker {

	private ICommand command;

	public void setCommand(ICommand command) {
		this.command = command;
	}

	public void runCommand() {
		// 调用命令对象的执行方法
		command.execute();
	}
	
	public void undoCommand(){
		command.undo();
	}
	

}
