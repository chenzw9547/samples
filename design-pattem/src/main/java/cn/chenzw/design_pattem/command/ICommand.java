package cn.chenzw.design_pattem.command;

/**
 * 命令接口，声明执行的操作
 * 
 * @author chenzw
 * @date 2017年1月14日
 */
public interface ICommand {

	void execute();

	void undo();
}
