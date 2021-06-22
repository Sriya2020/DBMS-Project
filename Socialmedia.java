package DBMS;
import java.sql.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
/*@SuppressWarnings("serial")*/
/*public class Social_media*/
/*Scanner inpu=new Scanner(System.in);
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String uName="system";
		String pass="vasavi";
		String query="select * from users";

		Class.forName("oracle.jdbc.driver.OracleDrive");
		Connection con = DriverManager.getConnection(url,uName,pass);
		Statement st=con.createStatement();
		ResultSet rs;
		PreparedStatement std=con.prepareStatement(query);

*/
@SuppressWarnings("serial")
public class Socialmedia extends Frame implements ActionListener
{
	MenuBar mb;
	MenuItem m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12,m13,m14,m15,m16,m17,m18,m19,m20,m21,m22,m23,m24;
	Menu users,friends,comment_like,post_shares,groupmembers,MESSAGE_THREAD;
	TextField userIDText, User_emailText, passwordText;
	TextField user_emailText,friend_emailText;
	TextField commenterText , comment_liked_User_IDText;
	TextField post_IDText , shared_User_IDText;
	TextField gmidText, gidText;
	TextField threadIDText,userEmailText;
	TextArea errorText;
	Connection connection;
	Statement statement;
	
	//For updates
	Button updateButton;
	Button insertButton;
	List usersList,friendsList,comment_likeList,post_sharesList,groupmembersList,MESSAGE_THREADList;
	ResultSet rs;

	//For delete
	Button deleteRowButton;

	public InsertTables()
	{
		try 
		{
			Class.forName ("oracle.jdbc.driver.OracleDriver");
			//Class.forName ("com.mysql.jdbc.driver");
		} 
		catch (Exception e) 
		{
			System.err.println("Unable to find and load driver");
			System.exit(1);
		}
		connectToDB ();
	}

	public void connectToDB() 
    {
		try 
		{
		  connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","vasavi");
		  statement = connection.createStatement();

		} 
		catch (SQLException connectException) 
		{
		  System.out.println(connectException.getMessage());
		  System.out.println(connectException.getSQLState());
		  System.out.println(connectException.getErrorCode());
		  System.exit(1);
		}
    }	


	public void buildFrame()
	{
		//Basic Frame Properties
		setTitle("Social Media database");
		setSize(500, 600);
		setVisible(true);
		
		//menubar
		mb = new MenuBar();
		setMenuBar(mb);  
        	setSize(550,500);  
        	setLayout(null);  
        	setVisible(true);
		//Menu 
         	users=new Menu("users");  
        
         	m1=new MenuItem("Insert users");  
         	m2=new MenuItem("Update users");  
         	m3=new MenuItem("Delete users");  
         	m4=new MenuItem("View users");

		    users.add(m1);  
        	users.add(m2);  
        	users.add(m3); 
        	users.add(m4);
        
        	mb.add(users);
        	
        	//friends
            friends=new Menu("friends"); 
            m5=new MenuItem("Insert friends");
            m6=new MenuItem("Update friends");
            m7=new MenuItem("Delete friends");
            m8=new MenuItem("View friends");
            
            friends.add(m5);
            friends.add(m6);
            friends.add(m7);
            friends.add(m8);
            
            mb.add(friends);
            
            //comment_like
            comment_like=new Menu("comment_like");  
            m9=new MenuItem("Insert comment_like");
            m10=new MenuItem("Update comment_like");
            m11=new MenuItem("Delete comment_like");
            m12=new MenuItem("View comment_like");
           
            comment_like.add(m9);
            comment_like.add(m10);
            comment_like.add(m11);
            comment_like.add(m12);
            
            mb.add(comment_like);
            
            //post_shares
            post_shares=new Menu("post_shares");
            m13=new MenuItem("Insert post_shares");
            m14=new MenuItem("Update post_shares");
            m15=new MenuItem("Delete post_shares");
            m16=new MenuItem("View post_shares");
            
            post_shares.add(m13);
            post_shares.add(m14);
            post_shares.add(m15);
            post_shares.add(m16);
            
            mb.add(post_shares);
            
            //group members
            groupmembers=new Menu("groupmembers");
            m17=new MenuItem("Insert groupmembers");
            m18=new MenuItem("Update groupmembers");
            m19=new MenuItem("Delete groupmembers");
            m20=new MenuItem("View groupmembers");
            
            groupmembers.add(m17);
            groupmembers.add(m18);
            groupmembers.add(m19);
            groupmembers.add(m20);
            
            mb.add(groupmembers);
            
           // MESSAGE_THREAD
            MESSAGE_THREAD=new Menu("MESSAGE_THREAD");
            m21=new MenuItem("Insert MESSAGE_THREAD");
            m22=new MenuItem("Update MESSAGE_THREAD");
            m23=new MenuItem("Delete MESSAGE_THREAD");
            m24=new MenuItem("View MESSAGE_THREAD");
            
            MESSAGE_THREAD.add(m21);
            MESSAGE_THREAD.add(m22);
            MESSAGE_THREAD.add(m23);
            MESSAGE_THREAD.add(m24);
            
            mb.add(MESSAGE_THREAD);
            

		//Registering action Listners
        	m1.addActionListener(this);
        	m2.addActionListener(this);
        	m3.addActionListener(this);
        	m4.addActionListener(this);
        	m5.addActionListener(this);
            m6.addActionListener(this);
            m7.addActionListener(this);
            m8.addActionListener(this);
            m9.addActionListener(this);
            m10.addActionListener(this);
            m11.addActionListener(this);
            m12.addActionListener(this);
            m13.addActionListener(this);
            m14.addActionListener(this);
            m15.addActionListener(this);
            m16.addActionListener(this);
            m17.addActionListener(this);
            m18.addActionListener(this);
            m19.addActionListener(this);
            m20.addActionListener(this);
            m21.addActionListener(this);
            m22.addActionListener(this);
            m23.addActionListener(this);
            m24.addActionListener(this);
            repaint();
	}
	public void actionPerformed(ActionEvent ae)
	{
		String arg = ae.getActionCommand();
		if(arg.equals("Insert users"))
			this.buildGUIusers();
		if(arg.equals("Update users"))
			this.updateGUIusers();
		if(arg.equals("Delete users"))
			this.deleteGUIusers();
		if(arg.equals("View users"))
			this.viewusersGUI();
		if(arg.equals("Insert friends"))
			this.buildGUIfriends();
		if(arg.equals("Update friends"))
			this.updateGUIfriends();
		if(arg.equals("Delete friends"))
			this.deleteGUIfriends();
		if(arg.equals("View friends"))
			this.viewfriendsGUI();
		if(arg.equals("Insert comment_like"))
			this.buildGUIcomment_like();
		if(arg.equals("Update comment_like"))
			this.updatecomment_likeGUI();
		if(arg.equals("Delete comment_like"))
			this.deleteGUIcomment_like();
		if(arg.equals("View comment_like"))
			this.viewcomment_likeGUI();	
		if(arg.equals("Insert post_shares"))
			this.buildGUIpost_shares();
		if(arg.equals("Update post_shares"))
			this.updatepost_sharesGUI();
		if(arg.equals("Delete post_shares"))
			this.deleteGUIpost_shares();
		if(arg.equals("View post_shares"))
			this.viewpost_sharesGUI();
		if(arg.equals("Insert groupmembers"))
			this.buildGUIgroupmembers();
		if(arg.equals("Update groupmembers"))
			this.updategroupmembersGUI();
		if(arg.equals("Delete groupmembers"))
			this.deleteGUIgroupmembers();
		if(arg.equals("View groupmembers"))
			this.viewgroupmembersGUI();
		if(arg.equals("Insert MESSAGE_THREAD"))
			this.buildGUIMESSAGE_THREAD();
		if(arg.equals("Update MESSAGE_THREAD"))
			this.updateGUIMESSAGE_THREAD();
		if(arg.equals("Delete MESSAGE_THREAD"))
			this.deleteGUIMESSAGE_THREAD();
		if(arg.equals("View MESSAGE_THREAD"))
			this.viewMESSAGE_THREADGUI();
	}
	/*private void deleteGUIusers() {
		// TODO Auto-generated method stub
		
	}

	private void buildGUIusers() {
		// TODO Auto-generated method stub
		
	}

	private void updateGUIusers() {
		// TODO Auto-generated method stub
		
	}

	private void viewusersGUI() {
		// TODO Auto-generated method stub
		
	}

	private void viewgroupmembersGUI() {
		// TODO Auto-generated method stub
		
	}

	private void updateGUIgroupmembers() {
		// TODO Auto-generated method stub
		
	}

	private void viewpost_sharesGUI() {
		// TODO Auto-generated method stub
		
	}

	private void viewcomment_likeGUI() {
		// TODO Auto-generated method stub
		
	}

*/	
		
	

	public void buildGUIusers() 
	{	
		removeAll();
		//Handle Insert Account Button
		insertButton = new Button("Insert users");
		insertButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{		  
				  String query= "INSERT INTO users VALUES('" + userIDText.getText() + "', '" + User_emailText.getText() + "','" + passwordText.getText()  +"')";
				  int i = statement.executeUpdate(query);
				  errorText.append("\nInserted " + i + " rows successfully");
				} 
				catch (SQLException insertException) 
				{
				  displaySQLErrors(insertException);
				}
			}
		});
		userIDText = new TextField(15);
		User_emailText = new TextField(15);
		passwordText = new TextField(15);


		
		errorText = new TextArea(20, 90);
		errorText.setEditable(false);

		Panel first = new Panel();
		first.setLayout(new GridLayout(9, 2));
		first.add(new Label("User ID:"));
		first.add(userIDText);
		first.add(new Label("User Email:"));
		first.add(User_emailText);
		first.add(new Label("Password:"));
		first.add(passwordText);
		first.setBounds(125,90,200,100);
		
		Panel second = new Panel(new GridLayout(4, 1));
		second.add(insertButton);
        		second.setBounds(125,220,150,100);         
		
		Panel third = new Panel();
		third.add(errorText);
		third.setBounds(125,320,300,200);
		
		//setLayout(null);

		add(first);
		add(second);
		add(third);
		
		setLayout(new FlowLayout());
		setVisible(true);
	    
	}
	
	public void buildGUIfriends() 
	{	 	
		removeAll();
		//Handle Insert Account Button
		insertButton = new Button("Insert friends");
		insertButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{		  
				  String query= "INSERT INTO friends VALUES('" + user_emailText.getText() + "', '" + friend_emailText.getText() + "')";
				  int i = statement.executeUpdate(query);
				  errorText.append("\nInserted " + i + " rows successfully");
				} 
				catch (SQLException insertException) 
				{
				  displaySQLErrors(insertException);
				}
			}
		});	
		user_emailText  = new TextField(15);
		friend_emailText  = new TextField(15);
		
		errorText = new TextArea(10, 40);
		errorText.setEditable(false);

		Panel first = new Panel();
		first.setLayout(new GridLayout(5, 2));
		first.add(new Label("user_email:"));
		first.add(user_emailText );
		first.add(new Label("friend_email"));
		first.add(friend_emailText );
		first.setBounds(125,90,200,100);
		
		Panel second = new Panel(new GridLayout(4, 1));
		second.add(insertButton);
        		second.setBounds(125,220,150,100);         
		
		Panel third = new Panel();
		third.add(errorText);
		third.setBounds(125,320,300,200);
		
		//setLayout(null);

		add(first);
		add(second);
		add(third);
		
		setLayout(new FlowLayout());
		setVisible(true);
	    
	
	}
	
	
	//commenterText , comment_liked_User_IDText;
	public void buildGUIcomment_like() 
	{	 	
		removeAll();
		//Handle Insert Account Button
		insertButton = new Button("Insert comment_like");
		insertButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{		  
				  String query= "INSERT INTO comment_like VALUES('" + commenterText.getText() + "', '" + comment_liked_User_IDText.getText() + "')";
				  int i = statement.executeUpdate(query);
				  errorText.append("\nInserted " + i + " rows successfully");
				} 
				catch (SQLException insertException) 
				{
				  displaySQLErrors(insertException);
				}
			}
		});	
		commenterText = new TextField(15);
		comment_liked_User_IDText  = new TextField(15);
		
		errorText = new TextArea(10, 40);
		errorText.setEditable(false);

		Panel first = new Panel();
		first.setLayout(new GridLayout(5, 2));
		first.add(new Label("commenter:"));
		first.add(commenterText );
		first.add(new Label("comment_liked_User_ID:"));
		first.add(comment_liked_User_IDText );
		first.setBounds(125,90,200,100);
		
		Panel second = new Panel(new GridLayout(4, 1));
		second.add(insertButton);
        		second.setBounds(125,220,150,100);         
		
		Panel third = new Panel();
		third.add(errorText);
		third.setBounds(125,320,300,200);
		
		//setLayout(null);

		add(first);
		add(second);
		add(third);
		
		setLayout(new FlowLayout());
		setVisible(true);
	    
	
	}
	//post_IDText , shared_User_IDText
	public void buildGUIpost_shares() 
	{	 	
		removeAll();
		//Handle Insert Account Button
		insertButton = new Button("Insert post_shares");
		insertButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{		  
				  String query= "INSERT INTO post_shares VALUES('" + post_IDText.getText() + "', '" + shared_User_IDText.getText() + "')";
				  int i = statement.executeUpdate(query);
				  errorText.append("\nInserted " + i + " rows successfully");
				} 
				catch (SQLException insertException) 
				{
				  displaySQLErrors(insertException);
				}
			}
		});	
		post_IDText = new TextField(15);
		shared_User_IDText  = new TextField(15);
		
		errorText = new TextArea(10, 40);
		errorText.setEditable(false);

		Panel first = new Panel();
		first.setLayout(new GridLayout(5, 2));
		first.add(new Label("post_ID:"));
		first.add(post_IDText );
		first.add(new Label("shared_User_ID:"));
		first.add(shared_User_IDText );
		first.setBounds(125,90,200,100);
		
		Panel second = new Panel(new GridLayout(4, 1));
		second.add(insertButton);
        		second.setBounds(125,220,150,100);         
		
		Panel third = new Panel();
		third.add(errorText);
		third.setBounds(125,320,300,200);
		
		//setLayout(null);

		add(first);
		add(second);
		add(third);
		
		setLayout(new FlowLayout());
		setVisible(true);
	    
	
	}
	//gmidtext, gidText
	public void buildGUIgroupmembers() 
	{	 	
		removeAll();
		//Handle Insert Account Button
		insertButton = new Button("Insert groupmembers");
		insertButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{		  
				  String query= "INSERT INTO groupmembers VALUES('" + gmidText.getText() + "', '" + gidText.getText() + "')";
				  int i = statement.executeUpdate(query);
				  errorText.append("\nInserted " + i + " rows successfully");
				} 
				catch (SQLException insertException) 
				{
				  displaySQLErrors(insertException);
				}
			}
		});	
		gmidText = new TextField(15);
		gidText  = new TextField(15);
		
		errorText = new TextArea(10, 40);
		errorText.setEditable(false);

		Panel first = new Panel();
		first.setLayout(new GridLayout(5, 2));
		first.add(new Label("gmid:"));
		first.add(gmidText );
		first.add(new Label("gid:"));
		first.add(gidText );
		first.setBounds(125,90,200,100);
		
		Panel second = new Panel(new GridLayout(4, 1));
		second.add(insertButton);
        		second.setBounds(125,220,150,100);         
		
		Panel third = new Panel();
		third.add(errorText);
		third.setBounds(125,320,300,200);
		
		//setLayout(null);

		add(first);
		add(second);
		add(third);
		
		setLayout(new FlowLayout());
		setVisible(true);
	    
	
	}
	
	//threadID,userEmailText
		public void buildGUIMESSAGE_THREAD() 
		{	 	
			removeAll();
			//Handle Insert Account Button
			insertButton = new Button("Insert MESSAGE_THREAD");
			insertButton.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					try 
					{		  
					  String query= "INSERT INTO MESSAGE_THREAD VALUES('" + threadIDText.getText() + "', '" + userEmailText.getText() + "')";
					  int i = statement.executeUpdate(query);
					  errorText.append("\nInserted " + i + " rows successfully");
					} 
					catch (SQLException insertException) 
					{
					  displaySQLErrors(insertException);
					}
				}
			});	
			threadIDText  = new TextField(15);
			userEmailText  = new TextField(15);
			
			errorText = new TextArea(10, 40);
			errorText.setEditable(false);

			Panel first = new Panel();
			first.setLayout(new GridLayout(5, 2));
			first.add(new Label("threadID:"));
			first.add(threadIDText );
			first.add(new Label("user_email"));
			first.add(userEmailText );
			first.setBounds(125,90,200,100);
			
			Panel second = new Panel(new GridLayout(4, 1));
			second.add(insertButton);
	        		second.setBounds(125,220,150,100);         
			
			Panel third = new Panel();
			third.add(errorText);
			third.setBounds(125,320,300,200);
			
			//setLayout(null);

			add(first);
			add(second);
			add(third);
			
			setLayout(new FlowLayout());
			setVisible(true);
		    
		
		}
		
	private void loadUsers() 
	{	   
		try 
		{
		  rs = statement.executeQuery("SELECT * FROM users");
		  while (rs.next()) 
		  {
			  usersList.add(rs.getString("userid"));
		  }
		} 
		catch (SQLException e) 
		{ 
		  displaySQLErrors(e);
		}
	}	
	public void updateGUIusers() 
	{	
		removeAll();
		usersList = new List(6);
		loadUsers();
		add(usersList);
		
		//When a list item is selected populate the text fields
		usersList.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e) 
			{
				try 
				{
					rs = statement.executeQuery("SELECT * FROM users");
					while (rs.next()) 
					{
						if (rs.getString("userID").equals(usersList.getSelectedItem()))
						break;
					}
					if (!rs.isAfterLast()) 
					{
						userIDText.setText(rs.getString("userID"));
						User_emailText.setText(rs.getString("User_email"));
						passwordText.setText(rs.getString("password"));
						
						
					}
				} 
				catch (SQLException selectException) 
				{
					displaySQLErrors(selectException);
				}
			}
	        });
		//Handle Update Users Button
		updateButton = new Button("Update Users");
		updateButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					Statement statement = connection.createStatement();
					int i = statement.executeUpdate("UPDATE users "
					+ "SET User_email=" + User_emailText.getText()+
					","+"password="+ passwordText.getText() +
					 " WHERE userID = '" + usersList.getSelectedItem() + "'");
					errorText.append("\nUpdated " + i + " rows successfully");
					usersList.removeAll();
					loadUsers();
				} 
				catch (SQLException insertException) 
				{
					displaySQLErrors(insertException);
				}
			}
		});
		

		userIDText = new TextField(15);
		userIDText.setEditable(false);

		User_emailText = new TextField(15);
		passwordText = new TextField(15);
		

		errorText = new TextArea(20, 90);
		errorText.setEditable(false);

		Panel first = new Panel();
		first.setLayout(new GridLayout(10, 2));
		first.add(new Label("User ID:"));
		first.add(userIDText);
		first.add(new Label("User Email:"));
		first.add(User_emailText);
		first.add(new Label("Password:"));
		first.add(passwordText);
		
	
		
		Panel second = new Panel(new GridLayout(4, 1));
		second.add(updateButton);
		
		Panel third = new Panel();
		third.add(errorText);
		
		add(first);
		
		add(second);
		add(third);
	    
		//setTitle("Update ....");
		//setSize(500, 600);
		setLayout(new FlowLayout());
		setVisible(true);
		
	}

	public void deleteGUIusers() 
	{	
		removeAll();
	    usersList = new List(10);
		loadUsers();
		add(usersList);
		
		//When a list item is selected populate the text fields
		usersList.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e) 
			{
				try 
				{
					rs = statement.executeQuery("SELECT * FROM users");
					while (rs.next()) 
					{
						if (rs.getString("userID").equals(usersList.getSelectedItem()))
						break;
					}
					if (!rs.isAfterLast()) 
					{
						userIDText.setText(rs.getString("userID"));
						User_emailText.setText(rs.getString("User_email"));
						passwordText.setText(rs.getString("password"));
						
					}
				} 
				catch (SQLException selectException) 
				{
					displaySQLErrors(selectException);
				}
			}
		});

		//Handle Delete menu Button
		deleteRowButton = new Button("Delete Row");
		deleteRowButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					Statement statement = connection.createStatement();
					int i = statement.executeUpdate("DELETE FROM users WHERE userID = '" + usersList.getSelectedItem()+"'");
					errorText.append("\nDeleted " + i + " rows successfully");
					userIDText.setText(null);
					User_emailText.setText(null);
					passwordText .setText(null);
					
					usersList.removeAll();
					loadUsers();
				} 
				catch (SQLException deleteException) 
				{
					displaySQLErrors(deleteException);
				}
			}
		});


		userIDText = new TextField(15);
		User_emailText = new TextField(15);
		passwordText  = new TextField(15);
		
		
		errorText = new TextArea(10, 40);
		errorText.setEditable(false);
		
		userIDText.setEditable(false);
		User_emailText.setEditable(false);
		passwordText .setEditable(false);

		Panel first = new Panel();
		first.setLayout(new GridLayout(10, 2));
		first.add(new Label("User ID:"));
		first.add(userIDText);
		first.add(new Label("User Email:"));
		first.add(User_emailText);
		first.add(new Label("Password:"));
		first.add(passwordText);
		
		
		Panel second = new Panel(new GridLayout(10, 2));
		second.add(deleteRowButton);
		
		Panel third = new Panel();
		third.add(errorText);
		
		add(first);
		add(second);
		add(third);
	    

		setLayout(new FlowLayout());
		setVisible(true);
		
	}

	public void viewusersGUI() 
	{	
		removeAll();
		usersList = new List(6);
		loadUsers();
		add(usersList);
		
		//When a list item is selected populate the text fields
		usersList.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e) 
			{
				try 
				{
					rs = statement.executeQuery("SELECT * FROM users");
					while (rs.next()) 
					{
						if (rs.getString("userID").equals(usersList.getSelectedItem()))
						break;
					}
					if (!rs.isAfterLast()) 
					{
						
						userIDText.setText(rs.getString("userID"));
						User_emailText.setText(rs.getString("User_email"));
						passwordText.setText(rs.getString("password"));
						
					}
				} 
				catch (SQLException selectException) 
				{
					displaySQLErrors(selectException);
				}
			}
		});	    
		//Handle Update Users Button
		/*updateButton = new Button("Update users");
		updateButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					Statement statement = connection.createStatement();
					int i = statement.executeUpdate("UPDATE users "
					+ "SET User_email=" + user_emailText.getText()+
					","+"phone="+ phoneText.getText() +
					","+"password="+ passwordText.getText() +
 					","+"fname="+ fnameText.getText() +
					","+"lname="+ lnameText.getText() +
					","+"city="+ cityText.getText() +
					","+"pincode="+ pincodeText.getText() +
					
					","+"gender="+ genderText.getText()
					+ " WHERE userID = '" + usersList.getSelectedItem() + "'");
					errorText.append("\nUpdated " + i + " rows successfully");
					usersList.removeAll();
					loadUsers();
				} 
				catch (SQLException insertException) 
				{
					displaySQLErrors(insertException);
				}
			}
		});*/
		
		userIDText = new TextField(15);
		userIDText.setEditable(false);
		User_emailText = new TextField(15);
		User_emailText.setEditable(false);
		passwordText = new TextField(15);
		passwordText.setEditable(false);
		
		
				
		

		errorText = new TextArea(20, 90);
		errorText.setEditable(false);

		Panel first = new Panel();
		first.setLayout(new GridLayout(10, 2));
		first.add(new Label("User ID:"));
		first.add(userIDText);
		first.add(new Label("User Email:"));
		first.add(User_emailText);
		first.add(new Label("Password:"));
		first.add(passwordText);
		
		
		
		
		
		Panel second = new Panel(new GridLayout(4, 1));
		//second.add(updateButton);
		
		Panel third = new Panel();
		//third.add(errorText);
		
		add(first);
		
		add(second);
		add(third);
	    
		//setTitle("Update ....");
		//setSize(500, 600);
		setLayout(new FlowLayout());
		setVisible(true);
		
	}
    //user_emailText,friend_emailText
	private void loadfriends() 
	{	   
		try 
		{
		  rs = statement.executeQuery("SELECT * FROM friends");
		  while (rs.next()) 
		  {
			  friendsList.add(rs.getString("user_email"));
		  }
		} 
		catch (SQLException e) 
		{ 
		  displaySQLErrors(e);
		}
	}
	public void updateGUIfriends() 
	{	
		removeAll();
		friendsList = new List(6);
		loadfriends();
		add(friendsList);
		
		//When a list item is selected populate the text fields
		friendsList.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e) 
			{
				try 
				{
					rs = statement.executeQuery("SELECT * FROM friends");
					while (rs.next()) 
					{
						if (rs.getString("user_email").equals(friendsList.getSelectedItem()))
						break;
					}
					if (!rs.isAfterLast()) 
					{
						user_emailText.setText(rs.getString("user_email"));
						friend_emailText.setText(rs.getString("friend_email"));
						
					}
				} 
				catch (SQLException selectException) 
				{
					displaySQLErrors(selectException);
				}
			}
		});	    
		//Handle Update Menu Button
		//+ "SET friend_email=" + friend_emailText.getText()  
		//+ " WHERE user_email = '" + friendsList.getSelectedItem() + "'");
		updateButton = new Button("Update friends");
		updateButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					Statement statement = connection.createStatement();
					int i = statement.executeUpdate("UPDATE friends "
					+ "SET friend_email=" + friend_emailText.getText()  
					+ " WHERE user_email ='" + friendsList.getSelectedItem() + "'");
					errorText.append("\nUpdated " + i + " rows successfully");
					friendsList.removeAll();
					loadfriends();
				} 
				catch (SQLException insertException) 
				{
					displaySQLErrors(insertException);
				}
			}
		});
		
		user_emailText = new TextField(15);
		user_emailText.setEditable(false);
		friend_emailText = new TextField(15);
		//friend_emailText.setEditable(false);

		errorText = new TextArea(10, 40);
		errorText.setEditable(false);

		Panel first = new Panel();
		first.setLayout(new GridLayout(3, 2));
		first.add(new Label("user_email:"));
		first.add(user_emailText);
		first.add(new Label("friend_email"));
		first.add(friend_emailText);
		
		Panel second = new Panel(new GridLayout(4, 1));
		second.add(updateButton);
		
		Panel third = new Panel();
		third.add(errorText);
		
		add(first);
		add(second);
		add(third);
	    
	
		//setSize(500, 600);
		setLayout(new FlowLayout());
		setVisible(true);
		
	}

	public void deleteGUIfriends()
	{
		removeAll();
	    friendsList = new List(10);
		loadfriends();
		add(friendsList);
		
		//When a list item is selected populate the text fields
		friendsList.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e) 
			{
				try 
				{
					rs = statement.executeQuery("SELECT * FROM friends");
					while (rs.next()) 
					{
						if (rs.getString("user_email").equals(friendsList.getSelectedItem()))
						break;
					}
					if (!rs.isAfterLast()) 
					{
						user_emailText.setText(rs.getString("user_email"));
						friend_emailText.setText(rs.getString("friend_email"));
					}
				} 
				catch (SQLException selectException) 
				{
					displaySQLErrors(selectException);
				}
			}
		});
	    
		//Handle Delete orders Button
		deleteRowButton = new Button("Delete");
		deleteRowButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					Statement statement = connection.createStatement();
					int i = statement.executeUpdate("DELETE FROM friends WHERE user_email = '" + friendsList.getSelectedItem()+"'");
					errorText.append("\nDeleted " + i + " rows successfully");
					user_emailText.setText(null);
					friend_emailText.setText(null);
					friendsList.removeAll();
					loadfriends();
				} 
				catch (SQLException deleteException) 
				{
					displaySQLErrors(deleteException);
				}
			}
		});
		
		user_emailText = new TextField(15);
		friend_emailText = new TextField(15);
		
		
		errorText = new TextArea(10, 40);
		errorText.setEditable(false);
		
		user_emailText.setEditable(false);
		friend_emailText.setEditable(false);
		

		Panel first = new Panel();
		first.setLayout(new GridLayout(3, 2));
		first.add(new Label("user_email:"));
		first.add(user_emailText);
		first.add(new Label("friend_email:"));
		first.add(friend_emailText);
		
		
		Panel second = new Panel(new GridLayout(4, 1));
		second.add(deleteRowButton);
		
		Panel third = new Panel();
		third.add(errorText);
		
		add(first);
		add(second);
		add(third);
	    

		setLayout(new FlowLayout());
		setVisible(true);
		
	}
	
	
	
	//comment_like,commenterText , comment_liked_User_IDText
	private void loadcomment_like() 
	{	   
		try 
		{
		  rs = statement.executeQuery("SELECT * FROM comment_like");
		  while (rs.next()) 
		  {
			  comment_likeList.add(rs.getString("comment_liked_User_ID"));
		  }
		} 
		catch (SQLException e) 
		{ 
		  displaySQLErrors(e);
		}
	}
	public void updatecomment_likeGUI() 
	{	
		removeAll();
		comment_likeList = new List(6);
		loadcomment_like();
		add(comment_likeList);
		
		//When a list item is selected populate the text fields
		comment_likeList.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e) 
			{
				try 
				{
					rs = statement.executeQuery("SELECT * FROM comment_like");
					while (rs.next()) 
					{
						if (rs.getString(" comment_liked_User_ID").equals(comment_likeList.getSelectedItem()))
						break;
					}
					if (!rs.isAfterLast()) 
					{
						commenterText.setText(rs.getString("commenter"));
						comment_liked_User_IDText.setText(rs.getString("comment_liked_User_ID"));
						
					}
				} 
				catch (SQLException selectException) 
				{
					displaySQLErrors(selectException);
				}
			}
		});	    
		//Handle Update Menu Button
		updateButton = new Button("Update comment_like");
		updateButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					Statement statement = connection.createStatement();
					int i = statement.executeUpdate("UPDATE comment_like "
					+ "SET commenter=" + commenterText.getText()  
					+ " WHERE comment_liked_User_ID= '" + comment_likeList.getSelectedItem() + "'");
					errorText.append("\nUpdated " + i + " rows successfully");
					comment_likeList.removeAll();
					loadcomment_like();
				} 
				catch (SQLException insertException) 
				{
					displaySQLErrors(insertException);
				}
			}
		});
		
		commenterText = new TextField(15);
		//commenterText.setEditable(false);
		comment_liked_User_IDText = new TextField(15);
	    comment_liked_User_IDText.setEditable(false);

		errorText = new TextArea(10, 40);
		errorText.setEditable(false);

		Panel first = new Panel();
		first.setLayout(new GridLayout(3, 2));
		first.add(new Label("commenter:"));
		first.add(commenterText);
		first.add(new Label("comment_liked_User_ID:"));
		first.add(comment_liked_User_IDText);
		
		Panel second = new Panel(new GridLayout(4, 1));
		second.add(updateButton);
		
		Panel third = new Panel();
		third.add(errorText);
		
		add(first);
		add(second);
		add(third);
	    
	
		//setSize(500, 600);
		setLayout(new FlowLayout());
		setVisible(true);
		
	}

	public void deleteGUIcomment_like()
	{
		removeAll();
		comment_likeList = new List(10);
		loadcomment_like();
		add(comment_likeList);
		
		//When a list item is selected populate the text fields
		comment_likeList.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e) 
			{
				try 
				{
					rs = statement.executeQuery("SELECT * FROM comment_like");
					while (rs.next()) 
					{
						if (rs.getString("comment_liked_User_ID").equals(comment_likeList.getSelectedItem()))
						break;
					}
					if (!rs.isAfterLast()) 
					{
						commenterText.setText(rs.getString("commenter"));
						comment_liked_User_IDText.setText(rs.getString("comment_liked_User_ID"));
					}
				} 
				catch (SQLException selectException) 
				{
					displaySQLErrors(selectException);
				}
			}
		});
	    
		//Handle Delete orders Button
		deleteRowButton = new Button("Delete");
		deleteRowButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					Statement statement = connection.createStatement();
					int i = statement.executeUpdate("DELETE FROM comment_like WHERE comment_liked_User_ID = '" + comment_likeList.getSelectedItem()+"'");
					errorText.append("\nDeleted " + i + " rows successfully");
					commenterText.setText(null);
					comment_liked_User_IDText.setText(null);
					comment_likeList.removeAll();
					loadcomment_like();
				} 
				catch (SQLException deleteException) 
				{
					displaySQLErrors(deleteException);
				}
			}
		});
		
		commenterText = new TextField(15);
		comment_liked_User_IDText = new TextField(15);
		
		
		errorText = new TextArea(10, 40);
		errorText.setEditable(false);
		
		commenterText.setEditable(false);
		comment_liked_User_IDText.setEditable(false);
		

		Panel first = new Panel();
		first.setLayout(new GridLayout(3, 2));
		first.add(new Label("commenter:"));
		first.add(commenterText);
		first.add(new Label("comment_liked_User_ID:"));
		first.add(comment_liked_User_IDText);
		
		
		Panel second = new Panel(new GridLayout(4, 1));
		second.add(deleteRowButton);
		
		Panel third = new Panel();
		third.add(errorText);
		
		add(first);
		add(second);
		add(third);
	    

		setLayout(new FlowLayout());
		setVisible(true);
		
	}
	//post_shares,groupmembers,post_IDText , shared_User_IDText;TextField gmidtext, gidText
	
	
	private void loadpost_shares() 
	{	   
		try 
		{
		  rs = statement.executeQuery("SELECT * FROM post_shares");
		  while (rs.next()) 
		  {
			  post_sharesList.add(rs.getString("post_ID"));
		  }
		} 
		catch (SQLException e) 
		{ 
		  displaySQLErrors(e);
		}
	}
	public void updatepost_sharesGUI() 
	{	
		removeAll();
		post_sharesList = new List(6);
		loadpost_shares();
		add(post_sharesList);
		
		//When a list item is selected populate the text fields
		post_sharesList.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e) 
			{
				try 
				{
					rs = statement.executeQuery("SELECT * FROM post_shares");
					while (rs.next()) 
					{
						if (rs.getString(" post_ID").equals(post_sharesList.getSelectedItem()))
						break;
					}
					if (!rs.isAfterLast()) 
					{
						post_IDText.setText(rs.getString("post_ID"));
						shared_User_IDText.setText(rs.getString("shared_User_ID"));
						
					}
				} 
				catch (SQLException selectException) 
				{
					displaySQLErrors(selectException);
				}
			}
		});	    
		//Handle Update Menu Button
		updateButton = new Button("Update post_shares");
		updateButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					Statement statement = connection.createStatement();
					int i = statement.executeUpdate("UPDATE post_shares "
					+ "SET shared_User_ID=" + shared_User_IDText.getText()  
					+ " WHERE post_ID= '" + post_sharesList.getSelectedItem() + "'");
					errorText.append("\nUpdated " + i + " rows successfully");
					post_sharesList.removeAll();
					loadpost_shares();
				} 
				catch (SQLException insertException) 
				{
					displaySQLErrors(insertException);
				}
			}
		});
		
		post_IDText = new TextField(15);
		post_IDText.setEditable(false);
		shared_User_IDText = new TextField(15);
		//shared_User_IDText.setEditable(false);

		errorText = new TextArea(10, 40);
		errorText.setEditable(false);

		Panel first = new Panel();
		first.setLayout(new GridLayout(3, 2));
		first.add(new Label("post_ID:"));
		first.add(post_IDText);
		first.add(new Label("shared_User_ID:"));
		first.add(shared_User_IDText);
		
		Panel second = new Panel(new GridLayout(4, 1));
		second.add(updateButton);
		
		Panel third = new Panel();
		third.add(errorText);
		
		add(first);
		add(second);
		add(third);
	    
	
		//setSize(500, 600);
		setLayout(new FlowLayout());
		setVisible(true);
		
	}

	public void deleteGUIpost_shares()
	{
		removeAll();
		post_sharesList = new List(10);
		loadpost_shares();
		add(post_sharesList);
		
		//When a list item is selected populate the text fields
		post_sharesList.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e) 
			{
				try 
				{
					rs = statement.executeQuery("SELECT * FROM post_shares");
					while (rs.next()) 
					{
						if (rs.getString("post_IDText").equals(post_sharesList.getSelectedItem()))
						break;
					}
					if (!rs.isAfterLast()) 
					{
						shared_User_IDText.setText(rs.getString("shared_User_ID"));
						post_IDText.setText(rs.getString("post_ID"));
					}
				} 
				catch (SQLException selectException) 
				{
					displaySQLErrors(selectException);
				}
			}
		});
	    
		//Handle Delete orders Button
		deleteRowButton = new Button("Delete");
		deleteRowButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					Statement statement = connection.createStatement();
					int i = statement.executeUpdate("DELETE FROM post_shares WHERE post_ID = '" + post_sharesList.getSelectedItem()+"'");
					errorText.append("\nDeleted " + i + " rows successfully");
					post_IDText.setText(null);
			        shared_User_IDText.setText(null);
					post_sharesList.removeAll();
					loadpost_shares();
				} 
				catch (SQLException deleteException) 
				{
					displaySQLErrors(deleteException);
				}
			}
		});
		
		post_IDText = new TextField(15);
		shared_User_IDText = new TextField(15);
		
		
		errorText = new TextArea(10, 40);
		errorText.setEditable(false);
		
		post_IDText.setEditable(false);
		shared_User_IDText.setEditable(false);
		

		Panel first = new Panel();
		first.setLayout(new GridLayout(3, 2));
		first.add(new Label("post_ID:"));
		first.add(post_IDText);
		first.add(new Label("shared_User_ID:"));
		first.add(shared_User_IDText);
		
		
		Panel second = new Panel(new GridLayout(4, 1));
		second.add(deleteRowButton);
		
		Panel third = new Panel();
		third.add(errorText);
		
		add(first);
		add(second);
		add(third);
	    

		setLayout(new FlowLayout());
		setVisible(true);
		
	}
	//groupmembers,gmidtext, gidText
	
	private void loadgroupmembers() 
	{	   
		try 
		{
		  rs = statement.executeQuery("SELECT * FROM groupmembers");
		  while (rs.next()) 
		  {
			  groupmembersList.add(rs.getString("gmid"));
		  }
		} 
		catch (SQLException e) 
		{ 
		  displaySQLErrors(e);
		}
	}
	public void updategroupmembersGUI() 
	{	
		removeAll();
		groupmembersList = new List(6);
		loadgroupmembers();
		add(groupmembersList);
		
		//When a list item is selected populate the text fields
		groupmembersList.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e) 
			{
				try 
				{
					rs = statement.executeQuery("SELECT * FROM groupmembers");
					while (rs.next()) 
					{
						if (rs.getString("gmid").equals(groupmembersList.getSelectedItem()))
						break;
					}
					if (!rs.isAfterLast()) 
					{
						gmidText.setText(rs.getString("gmid"));
						gidText.setText(rs.getString("gid"));
						
					}
				} 
				catch (SQLException selectException) 
				{
					displaySQLErrors(selectException);
				}
			}
		});	    
		//Handle Update Menu Button
		updateButton = new Button("Update groupmembers");
		updateButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					Statement statement = connection.createStatement();
					int i = statement.executeUpdate("UPDATE groupmembers "
					+ "SET gid=" + gidText.getText()  
					+ " WHERE gmid= '" + groupmembersList.getSelectedItem() + "'");
					errorText.append("\nUpdated " + i + " rows successfully");
					groupmembersList.removeAll();
					loadgroupmembers();
				} 
				catch (SQLException insertException) 
				{
					displaySQLErrors(insertException);
				}
			}
		});
		
		gmidText = new TextField(15);
		gmidText.setEditable(false);
		gidText = new TextField(15);
		//gidText.setEditable(false);

		errorText = new TextArea(10, 40);
		errorText.setEditable(false);

		Panel first = new Panel();
		first.setLayout(new GridLayout(3, 2));
		first.add(new Label("gmid:"));
		first.add(gmidText);
		first.add(new Label("gid:"));
		first.add(gidText);
		
		Panel second = new Panel(new GridLayout(4, 1));
		second.add(updateButton);
		
		Panel third = new Panel();
		third.add(errorText);
		
		add(first);
		add(second);
		add(third);
	    
	
		//setSize(500, 600);
		setLayout(new FlowLayout());
		setVisible(true);
		
	}

	public void deleteGUIgroupmembers()
	{
		removeAll();
		groupmembersList = new List(10);
		loadgroupmembers();
		add(groupmembersList);
		
		//When a list item is selected populate the text fields
		groupmembersList.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e) 
			{
				try 
				{
					rs = statement.executeQuery("SELECT * FROM groupmembers");
					while (rs.next()) 
					{
						if (rs.getString("gmidText").equals(groupmembersList.getSelectedItem()))
						break;
					}
					if (!rs.isAfterLast()) 
					{
						gmidText.setText(rs.getString("gmid"));
						gidText.setText(rs.getString("gid"));
					}
				} 
				catch (SQLException selectException) 
				{
					displaySQLErrors(selectException);
				}
			}
		});
	    
		//Handle Delete orders Button
		deleteRowButton = new Button("Delete");
		deleteRowButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					Statement statement = connection.createStatement();
					int i = statement.executeUpdate("DELETE FROM groupmembers WHERE gmid = '" + groupmembersList.getSelectedItem()+"'");
					errorText.append("\nDeleted " + i + " rows successfully");
					gmidText.setText(null);
			        gidText.setText(null);
			        groupmembersList.removeAll();
					loadgroupmembers();
				} 
				catch (SQLException deleteException) 
				{
					displaySQLErrors(deleteException);
				}
			}
		});
		
		gmidText = new TextField(15);
		gidText = new TextField(15);
		
		
		errorText = new TextArea(10, 40);
		errorText.setEditable(false);
		
		gmidText.setEditable(false);
		gidText.setEditable(false);
		

		Panel first = new Panel();
		first.setLayout(new GridLayout(3, 2));
		first.add(new Label("gmid:"));
		first.add(gmidText);
		first.add(new Label("gid:"));
		first.add(gidText);
		
		
		Panel second = new Panel(new GridLayout(4, 1));
		second.add(deleteRowButton);
		
		Panel third = new Panel();
		third.add(errorText);
		
		add(first);
		add(second);
		add(third);
	    

		setLayout(new FlowLayout());
		setVisible(true);
		
	}
	
	//threadID,userEmailText   MESSAGE_THREAD
	private void loadMESSAGE_THREAD() 
	{	   
		try 
		{
		  rs = statement.executeQuery("SELECT * FROM MESSAGE_THREAD");
		  while (rs.next()) 
		  {
			  MESSAGE_THREADList.add(rs.getString("threadID"));
		  }
		} 
		catch (SQLException e) 
		{ 
		  displaySQLErrors(e);
		}
	}
	public void updateGUIMESSAGE_THREAD() 
	{	
		removeAll();
		MESSAGE_THREADList = new List(6);
		loadMESSAGE_THREAD();
		add(MESSAGE_THREADList);
		
		//When a list item is selected populate the text fields
		MESSAGE_THREADList.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e) 
			{
				try 
				{
					rs = statement.executeQuery("SELECT * FROM MESSAGE_THREAD");
					while (rs.next()) 
					{
						if (rs.getString("threadID").equals(MESSAGE_THREADList.getSelectedItem()))
						break;
					}
					if (!rs.isAfterLast()) 
					{
						threadIDText.setText(rs.getString("threadID"));
						userEmailText.setText(rs.getString("userEmail"));
						
					}
				} 
				catch (SQLException selectException) 
				{
					displaySQLErrors(selectException);
				}
			}
		});	    
		//Handle Update Menu Button
		//+ "SET friend_email=" + friend_emailText.getText()  
		//+ " WHERE user_email = '" + friendsList.getSelectedItem() + "'");
		updateButton = new Button("Update MESSAGE_THREAD");
		updateButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					Statement statement = connection.createStatement();
					int i = statement.executeUpdate("UPDATE MESSAGE_THREAD "
					+ "SET userEmail=" + threadIDText.getText()  
					+ " WHERE threadID ='" + MESSAGE_THREADList.getSelectedItem() + "'");
					errorText.append("\nUpdated " + i + " rows successfully");
					MESSAGE_THREADList.removeAll();
					loadMESSAGE_THREAD();
				} 
				catch (SQLException insertException) 
				{
					displaySQLErrors(insertException);
				}
			}
		});
		
		threadIDText = new TextField(15);
		threadIDText.setEditable(false);
		userEmailText = new TextField(15);
		//friend_emailText.setEditable(false);

		errorText = new TextArea(10, 40);
		errorText.setEditable(false);

		Panel first = new Panel();
		first.setLayout(new GridLayout(3, 2));
		first.add(new Label("threadID:"));
		first.add(threadIDText);
		first.add(new Label("userEmail:"));
		first.add(userEmailText);
		
		Panel second = new Panel(new GridLayout(4, 1));
		second.add(updateButton);
		
		Panel third = new Panel();
		third.add(errorText);
		
		add(first);
		add(second);
		add(third);
	    
	
		//setSize(500, 600);
		setLayout(new FlowLayout());
		setVisible(true);
		
	}
    
	public void deleteGUIMESSAGE_THREAD()
	{
		removeAll();
		MESSAGE_THREADList = new List(10);
		loadMESSAGE_THREAD();
		add(MESSAGE_THREADList);
		
		//When a list item is selected populate the text fields
		MESSAGE_THREADList.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e) 
			{
				try 
				{
					rs = statement.executeQuery("SELECT * FROM MESSAGE_THREAD");
					while (rs.next()) 
					{
						if (rs.getString("threadID").equals(MESSAGE_THREADList.getSelectedItem()))
						break;
					}
					if (!rs.isAfterLast()) 
					{
						threadIDText.setText(rs.getString("threadID"));
						userEmailText.setText(rs.getString("userEmail"));
					}
				} 
				catch (SQLException selectException) 
				{
					displaySQLErrors(selectException);
				}
			}
		});
	    
		//Handle Delete orders Button
		deleteRowButton = new Button("Delete");
		deleteRowButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					Statement statement = connection.createStatement();
					int i = statement.executeUpdate("DELETE FROM MESSAGE_THREAD WHERE threadID = '" + MESSAGE_THREADList.getSelectedItem()+"'");
					errorText.append("\nDeleted " + i + " rows successfully");
					threadIDText.setText(null);
					userEmailText.setText(null);
					MESSAGE_THREADList.removeAll();
					loadMESSAGE_THREAD();
				} 
				catch (SQLException deleteException) 
				{
					displaySQLErrors(deleteException);
				}
			}
		});
		
		threadIDText = new TextField(15);
		userEmailText = new TextField(15);
		
		
		errorText = new TextArea(10, 40);
		errorText.setEditable(false);
		
		threadIDText.setEditable(false);
		userEmailText.setEditable(false);
		

		Panel first = new Panel();
		first.setLayout(new GridLayout(3, 2));
		first.add(new Label("threadID:"));
		first.add(threadIDText);
		first.add(new Label("userEmail:"));
		first.add(userEmailText);
		
		
		Panel second = new Panel(new GridLayout(4, 1));
		second.add(deleteRowButton);
		
		Panel third = new Panel();
		third.add(errorText);
		
		add(first);
		add(second);
		add(third);
	    

		setLayout(new FlowLayout());
		setVisible(true);
		
	}
	
	
	//user_emailText,friend_emailText
	public void viewfriendsGUI() 
	{	
		removeAll();
		friendsList = new List(6);
		loadfriends();
		add(friendsList);
		
		//When a list item is selected populate the text fields
		friendsList.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e) 
			{
				try 
				{
					rs = statement.executeQuery("SELECT * FROM friends");
					while (rs.next()) 
					{
						if (rs.getString("user_email").equals(friendsList.getSelectedItem()))
						break;
					}
					if (!rs.isAfterLast()) 
					{
						user_emailText.setText(rs.getString("user_email"));
						friend_emailText.setText(rs.getString("friend_email"));
						
					}
				} 
				catch (SQLException selectException) 
				{
					displaySQLErrors(selectException);
				}
			}
		});	    
		//Handle Update Menu Button
		/*updateButton = new Button("Update Menu");
		updateButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					Statement statement = connection.createStatement();
					int i = statement.executeUpdate("UPDATE menu "
					+ "SET dishprice=" + costText.getText()  
					+ " WHERE dishid = '" + menuList.getSelectedItem() + "'");
					errorText.append("\nUpdated " + i + " rows successfully");
					menuList.removeAll();
					loadMenu();
				} 
				catch (SQLException insertException) 
				{
					displaySQLErrors(insertException);
				}
			}
		});*/
		
		user_emailText = new TextField(15);
		user_emailText.setEditable(false);
		friend_emailText = new TextField(15);
		friend_emailText.setEditable(false);
		
		errorText = new TextArea(10, 40);
		errorText.setEditable(false);

		Panel first = new Panel();
		first.setLayout(new GridLayout(4, 2));
		first.add(new Label("user_email:"));
		first.add(user_emailText);
		first.add(new Label("friend_email:"));
		first.add(friend_emailText);
		
		
		Panel second = new Panel(new GridLayout(4, 1));
		//second.add(updateButton);
		
		Panel third = new Panel();
		//third.add(errorText);
		
		add(first);
		
		add(second);
		add(third);
	    
		//setTitle("Update ....");
		//setSize(500, 600);
		setLayout(new FlowLayout());
		setVisible(true);
		
	}
    //comment_like,post_shares,groupmembers
	//commenterText , comment_liked_User_IDText;
	//TextField post_IDText , shared_User_IDText;
	//TextField gmidText, gidText

	public void viewcomment_likeGUI() 
	{	
		removeAll();
		comment_likeList = new List(6);
		loadcomment_like();
		add(comment_likeList);
		
		//When a list item is selected populate the text fields
		comment_likeList.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e) 
			{
				try 
				{
					rs = statement.executeQuery("SELECT * FROM comment_like");
					while (rs.next()) 
					{
						if (rs.getString("comment_liked_User_ID").equals(comment_likeList.getSelectedItem()))
						break;
					}
					if (!rs.isAfterLast()) 
					{
						commenterText.setText(rs.getString("commenter"));
						comment_liked_User_IDText.setText(rs.getString("comment_liked_User_ID"));
						
					}
				} 
				catch (SQLException selectException) 
				{
					displaySQLErrors(selectException);
				}
			}
		});	    
		//Handle Update Menu Button
		/*updateButton = new Button("Update Menu");
		updateButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					Statement statement = connection.createStatement();
					int i = statement.executeUpdate("UPDATE menu "
					+ "SET dishprice=" + costText.getText()  
					+ " WHERE dishid = '" + menuList.getSelectedItem() + "'");
					errorText.append("\nUpdated " + i + " rows successfully");
					menuList.removeAll();
					loadMenu();
				} 
				catch (SQLException insertException) 
				{
					displaySQLErrors(insertException);
				}
			}
		});*/
		
		commenterText = new TextField(15);
		commenterText.setEditable(false);
		comment_liked_User_IDText = new TextField(15);
		comment_liked_User_IDText.setEditable(false);
		
		errorText = new TextArea(10, 40);
		errorText.setEditable(false);

		Panel first = new Panel();
		first.setLayout(new GridLayout(4, 2));
		first.add(new Label("commenter:"));
		first.add(commenterText);
		first.add(new Label("comment_liked_User_ID:"));
		first.add(comment_liked_User_IDText);
		
		
		Panel second = new Panel(new GridLayout(4, 1));
		//second.add(updateButton);
		
		Panel third = new Panel();
		//third.add(errorText);
		
		add(first);
		
		add(second);
		add(third);
	    
		//setTitle("Update ....");
		//setSize(500, 600);
		setLayout(new FlowLayout());
		setVisible(true);
		
	}
	
	//post_shares,groupmembers
	//TextField post_IDText , shared_User_IDText;
		//TextField gmidText, gidText
	public void viewpost_sharesGUI() 
	{	
		removeAll();
		post_sharesList = new List(6);
		loadpost_shares();
		add(post_sharesList);
		
		//When a list item is selected populate the text fields
		post_sharesList.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e) 
			{
				try 
				{
					rs = statement.executeQuery("SELECT * FROM post_shares");
					while (rs.next()) 
					{
						if (rs.getString("post_ID").equals(post_sharesList.getSelectedItem()))
						break;
					}
					if (!rs.isAfterLast()) 
					{
						post_IDText.setText(rs.getString("post_ID"));
						shared_User_IDText.setText(rs.getString("shared_User_ID"));
						
					}
				} 
				catch (SQLException selectException) 
				{
					displaySQLErrors(selectException);
				}
			}
		});	    
		//Handle Update Menu Button
		/*updateButton = new Button("Update Menu");
		updateButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					Statement statement = connection.createStatement();
					int i = statement.executeUpdate("UPDATE menu "
					+ "SET dishprice=" + costText.getText()  
					+ " WHERE dishid = '" + menuList.getSelectedItem() + "'");
					errorText.append("\nUpdated " + i + " rows successfully");
					menuList.removeAll();
					loadMenu();
				} 
				catch (SQLException insertException) 
				{
					displaySQLErrors(insertException);
				}
			}
		});*/
		
		post_IDText = new TextField(15);
		post_IDText.setEditable(false);
		shared_User_IDText = new TextField(15);
		shared_User_IDText.setEditable(false);
		
		errorText = new TextArea(10, 40);
		errorText.setEditable(false);

		Panel first = new Panel();
		first.setLayout(new GridLayout(4, 2));
		first.add(new Label("post_ID:"));
		first.add(post_IDText);
		first.add(new Label("shared_User_ID:"));
		first.add(shared_User_IDText);
		
		
		Panel second = new Panel(new GridLayout(4, 1));
		//second.add(updateButton);
		
		Panel third = new Panel();
		//third.add(errorText);
		
		add(first);
		
		add(second);
		add(third);
	    
		//setTitle("Update ....");
		//setSize(500, 600);
		setLayout(new FlowLayout());
		setVisible(true);
		
	}
	
	//groupmembers

			//TextField gmidText, gidText
		public void viewgroupmembersGUI() 
		{	
			removeAll();
			groupmembersList = new List(6);
			loadgroupmembers();
			add(groupmembersList);
			
			//When a list item is selected populate the text fields
			groupmembersList.addItemListener(new ItemListener()
			{
				public void itemStateChanged(ItemEvent e) 
				{
					try 
					{
						rs = statement.executeQuery("SELECT * FROM groupmembers");
						while (rs.next()) 
						{
							if (rs.getString("gmid").equals(groupmembersList.getSelectedItem()))
							break;
						}
						if (!rs.isAfterLast()) 
						{
							gmidText.setText(rs.getString("gmid"));
							gidText.setText(rs.getString("gid"));
							
						}
					} 
					catch (SQLException selectException) 
					{
						displaySQLErrors(selectException);
					}
				}
			});	    
			//Handle Update Menu Button
			/*updateButton = new Button("Update Menu");
			updateButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					try 
					{
						Statement statement = connection.createStatement();
						int i = statement.executeUpdate("UPDATE menu "
						+ "SET dishprice=" + costText.getText()  
						+ " WHERE dishid = '" + menuList.getSelectedItem() + "'");
						errorText.append("\nUpdated " + i + " rows successfully");
						menuList.removeAll();
						loadMenu();
					} 
					catch (SQLException insertException) 
					{
						displaySQLErrors(insertException);
					}
				}
			});*/
			
			gmidText = new TextField(15);
			gmidText.setEditable(false);
			gidText = new TextField(15);
			gidText.setEditable(false);
			
			errorText = new TextArea(10, 40);
			errorText.setEditable(false);

			Panel first = new Panel();
			first.setLayout(new GridLayout(4, 2));
			first.add(new Label("gmid:"));
			first.add(gmidText);
			first.add(new Label("gid:"));
			first.add(gidText);
			
			
			Panel second = new Panel(new GridLayout(4, 1));
			//second.add(updateButton);
			
			Panel third = new Panel();
			//third.add(errorText);
			
			add(first);
			
			add(second);
			add(third);
		    
			//setTitle("Update ....");
			//setSize(500, 600);
			setLayout(new FlowLayout());
			setVisible(true);
			
		}
		
		//threadID,userEmailText   MESSAGE_THREAD
		public void viewMESSAGE_THREADGUI() 
		{	
			removeAll();
			MESSAGE_THREADList = new List(6);
			loadMESSAGE_THREAD();
			add(MESSAGE_THREADList);
			
			//When a list item is selected populate the text fields
			MESSAGE_THREADList.addItemListener(new ItemListener()
			{
				public void itemStateChanged(ItemEvent e) 
				{
					try 
					{
						rs = statement.executeQuery("SELECT * FROM MESSAGE_THREAD");
						while (rs.next()) 
						{
							if (rs.getString("threadID").equals(MESSAGE_THREADList.getSelectedItem()))
							break;
						}
						if (!rs.isAfterLast()) 
						{
							threadIDText.setText(rs.getString("threadID"));
							userEmailText.setText(rs.getString("userEmail"));
							
						}
					} 
					catch (SQLException selectException) 
					{
						displaySQLErrors(selectException);
					}
				}
			});	    
			//Handle Update Menu Button
			/*updateButton = new Button("Update Menu");
			updateButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					try 
					{
						Statement statement = connection.createStatement();
						int i = statement.executeUpdate("UPDATE menu "
						+ "SET dishprice=" + costText.getText()  
						+ " WHERE dishid = '" + menuList.getSelectedItem() + "'");
						errorText.append("\nUpdated " + i + " rows successfully");
						menuList.removeAll();
						loadMenu();
					} 
					catch (SQLException insertException) 
					{
						displaySQLErrors(insertException);
					}
				}
			});*/
			
			threadIDText = new TextField(15);
			threadIDText.setEditable(false);
			userEmailText = new TextField(15);
			userEmailText.setEditable(false);
			
			errorText = new TextArea(10, 40);
			errorText.setEditable(false);

			Panel first = new Panel();
			first.setLayout(new GridLayout(4, 2));
			first.add(new Label("threadID:"));
			first.add(threadIDText);
			first.add(new Label("userEmail:"));
			first.add(userEmailText);
			
			
			Panel second = new Panel(new GridLayout(4, 1));
			//second.add(updateButton);
			
			Panel third = new Panel();
			//third.add(errorText);
			
			add(first);
			
			add(second);
			add(third);
		    
			//setTitle("Update ....");
			//setSize(500, 600);
			setLayout(new FlowLayout());
			setVisible(true);
			
		}
		
	public void displaySQLErrors(SQLException e) 
	{
		errorText.append("\nSQLException: " + e.getMessage() + "\n");
		errorText.append("SQLState:     " + e.getSQLState() + "\n");
		errorText.append("VendorError:  " + e.getErrorCode() + "\n");
	}
	public void paint(Graphics g)
    {
		Font f= new Font("Arial",Font.BOLD,15);
		g.setFont(f);
    	g.drawString("SOCIAL MEDIA DATABASE",150,200);
    }

    public static void main(String[] args) 
	{
		InsertTables it = new InsertTables();
		it.addWindowListener(new WindowAdapter(){
		  public void windowClosing(WindowEvent e) 
		  {
			System.exit(0);
		  }
		});
		it.buildFrame();
	}
}

	        
		
		


