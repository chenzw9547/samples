# 设计模式 Samples:
## 1. [策略模式(算法簇模式)](src/main/java/cn/chenzw/design_pattem/strategy) :

** 定义 ** :定义了不同的算法族（实现共同的接口），并且之间可以互相替换，此模式让算法的变化独立于使用算法的客户。

策略模式中有3个对象：
- **环境对象**：该类中实现了对抽象策略中定义的接口或者抽象类的引用（持有一个Strategy的引用）
- **抽象策略对象**：它可由接口或抽象类来实现。
- **具体策略对象**：它封装了实现同不功能的不同算法。


## 2. [观察者模式](src/main/java/cn/chenzw/design_pattem/observer) :

** 定义 ** :定义了对象之间的一对多依赖，当一个对象改变状态时，它的所有依赖都会收到通知并自动更新。

观察者模式有4个对象：
- ** 抽象主题（Subject）** : 主题的抽象接口, 定义了新增观察者、删除观察者和通知观察者方法。
- ** 具体主题（ConcreteSubject）** ：维护了一个观察者列表数据，当其状态发生改变时，它会将这个变化通知观察者。
- ** 抽象观察者（Observer） ** : 定义了接收更新的方法。
- ** 具体观察者（ConcreteObserver）** ：实现接收方法，对接收到的数据进行更新。

## 2.1 [JDK提供的观察者模式](src/main/java/cn/chenzw/design_pattem/jdk_observer) :
通过继承java.util.Observable类来创建主题类，通过实现java.util.Observer接口来创建观察者类，此处值得注意的是，在调用Observable类的notifyObservers()或notifyObservers(Object)前，必须先setChange()。
