package bo.edu.ucb.sis213.uberk;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan("bo.edu.ucb.sis213.uberk.dao")
public class UberkApplication {

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws  Exception{
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		SqlSessionFactory sqlSessionFactory = factoryBean.getObject();
		sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
		return sqlSessionFactory;
	}

	public static void main(String[] args) {
		SpringApplication.run(UberkApplication.class, args);
	}

}
