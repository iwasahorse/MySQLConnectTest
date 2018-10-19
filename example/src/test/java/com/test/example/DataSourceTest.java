package com.test.example;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*@RunWith, @ContextConfiguration Annotation은 현재 테스트 코드를 실행 할 때 Spring이 로딩되도록 하는 부분이다
	@ContextConfiguration 의 location 속성 경로에 xml 파일을 이용해서 Spring이 로딩 된다.
	인스턴스 변수의 @Inject 주석으로 처리된 DataSource는 스프링이 생성해서 주입해 주므로
	개발자가 객체 생성 혹은 다른 작업을 하지 않아도 된다.
	스프링의 spring-test 모듈은 위의 코드와 같이 간단한 애노테이션의 설정으로 실제 스프링의 동작을 확인 할 수 있는 좋은 방법이다.
	특히 WAS의 실행이 매번 상당히 많은 시간이 드는 환경이면 필수적이라고 할 수 있습니다.
*/ 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/*.xml" })
public class DataSourceTest {

	@Inject
	private DataSource ds;

	@Test
	public void testConnection() throws Exception {
		try (Connection con = ds.getConnection()) {
			System.out.println(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}