package cf.dinhthanhphu.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import cf.dinhthanhphu.dao.GenericDAO;
import cf.dinhthanhphu.mapper.RowMappper;

public class AbstractDAO<T> implements GenericDAO<T> {
    
    
	public Connection getConnection() {
		try {
		    Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/jspservletjdbc";
            String user = "root";
            String pass = "1254";
			return DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public <T> List<T> query(String sql, RowMappper<T> rowMapper, Object... Parameters) {
		List<T> results = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			// set parammeter ()
			setParameter(statement, Parameters);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				results.add(rowMapper.mapRow(resultSet));
			}
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}
	}

	private void setParameter(PreparedStatement statement, Object... parameters) {
		try {
			for (int i = 0; i < parameters.length; i++) {
				Object parameter = parameters[i];
				int index = i + 1;
				if (parameter instanceof Long) {
					statement.setLong(index, (Long) parameter);
				} else if (parameter instanceof String) {
					statement.setString(index, (String) parameter);
				} else if (parameter instanceof Integer) {
					statement.setInt(index, (Integer) parameter);
				} else if (parameter instanceof Date) {
					statement.setDate(index, (Date) parameter);
				} 
//				else if (parameter == null) {
//					statement.setNull(index, Types.NULL);
//				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Update(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();

				}
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}

			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public Long Insert(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		try {
			Long id = null;
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParameter(statement, parameters);
			statement.executeUpdate();
			resultset = statement.getGeneratedKeys();
			if (resultset.next()) {
				id = resultset.getLong(1);
			}
			connection.commit();
			return id;
		} catch (Exception e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultset != null) {
					resultset.close();
				}

			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

		return null;
	}

	@Override
	public int count(String sql, Object... parameters) {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			int count = 0;
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			// set parammeter ()
			setParameter(statement, parameters);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				count = resultSet.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return 0;
			}
		}
	}

//	@Override
//	public void Delete(String sql, Object... parameters) {
//		Connection connect = null;
//		PreparedStatement statement = null;
//		try {
//			connect = getConnection();
//			connect.setAutoCommit(false);
//			statement = connect.prepareStatement(sql);
//			setParameter(statement, parameters);
//			statement.executeUpdate();
//			connect.commit();
//		} catch (SQLException e) {
//			if (connect != null) {
//				try {
//					connect.rollback();
//				} catch (SQLException e1) {
//					e1.printStackTrace();
//				}
//
//			}
//		}finally {
//			try {
//				if(connect != null)
//					connect.close();
//				if(statement != null)
//					statement.close();
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//
//	}

}
