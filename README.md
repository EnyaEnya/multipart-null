### Sample for bug https://github.com/spring-projects/spring-framework/issues/33791

Do `mvn clean test` to reproduce. The issue in `org.springframework.web.method.support.HandlerMethodArgumentResolverComposite.getArgumentResolver` that returns `org.springframework.data.web.ProxyingHandlerMethodArgumentResolver`.
If remove `spring-boot-starter-data-jpa` from `pom.xml`, test will pass and argument resolver is `org.springframework.web.method.annotation.RequestParamMethodArgumentResolver`.
