package com.leanhtuan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.leanhtuan.dao.UserDao;
import com.leanhtuan.jdbc.JDBCConnection;
import com.leanhtuan.model.User;

public class UserDaoImpl extends JDBCConnection implements UserDao {

	@Override
	public void insert(User user) {
		int roleId = 0;
		String sql = "INSERT INTO [User](email, username, password,avatar,role_id, point, ref_code) VALUES (?,?,?,?,?,?,?)";
		Connection con = super.getJDBCConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getAvatar());
			ps.setInt(6, 0);
			ps.setNull(7, 0);
			try {
				if (user.getRoleId() == 1) {
					roleId = 1;
				} else {
					roleId = 2;
				}

			} catch (Exception e) {
				roleId = 2;
			}
			ps.setInt(5, roleId);
			ps.executeUpdate();
			String sql3 = "SELECT TOP(1) * FROM [User] ORDER BY id DESC";
			PreparedStatement ps3 = con.prepareStatement(sql3);
			ResultSet rs = ps3.executeQuery();
			rs.next();
			String sql2 = "INSERT INTO [Referral](user_id, ref_first, ref_second, ref_third, discount_first, discount_second, discount_third) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement ps2 = con.prepareStatement(sql2);
			PreparedStatement ps4 = con.prepareStatement("UPDATE [USER] SET my_ref_code = ?, ref_code = ? WHERE id =?");
			if (user.getReferalCode().isEmpty()) {
				ps2.setInt(1, rs.getInt("id"));
				ps2.setNull(2, 0);
				ps2.setNull(3, 0);
				ps2.setNull(4, 0);
				ps2.setFloat(5, 0.03f);
				ps2.setFloat(6, 0.02f);
				ps2.setFloat(7, 0.01f);
				ps2.executeUpdate();

				ps4.setString(1, "" + rs.getInt("id"));
				ps4.setNull(2, 0);
				ps4.setInt(3, rs.getInt("id"));
			} else {
				ps2.setInt(1, rs.getInt("id"));
				ps2.setString(2, user.getReferalCode().split("-")[0]);
				ps2.setString(3, user.getReferalCode().split("-")[1]);
				ps2.setString(4, user.getReferalCode().split("-")[2]);
				ps2.setFloat(5, 0.03f);
				ps2.setFloat(6, 0.02f);
				ps2.setFloat(7, 0.01f);
				ps2.executeUpdate();
				String my_ref_code = rs.getInt("id") + "-" + user.getReferalCode().split("-")[0] + "-"
						+ user.getReferalCode().split("-")[1];
				ps4.setString(1, my_ref_code);
				ps4.setString(2, user.getReferalCode());
				ps4.setInt(3, rs.getInt("id"));

			}
			ps4.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(User user) {
		String sql = "UPDATE [User] SET email = ? , username = ?, password = ?, avatar = ?, role_id = ?, my_ref_code = ?, ref_code = ?  WHERE id = ?";
		Connection con = super.getJDBCConnection();
		System.out.println(user.toString());
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			PreparedStatement ps2 = con.prepareStatement(
					"UPDATE [Referral] SET ref_first = ?, ref_second = ?, ref_third = ? WHERE user_id = ?");
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getAvatar());
			ps.setInt(5, user.getRoleId());
			ps.setInt(8, user.getId());
			if (!user.getReferalCode().isEmpty()) {
				ps.setString(6, user.getId() + "-" + user.getReferalCode().split("-")[0] + "-"
						+ user.getReferalCode().split("-")[1]);
				ps.setString(7, user.getReferalCode());
				ps2.setString(1, user.getReferalCode().split("-")[0]);
				ps2.setString(2, user.getReferalCode().split("-")[1]);
				ps2.setString(3, user.getReferalCode().split("-")[2]);
				ps2.setInt(4, user.getId());
			} else {
				ps.setString(6, user.getMyReferalCode());
				ps.setNull(7, 0);
			}

			ps.executeUpdate();
			ps2.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM [User] WHERE id = ?";
		Connection con = super.getJDBCConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public User get(String username) {
		String sql = "SELECT * FROM [User] WHERE username = ? ";
		Connection con = super.getJDBCConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User();

				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setAvatar(rs.getString("avatar"));
				user.setRoleId(Integer.parseInt(rs.getString("role_id")));
				user.setPoint(Integer.parseInt(rs.getString("point")));
				user.setReferalCode(rs.getString("ref_code"));
				user.setMyReferalCode(rs.getString("my_ref_code"));
				return user;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User get(int id) {
		String sql = "SELECT * FROM [User] WHERE id = ? ";
		Connection con = super.getJDBCConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User();

				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setAvatar(rs.getString("avatar"));
				user.setRoleId(Integer.parseInt(rs.getString("role_id")));
				user.setReferalCode(rs.getString("ref_code"));
				user.setMyReferalCode(rs.getString("my_ref_code"));

				return user;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		List<User> userList = new ArrayList<User>();
		String sql = "SELECT * FROM [User]";
		Connection conn = super.getJDBCConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User();

				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setAvatar(rs.getString("avatar"));
				user.setRoleId(Integer.parseInt(rs.getString("role_id")));

				userList.add(user);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userList;
	}

	@Override
	public List<User> search(String keyword) {
		List<User> userList = new ArrayList<User>();
		String sql = "SELECT * FROM [User] WHERE name LIKE ? ";
		Connection conn = super.getJDBCConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + keyword + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User();

				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setAvatar(rs.getString("avatar"));
				user.setRoleId(Integer.parseInt(rs.getString("role_id")));

				userList.add(user);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userList;
	}

	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
		Connection conn = JDBCConnection.getJDBCConnection();
		try {
			String query = "select * from [user] where email = ?";

			PreparedStatement psmt = conn.prepareStatement(query);

			psmt.setString(1, email);

			ResultSet resultSet = psmt.executeQuery();

			if (resultSet.next()) {
				duplicate = true;
			}
			psmt.close();
			conn.close();
		} catch (SQLException ex) {
		}
		return duplicate;
	}

	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		Connection conn = JDBCConnection.getJDBCConnection();
		try {
			String query = "select * from [User] where username = ?";

			PreparedStatement psmt = conn.prepareStatement(query);

			psmt.setString(1, username);

			ResultSet resultSet = psmt.executeQuery();

			if (resultSet.next()) {
				duplicate = true;
			}
			psmt.close();
			conn.close();
		} catch (SQLException ex) {
		}
		return duplicate;
	}

}
