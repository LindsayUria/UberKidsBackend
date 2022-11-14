package bo.edu.ucb.sis213.uberk;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
//@MapperScan("bo.edu.ucb.sis213")
public class UberkApplication {

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws  Exception{
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		return factoryBean.getObject();
	}

	public static void main(String[] args) {
		SpringApplication.run(UberkApplication.class, args);
	}

}
