package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class BillRepository extends Repository {
	public List<Bill> getBills(){
		try {
			open();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Bill");
			return fetchAll(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			close();
		}
	}
	private List<Bill> fetchAll(ResultSet rs) throws SQLException{
		final List<Bill> list = new LinkedList<Bill>();
		while(rs.next()) {
			list.add(fetch(rs));
		}
		return list;
	}
	private Bill fetch(ResultSet rs) throws SQLException {
		return new Bill(rs.getLong("BillId"), rs.getString("FullName"), rs.getString("Tel"), rs.getDate("AddedDate"), rs.getInt("Total"));
	}
	
	public Bill getBill(long id) {
		try {
			open();
			pstmt = connection.prepareStatement("SELECT Bill.BillId, FullName, Tel, AddedDate, SUM(Price * Quantity) AS Total \n" + 
					"	FROM Bill INNER JOIN BillDetail ON Bill.BillId = BillDetail.BillId \n" + 
					"	WHERE Bill.BillId = ?");
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			Bill obj = null;
			if(rs.next()) {
			 obj = new Bill(rs.getLong("BillId"), rs.getString("FullName"), rs.getString("Tel"),rs.getDate("AddedDate"), rs.getInt("Total"));
			}
			obj.setDetails(getBillDetails(id));
			return obj;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			close();
		}
	}
	public List<BillDetail> getBillDetails(long id) throws SQLException{
		List<BillDetail> list = new LinkedList<>();
		try {
			open();
			pstmt = connection.prepareStatement("SELECT * FROM BillDetail INNER JOIN Item ON BillDetail.ItemId = Item.ItemId WHERE BillId = ?");
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BillDetail obj = new BillDetail(rs.getLong("BillId"), rs.getInt("ItemId"), rs.getInt("Price"), rs.getShort("Quantity"),rs.getString("ItemName"),rs.getString("ImageUrl"));
				list.add(obj);
			}
			return list;
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	public int add(Bill obj) {
		try {
			open();
			pstmt = connection.prepareStatement("INSERT INTO Bill (BillId, FullName, Tel) VALUES(?, ?, ?)");
			pstmt.setLong(1, obj.getId());
			pstmt.setString(2,obj.getFullName());
			pstmt.setString(3, obj.getTel());
			int ret;
			ret = pstmt.executeUpdate();
			return ret;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}finally {
			close();
		}
	}
	public int[] addBillList(List<BillDetail> list){
		try {
			String sql = "INSERT INTO BillDetail(BillId, ItemId, Price, Quantity) VALUES(?, ?, ?, ?)";
			open();
			pstmt = connection.prepareStatement(sql);
			for(BillDetail obj : list) {
				pstmt.setLong(1, obj.getBillId());
				pstmt.setInt(2, obj.getItemId());
				pstmt.setInt(3, obj.getPrice());
				pstmt.setShort(4, obj.getQuantity());
				pstmt.addBatch();
			}
			int ret[] = pstmt.executeBatch();
			return ret;
		}catch (SQLException e) {
			e.printStackTrace();
		return null;
		}finally {
			close();
		}
	}
}
