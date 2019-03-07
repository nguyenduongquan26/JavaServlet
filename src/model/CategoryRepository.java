package model;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CategoryRepository extends Repository {
	public List<Category> getCategories(){
		try {
			open();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Category");
			List<Category> list = new LinkedList<Category>();
			while(rs.next()) {
				Category obj = new Category(rs.getInt("CategoryId"), rs.getString("CategoryName"));
				list.add(obj);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			close();
		}
	}
}
