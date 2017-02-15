package cn.chenzw.design_pattem.template;

/**
 * 模板类
 * 
 * @author chenzw
 * @date 2017年1月15日
 */
public abstract class AbstractTemplate {

	/**
	 * 模板方法,必须声明为final方法 封装了方法的执行顺序
	 */
	final void templateMethod() {
		this.operation1();
		this.operation2();
		if(this.isExists()){
			this.operation3();
		}
		
	}

	// 基本方法1
	protected abstract void operation1();

	// 基本方法2
	protected abstract void operation2();

	// 基本方法3
	protected abstract void operation3();

	// 钩子
	protected abstract boolean isExists();

}
