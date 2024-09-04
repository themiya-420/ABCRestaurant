package com.feedback.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.admin.model.Admin;
import com.feedback.model.feedback;
import com.user.util.CommonConstants;
import com.user.util.DBConnection;
import com.user.util.QueryUtil;

public class FeedbackServiceImpl implements IFeedbackService {
	
	
	private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;
    
    
    static {

        try {
			createFeedbackTable();
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
	
	
	 public static void createFeedbackTable() throws SQLException, IOException, ParserConfigurationException, ClassNotFoundException, SAXException {
	        try {
	            connection = DBConnection.getConnection();
	            statement = connection.createStatement();
	            statement.execute(QueryUtil.QueryById(CommonConstants.Create_Feedback_Table));
	        } catch (SQLException | IOException |ParserConfigurationException | ClassNotFoundException | SAXException e) {
	            System.out.println(e.getMessage());
	        } finally {
	            try {
	                if (connection != null) {

	                    connection.close();
	                }
	                if (statement != null) {
	                    statement.close();
	                }
	            } catch (SQLException e){
	                System.out.println("SQL error" + e.getMessage());
	            }
	        }
	    }

	@Override
	public void addFeedback(feedback feedback) {
		// TODO Auto-generated method stub
		

        try {

            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(QueryUtil.QueryById(CommonConstants.add_feedback));

            connection.setAutoCommit(false);

            preparedStatement.setString(CommonConstants.Column_Index_one, feedback.getName());
            preparedStatement.setString(CommonConstants.Column_Index_two, feedback.getEmail());
            preparedStatement.setString(CommonConstants.Column_Index_three, feedback.getMessage());


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
	public ArrayList<feedback> getFeedbacks() {
		// TODO Auto-generated method stub
		ArrayList<feedback> feedbackList = new ArrayList<feedback>();
		
		try {
			
			  connection = DBConnection.getConnection();
	          preparedStatement = connection.prepareStatement(QueryUtil.QueryById(CommonConstants.get_feedbacks));

	          ResultSet rs = preparedStatement.executeQuery();
	          
	          while(rs.next() ) {
	        	  
	        	  feedback feedback = new feedback();
	        	  
	        	  feedback.setId(rs.getString(CommonConstants.Column_Index_one));
	        	  feedback.setName(rs.getString(CommonConstants.Column_Index_two));
	        	  feedback.setEmail(rs.getString(CommonConstants.Column_Index_three));
	        	  feedback.setMessage(rs.getString(CommonConstants.Column_Index_four));
	        	  
	        	  feedbackList.add(feedback);
	        	 
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
		
		return feedbackList;
	}

	@Override
	public void deleteFeedback(String id) {
		// TODO Auto-generated method stub
		
		if (id != null && !id.isEmpty()) {
			
			try {
				
				connection = DBConnection.getConnection();
				preparedStatement = connection.prepareStatement(QueryUtil.QueryById(CommonConstants.delete_feedback));
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
