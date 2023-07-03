# 统一认证用例实例

## 说明

敦煌研究院统一认证代码用例


## 依赖
```bash
cas-client-core-3.6.2.jar 
commons-logging-1.1.1.jar
```

## XML配置详解

```bash
<!-- CAS 单点登录(SSO) 过滤器配置 (start) -->  
      
    <!-- 该过滤器用于实现单点登出功能。-->  
    <filter>  
        <filter-name>CAS Single Sign Out Filter</filter-name>  
        <filter-class>org.jasig.cas.client.session.SingleSignOutFilter</filter-class>  
    </filter>  
    <filter-mapping>  
        <filter-name>CAS Single Sign Out Filter</filter-name>  
        <url-pattern>/*</url-pattern>  
    </filter-mapping>  
    <!-- CAS: 用于单点退出 -->  
    <listener>  
        <listener-class>org.jasig.cas.client.session.SingleSignOutHttpSessionListener</listener-class>  
    </listener>  
      
    <!-- 该过滤器负责用户的认证工作，必须启用它 -->  
    <filter>  
        <filter-name>CASFilter</filter-name>  
        <filter-class>org.jasig.cas.client.authentication.AuthenticationFilter</filter-class>  
        <init-param>  
            <param-name>casServerLoginUrl</param-name>  
            <!-- 下面的URL是Cas服务器的登录地址 -->  
            <param-value>http://CAS服务端所在服务器IP:8080/cas/login</param-value>  
        </init-param>  
        <init-param>  
            <param-name>serverName</param-name>  
            <!-- 下面的URL是具体某一个应用的访问地址 -->  
            <param-value>http://具体web应用程序所在服务器IP:8080</param-value>  
        </init-param>  
    </filter>  
    <filter-mapping>  
        <filter-name>CASFilter</filter-name>  
        <url-pattern>/*</url-pattern>  
    </filter-mapping>  
       
    <!-- 该过滤器负责对Ticket的校验工作，必须启用它 -->  
    <filter>  
        <filter-name>CAS Validation Filter</filter-name>  
        <filter-class>org.jasig.cas.client.validation.Cas20ProxyReceivingTicketValidationFilter</filter-class>  
        <init-param>  
            <param-name>casServerUrlPrefix</param-name>  
            <!-- 下面的URL是Cas服务器的认证地址 -->  
            <param-value>http://CAS服务端所在服务器IP:8080/cas</param-value>  
        </init-param>  
        <init-param>  
            <param-name>serverName</param-name>  
            <!-- 下面的URL是具体某一个应用的访问地址 -->  
            <param-value>http://具体web应用程序所在服务器IP:8080</param-value>  
        </init-param>  
        <init-param>  
          <param-name>renew</param-name>  
          <param-value>false</param-value>  
        </init-param>  
        <init-param>  
          <param-name>gateway</param-name>  
          <param-value>false</param-value>  
        </init-param>  
    </filter>  
    <filter-mapping>  
        <filter-name>CAS Validation Filter</filter-name>  
        <url-pattern>/*</url-pattern>  
    </filter-mapping>  
       
    <!--  
    该过滤器负责实现HttpServletRequest请求的包裹，  
    比如允许开发者通过HttpServletRequest的getRemoteUser()方法获得SSO登录用户的登录名，可选配置。  
    -->  
    <filter>  
        <filter-name>CAS HttpServletRequest Wrapper Filter</filter-name>  
        <filter-class>org.jasig.cas.client.util.HttpServletRequestWrapperFilter</filter-class>  
    </filter>  
    <filter-mapping>  
        <filter-name>CAS HttpServletRequest Wrapper Filter</filter-name>  
        <url-pattern>/*</url-pattern>  
    </filter-mapping>  
       
    <!--  
    该过滤器使得开发者可以通过org.jasig.cas.client.util.AssertionHolder来获取用户的登录名。  
    比如AssertionHolder.getAssertion().getPrincipal().getName()。  
    -->  
    <filter>  
        <filter-name>CAS Assertion Thread Local Filter</filter-name>  
        <filter-class>org.jasig.cas.client.util.AssertionThreadLocalFilter</filter-class>  
    </filter>  
    <filter-mapping>  
        <filter-name>CAS Assertion Thread Local Filter</filter-name>  
        <url-pattern>/*</url-pattern>  
    </filter-mapping>  
 
    <!-- CAS 单点登录(SSO) 过滤器配置 (end) --> 
```

## License

Power by:DHA  
Version:1.1