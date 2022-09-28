package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(//지정하지 않으면 설정 정보 클래스의 패키지가 시작 위치가 된다.
        //basePackages = "hello.core.member", //원하는 패키지부터 찾도록 지정할 수 있다.
        //basePackageClasses = AutoAppConfig.class, //지정한 클래스의 패키지를 탐색 시작 위로 지정한다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
) //기존 예제 코드를 살리기 위해 이렇게 필터링 한것이다.
public class AutoAppConfig {










}
