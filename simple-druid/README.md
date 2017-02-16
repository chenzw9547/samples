## 配置步骤
#### 1. 引入druid相关jar包,maven方式如下:
```
<!-- druid -->
<dependency>
	<groupId>com.alibaba</groupId>
	<artifactId>druid</artifactId>
	<version>${druid.version}</version>
</dependency>
<!-- /druid -->
<properties>
	<druid.version>1.0.28</druid.version>
</properties>
```

#### 2. 定义druid数据源:
```
<!-- 定义数据源Bean，使用DruidDataSource -->
	<bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource"
		init-method="init" destroy-method="close">
		<!-- 指定连接数据库的驱动 -->
		<property name="driverClassName" value="org.sqlite.JDBC" />
		<!-- 指定连接数据库的URL -->
		<property name="url"
			value="jdbc:sqlite:resource:sample.db" />
		<!-- 指定数据库用户名和密码 -->
		<!-- <property name="username" value=""></property> -->
		<!-- <property name="password" value=""></property> -->

		<!-- 配置连接池初始化大小，最小，最大容量 -->
		<property name="initialSize" value="1"></property>
		<property name="minIdle" value="1"></property>
		<property name="maxActive" value="50"></property>
		<!-- 配置获取连接等待超时时间 -->
		<!-- <property name="maxWait" value="60000"></property> -->
		<!-- 配置间隔多久才进行一次检测，检查需要关闭的空闲连接，单位毫秒 -->
		<!-- <property name="timeBetweenEvictionRunsMillis" value="60000"></property> -->
		<!-- 配置一个连接在池中最小生存的时间，单位毫秒 -->
		<!-- <property name="minEvictableIdleTimeMillis" value="300000"></property> -->

		<!-- 慢SQL记录,执行时间超过slowSqlMillis的就是慢。slowSqlMillis的缺省值为3000，也就是3秒 -->
		<!-- <property name="connectionProperties" value="druid.stat.slowSqlMillis=5000" 
			/> -->

		<!-- 连接泄漏 -->
		<!-- 配置removeAbandoned对性能会有一些影响，建议怀疑存在泄漏之后再打开。在上面的配置中，如果连接超过30分钟未关闭，就会被强行回收，并且日志记录连接申请时的调用堆栈。 -->
		<!-- 打开removeAbandoned功能 -->
		<!-- <property name="removeAbandoned" value="true" /> -->
		<!-- 900秒，也就是15分钟 -->
		<!-- <property name="removeAbandonedTimeout" value="900" /> -->
		<!-- 关闭abanded连接时输出错误日志 -->
		<!-- <property name="logAbandoned" value="true" /> -->

		<!-- 配置监控统计拦截的filters -->
		<property name="filters" value="stat,log4j2" />

		<!-- 每隔10分钟把监控数据输出到日志中,每次输出日志会导致清零（reset）连接池相关的计数器,单位:毫秒 -->
		<!-- <property name="timeBetweenLogStatsMillis" value="600000" /> -->

		<!-- 打开PSCache，并且指定每个连接上PSCache的大小 -->
		<!-- <property name="poolPreparedStatements" value="true" /> -->
		<!-- <property name="maxPoolPreparedStatementPerConnectionSize" value="20" /> -->

		<!-- <property name="validationQuery" value="SELECT 'x' FROM DUAL" /> -->
		<!-- <property name="testWhileIdle" value="true" /> -->
		<!-- <property name="testOnBorrow" value="false" /> -->
		<!-- <property name="testOnReturn" value="false" /> -->

	</bean>
```

#### 3. 在web.xml中配置WebStatFilter过滤器及内置的监控页面
```
<!-- druid WebStatFilter -->
	<filter>
		<filter-name>DruidWebStatFilter</filter-name>
		<filter-class>com.alibaba.druid.support.http.WebStatFilter</filter-class>
		<init-param>
			<param-name>exclusions</param-name>
			<param-value>*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*</param-value>
		</init-param>
		<init-param>
			<param-name>profileEnable</param-name>
			<param-value>true</param-value>
		</init-param>
	</filter>
	<filter-mapping>
		<filter-name>DruidWebStatFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
<!-- /druid WebStatFilter -->
<!-- 配置内置监控页面 -->
	<servlet>
		<servlet-name>DruidStatView</servlet-name>
		<servlet-class>com.alibaba.druid.support.http.StatViewServlet</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>DruidStatView</servlet-name>
		<url-pattern>/druid/*</url-pattern>
	</servlet-mapping>
<!-- /配置内置监控页面 -->	
```

>最后访问 http://localhost:8080/项目名/druid/index.html 即可打开监控页面
