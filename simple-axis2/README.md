# Aixs2 Sample:
#### 步骤如下(使用POJO方式):
1. WEB-INF/web.xml中添加Axis2的Servlet入口:
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

2. 创建services.xml,放到WEB-INF/services/项目名/META-INF目录下。

3. 使用maven配置jar包依赖(最少配置):
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

5. 发布到Web服务器上，使用http://localhost:8080/simple-axis2/services/weatherSerivce?wsdl 进行访问。

4. 客户端使用RPCServiceClient对象进行调用，详见代码。

>官方文档:[Apache Axis2 Pojo Guide](http://axis.apache.org/axis2/java/core/docs/pojoguide.html)
