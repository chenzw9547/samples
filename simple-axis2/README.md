
## Aixs2 Sample:

#### POJO方式:

** 1. WEB-INF/web.xml中添加Axis2的Servlet入口: **

```
<!--所有访问services/*的路径都转发到AxisServlet上 -->
<servlet>
       <servlet-name>AxisServlet</servlet-name>
       <servlet-class>
           org.apache.axis2.transport.http.AxisServlet
       </servlet-class>
       <load-on-startup>1</load-on-startup>
   </servlet>
   <servlet-mapping>
       <servlet-name>AxisServlet</servlet-name>
       <url-pattern>/services/*</url-pattern>
   </servlet-mapping>
```
** 2.创建services.xml,放到WEB-INF/services/项目名/META-INF目录下。**

eg.
```
<?xml version="1.0" encoding="UTF-8"?>
<serviceGroup>
	<!-- 发布的service名称为weatherService -->
	<service name="weatherService">
		<description>POJO</description>
		<messageReceivers>
			<messageReceiver mep="http://www.w3.org/2004/08/wsdl/in-only"
				class="org.apache.axis2.rpc.receivers.RPCInOnlyMessageReceiver" />
			<messageReceiver mep="http://www.w3.org/2004/08/wsdl/in-out"
				class="org.apache.axis2.rpc.receivers.RPCMessageReceiver" />
		</messageReceivers>
		<!-- 指定service的全限定名类 -->
		<parameter name="ServiceClass">cn.chenzw.simple_axis2.ws.WeatherWs</parameter>
	</service>
</serviceGroup>
```

** 3. 使用maven配置jar包依赖(最少配置) **
```
<!-- axis2 dependencies -->
		<dependency>
			<groupId>org.apache.axis2</groupId>
			<artifactId>axis2</artifactId>
			<version>${axis2.version}</version>
		</dependency>
		<dependency>
			<groupId>org.apache.axis2</groupId>
			<artifactId>axis2-adb</artifactId>
			<version>${axis2.version}</version>
		</dependency>
		<dependency>
			<groupId>org.apache.axis2</groupId>
			<artifactId>axis2-transport-http</artifactId>
			<version>${axis2.version}</version>
		</dependency>
		<dependency>
			<groupId>org.apache.axis2</groupId>
			<artifactId>axis2-transport-local</artifactId>
			<version>${axis2.version}</version>
		</dependency>
		<dependency>
			<groupId>org.apache.axis2</groupId>
			<artifactId>axis2-kernel</artifactId>
			<version>${axis2.version}</version>
			<exclusions>
				<exclusion>
					<groupId>javax.servlet</groupId>
					<artifactId>javax.servlet-api</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
		<!--/ axis2 dependencies -->
```

** 4. 发布到Web服务器上，使用http://localhost:8080/simple-axis2/services/weatherSerivce?wsdl 进行访问。**

** 5. 客户端使用RPCServiceClient对象进行调用，详见代码。**

>官方文档:[Apache Axis2 Pojo Guide](http://axis.apache.org/axis2/java/core/docs/pojoguide.html)

## POJO与Spring集成

** 1. 增加axis2-spring及相关spring-framework包 **
```
<!-- axis2-spring,去除重复的依赖 -->
<dependency>
  <groupId>org.apache.axis2</groupId>
  <artifactId>axis2-spring</artifactId>
  <version>${axis2.version}</version>
  <exclusions>
    <exclusion>
      <artifactId>spring-web</artifactId>
      <groupId>org.springframework</groupId>
    </exclusion>
    <exclusion>
      <artifactId>spring-context</artifactId>
      <groupId>org.springframework</groupId>
    </exclusion>
    <exclusion>
      <artifactId>spring-beans</artifactId>
      <groupId>org.springframework</groupId>
    </exclusion>
    <exclusion>
      <artifactId>spring-core</artifactId>
      <groupId>org.springframework</groupId>
    </exclusion>
    <exclusion>
      <artifactId>axis2-kernel</artifactId>
      <groupId>org.apache.axis2</groupId>
    </exclusion>
  </exclusions>
</dependency>
<!-- /axis2-spring -->
<!-- spring-framework(略) -->
```

** 2.services.xml中的`<service>`标签中指定`SpringBeanName`及`ServiceObjectSupplier`属性 **

```
<service name="WeatherSpringService">
  <description>POJO SPRING</description>
  <parameter name="ServiceObjectSupplier">org.apache.axis2.extensions.spring.receivers.SpringServletContextObjectSupplier
  </parameter>
  <parameter name="SpringBeanName">weatherSpringWs</parameter>
  <messageReceivers>
    <messageReceiver mep="http://www.w3.org/ns/wsdl/in-out"
      class="org.apache.axis2.rpc.receivers.RPCMessageReceiver" />
  </messageReceivers>
</service>
```
** 3. 必须配置`org.springframework.web.context.ContextLoaderListener`监听器,在applicationContext.xml中必须定义SpringBeanName指定的bean(手动定义或使用自动扫描均可) **

```
<listener>
  <listener-class>org.springframework.web.context.ContextLoaderListener
  </listener-class>
</listener>
<context-param>
  <param-name>contextConfigLocation</param-name>
  <param-value>classpath:applicationContext.xml</param-value>
</context-param>
```
