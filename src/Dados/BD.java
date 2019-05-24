package Dados;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BD {
	
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;

	private static BD instance;
	
	public static BD getInstance() {
		if (BD.instance == null) {
			BD.instance = new BD();
			}
		return BD.instance;
	}
	
	public void conectar() {
		String servidor  = "jdbc:mysql://localhost:3306/projeto";
		String usuario = "root";
		String senha = "1234";
		String driver = "com.mysql.jdbc.Driver";
		try {
				Class.forName(driver);
				this.connection = DriverManager.getConnection(servidor, usuario, senha);
				this.statement = this.connection.createStatement();
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void desconectar() {
		try {
			this.connection.close();
		} catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
	}

	public boolean estaConectado() {
		if(this.connection != null) {
			return true;
		} else {
		return false;
		}
	}
	
	public Connection getConnection() {
		return connection;
	}



	public void setConnection(Connection connection) {
		this.connection = connection;
	}



	public Statement getStatement() {
		return statement;
	}



	public void setStatement(Statement statement) {
		this.statement = statement;
	}



	public ResultSet getResultset() {
		return resultset;
	}



	public void setResultset(ResultSet resultset) {
		this.resultset = resultset;
	}
}
