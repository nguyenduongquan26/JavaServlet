package model;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ItemRepository extends Repository {
	public List<Item> getItems(){
		try {
			open();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Item");
			List<Item> list = new LinkedList<Item>();
			while(rs.next()) {
				Item obj = new Item(rs.getInt("ItemId"), rs.getInt("CategoryId"), rs.getString("ItemName"), rs.getInt("Price"), rs.getString("ImageUrl"));
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
