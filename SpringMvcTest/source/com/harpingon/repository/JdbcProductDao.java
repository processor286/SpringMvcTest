package com.harpingon.repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.harpingon.domain.Product;

public class JdbcProductDao extends JdbcDaoSupport implements ProductDao {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	public List<Product> getProductList() {
		logger.info("Getting products!");
		List<Product> products = getJdbcTemplate().query(
				"select id, description, price from products",
				new ProductMapper());
		return products;
	}

	public void saveProduct(Product prod) {
		logger.info("Saving product [desc] : " + prod.getDescription());
		logger.info("Saving product [price]: " + prod.getPrice());		
		logger.info("Saving product [id]   : " + prod.getId());
		int count = getJdbcTemplate()
				.update("update products set description = ? , price = ? where id = ?",
						new Object [] {prod.getDescription(), prod.getPrice(), prod.getId()});

		logger.info("Rows affected: " + count);
	}

	private static class ProductMapper implements
			ParameterizedRowMapper<Product> {

		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product prod = new Product();
			prod.setId(rs.getInt("id"));
			prod.setDescription(rs.getString("description"));
			prod.setPrice(rs.getInt("price"));
			return prod;
		}

	}

}
