# 设计模式 Samples:
## 1. [策略模式(算法簇模式)](src/main/java/cn/chenzw/design_pattem/strategy) :

**定义** :定义了不同的算法族（实现共同的接口），并且之间可以互相替换，此模式让算法的变化独立于使用算法的客户。

策略模式中有3个对象：
- **环境对象**：该类中实现了对抽象策略中定义的接口或者抽象类的引用（持有一个Strategy的引用）
- **抽象策略对象**：它可由接口或抽象类来实现。
- **具体策略对象**：它封装了实现同不功能的不同算法。


## 2. [观察者模式](src/main/java/cn/chenzw/design_pattem/observer) :

**定义** :定义了对象之间的一对多依赖，当一个对象改变状态时，它的所有依赖都会收到通知并自动更新。

观察者模式有4个对象：
- **抽象主题（Subject）** : 主题的抽象接口, 定义了新增观察者、删除观察者和通知观察者方法。
- **具体主题（ConcreteSubject）** ：维护了一个观察者列表数据，当其状态发生改变时，它会将这个变化通知观察者。
- **抽象观察者（Observer）** : 定义了接收更新的方法。
- **具体观察者（ConcreteObserver）** ：实现接收方法，对接收到的数据进行更新。

## 2.1 [JDK提供的观察者模式](src/main/java/cn/chenzw/design_pattem/jdk_observer) :
通过继承java.util.Observable类来创建主题类，通过实现java.util.Observer接口来创建观察者类，此处值得注意的是，在调用Observable类的notifyObservers()或notifyObservers(Object)前，必须先调用setChanged()来标记状态已改变，否则不会通知观察者。

## 3. [装饰者模式](src/main/java/cn/chenzw/design_pattem/decorator) :

**定义** : 动态地将责任附加到对象上。

装饰者模式的设计原则为：对扩展开放、对修改关闭（想扩展被装饰者类的行为，无须修改装饰者抽象类，只需继承装饰者抽象类，实现额外的一些装饰或者叫行为即可对被装饰者进行包装。）

装饰者模式主要有4个对象： （一个被装饰者对应多个装饰者）
- **抽象被装饰者（Componenet）** ：定义了核心的业务方法
- **具体被装饰者（ConcreteComponent）** ：实现Component接口，实现具体核心的业务
- **抽象装饰者（Decorator）** ：实现Component接口，并使用策略模式，持有一个Component的引用。通常为虚类，避免被实例化。
- **具体装饰者（ConcreteDecorator）** ：继承Decorator类（此继承主要是想达到装饰者和被装饰对象的类型匹配，而不是获得其行为），调用super的业务方法，并在此调用前后加上要装饰的业务逻辑。

## 4. [简单工厂模式|静态工厂模式](src/main/java/cn/chenzw/design_pattem/simple_factory) :

**定义** : 定义一个用于创建对象的接口。

简单工厂有3个角色：
- **工厂类角色（Factory）** ：这是本模式的核心，含有一定的商业逻辑和判断逻辑。往往由一个具体类实现。
- **抽象产品角色（Product）** ：产品的抽象类。由接口或者抽象类来实现。
- **具体产品角色（ConcreteProduct）** ：工厂类所创建的对象就是此角色的实例。

## 5. [工厂模式](src/main/java/cn/chenzw/design_pattem/factory) :

**定义** : 定义了一个创建对象的接口，但由子类决定要实例化的类是哪一个。工厂方法让类把实例化推迟到子类。

工厂模式有4个角色：
- **抽象工厂角色** ： 这是工厂方法模式的核心，它与应用程序无关。是具体工厂角色必须实现的接口或者必须继承的父类。由抽象类或者接口来实现。
- **具体工厂角色** ：它含有和具体业务逻辑有关的代码。由应用程序调用以创建对应的具体产品的对象。
- **抽象产品角色** ：产品的抽象类。一般由抽象类或者接口来实现。
- **具体产品角色** ：具体工厂角色所创建的对象就是此角色的实例。

## 6. [抽象工厂模式](src/main/java/cn/chenzw/design_pattem/absract_factory) :

**定义** : 提供了一个接口，用于创建一系列`相关或依赖`对象的家族（`产品族`），而不需要明确指定具体类。

## 7. [单例模式](src/main/java/cn/chenzw/design_pattem/singleton) :

单例模式主要有以下几种实现方式：
- **[恶汉模式](src/main/java/cn/chenzw/design_pattem/singleton/hungry)**
- **[懒汉模式](src/main/java/cn/chenzw/design_pattem/singleton/lazy)**
- **[懒汉模式-使用双重检查锁](src/main/java/cn/chenzw/design_pattem/singleton/hungry)**
- **[使用内部静态类](src/main/java/cn/chenzw/design_pattem/singleton/inner)**
