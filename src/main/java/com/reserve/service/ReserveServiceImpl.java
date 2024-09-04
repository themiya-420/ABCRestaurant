package com.reserve.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.feedback.model.feedback;
import com.reserve.model.Reserve;
import com.user.util.CommonConstants;
import com.user.util.DBConnection;
import com.user.util.QueryUtil;

public class ReserveServiceImpl implements IReserveService {
	
	
	private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;
    
    
    static {

        try {
			createReserveTable();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
    public static void createReserveTable() throws SQLException, IOException, ParserConfigurationException, ClassNotFoundException, SAXException {
        try {
            connection = DBConnection.getConnection();
            statement = connection.createStatement();
            statement.execute(QueryUtil.QueryById(CommonConstants.Create_Reserve_Table));
            System.out.println("Table created successfully.");
        } catch (SQLException | IOException | ParserConfigurationException | ClassNotFoundException | SAXException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();  // This will print the stack trace for more detailed error information.
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println("SQL error: " + e.getMessage());
            }
        }
    }


	@Override
	public void addReserve(Reserve reserve) {
		// TODO Auto-generated method stub
		
		 try {

	            connection = DBConnection.getConnection();
	            preparedStatement = connection.prepareStatement(QueryUtil.QueryById(CommonConstants.add_reserve));

	            connection.setAutoCommit(false);

	            preparedStatement.setString(CommonConstants.Column_Index_one, reserve.getFname());
	            preparedStatement.setString(CommonConstants.Column_Index_two, reserve.getLname());
	            preparedStatement.setString(CommonConstants.Column_Index_three, reserve.getGuest());
	            preparedStatement.setString(CommonConstants.Column_Index_four, reserve.getPhone());
	            preparedStatement.setString(CommonConstants.Column_Index_five, reserve.getType());
	            preparedStatement.setString(CommonConstants.Column_Index_six, reserve.getDate());
	            preparedStatement.setString(CommonConstants.Column_Index_seven, reserve.getTime());


	            preparedStatement.executeLargeUpdate();
	            connection.commit();

	        } catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {

	            System.out.println("Connection error" + e.getMessage());
	        } finally {
	            try {
	                if (connection != null) {

	                    connection.close();
	                }
	                if (preparedStatement != null) {
	                	preparedStatement.close();
	                }
	            } catch (SQLException e){
	                System.out.println("SQL error" + e.getMessage());
	            }
	        }
		
	}

	@Override
	public ArrayList<Reserve> getReserves() {
		// TODO Auto-generated method stub
		ArrayList<Reserve> reserveList = new ArrayList<Reserve>();
		
		try {
			
			  connection = DBConnection.getConnection();
	          preparedStatement = connection.prepareStatement(QueryUtil.QueryById(CommonConstants.get_reserves));

	          ResultSet rs = preparedStatement.executeQuery();
	          
	          while(rs.next() ) {
	        	  
	        	  Reserve reserve = new Reserve();
	        	  
	        	  reserve.setId(rs.getString(CommonConstants.Column_Index_one));
	        	  reserve.setFname(rs.getString(CommonConstants.Column_Index_two));
	        	  reserve.setLname(rs.getString(CommonConstants.Column_Index_three));
	        	  reserve.setGuest(rs.getString(CommonConstants.Column_Index_four));
	        	  reserve.setPhone(rs.getString(CommonConstants.Column_Index_five));
	        	  reserve.setType(rs.getString(CommonConstants.Column_Index_six));
	        	  reserve.setDate(rs.getString(CommonConstants.Column_Index_seven));
	        	  reserve.setTime(rs.getString(CommonConstants.Column_Index_eight));
	        	  
	        	  reserveList.add(reserve);
	        	 
	          }
			
		}catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {

            System.out.println("Connection error" + e.getMessage());
        } finally {
            try {
                if (connection != null) {

                    connection.close();
                }
                if (preparedStatement != null) {
                	preparedStatement.close();
                }
            } catch (SQLException e){
                System.out.println("SQL error" + e.getMessage());
            }
        }
		
		return reserveList;
	}

	@Override
	public void deleteReserve(String id) {
		// TODO Auto-generated method stub
		
		if (id != null && !id.isEmpty()) {
			
			try {
				
				connection = DBConnection.getConnection();
				preparedStatement = connection.prepareStatement(QueryUtil.QueryById(CommonConstants.delete_reserve));
				preparedStatement.setString(CommonConstants.Column_Index_one, id);
				
				preparedStatement.execute();
				System.out.println(preparedStatement.toString());
				
	        } catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
				
			} finally {
	            try {
	                if (connection != null) {

	                    connection.close();
	                }
	                if (preparedStatement != null) {
	                	preparedStatement.close();
	                }
	            } catch (SQLException e){
	                System.out.println("SQL error" + e.getMessage());
	            }
	        }
		}
		
	}

}
