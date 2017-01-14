package cn.chenzw.design_pattem.singleton;

import junit.framework.Assert;
import cn.chenzw.design_pattem.singleton.enums.EnumSingleton;
import cn.chenzw.design_pattem.singleton.hungry.HungrySingleton;
import cn.chenzw.design_pattem.singleton.inner.StaticSingleton;
import cn.chenzw.design_pattem.singleton.lazy.LazySingleton;
import cn.chenzw.design_pattem.singleton.lazy.LazySingleton2;

public class Test {

	public static void main(String[] args) {

		// 恶汉模式
		Assert.assertSame(HungrySingleton.getInstance(),
				HungrySingleton.getInstance());

		// 懒汉模式
		Assert.assertSame(LazySingleton.getInstance(),
				LazySingleton.getInstance());

		// 懒汉模式 -- 使用双重检查锁
		Assert.assertSame(LazySingleton2.getInstance(),
				LazySingleton2.getInstance());

		// 内部静态类
		Assert.assertSame(StaticSingleton.getInstance(),
				StaticSingleton.getInstance());

		// 使用枚举
		Assert.assertSame(EnumSingleton.INSTANCE, EnumSingleton.INSTANCE);

	}

}
