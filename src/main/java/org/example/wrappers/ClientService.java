package org.example.wrappers;

import org.example.config.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    Connection connection;
    public static final String INSERT_CLIENT = "INSERT INTO client (name) VALUES (?);";
    public static final String SEARCH_CLIENT_BY_ID = "SELECT name FROM client WHERE id = ?;";
    private static final String UPDATE_CLIENT_STRING = "UPDATE client SET name = ? WHERE id = ? ";
    private static final String DELETE_CLIENT_ON_ID = "DELETE FROM client WHERE id = ? ";
    private static final String SELECT_ALL = "SELECT * FROM client";
    private PreparedStatement newClient;
    private PreparedStatement searchByIDClient;
    private PreparedStatement updateClientByID;
    private PreparedStatement deleteClientOnID;
    private PreparedStatement selectAllClients;

    public ClientService(){
        this.connection = Database.getInstance().getPostgresConnection();
        try {
            this.newClient = connection.prepareStatement(INSERT_CLIENT, Statement.RETURN_GENERATED_KEYS);
            this.searchByIDClient = connection.prepareStatement(SEARCH_CLIENT_BY_ID);
            this.updateClientByID = connection.prepareStatement(UPDATE_CLIENT_STRING);
            this.deleteClientOnID = connection.prepareStatement(DELETE_CLIENT_ON_ID);
            this.selectAllClients = connection.prepareStatement(SELECT_ALL);
            } catch(SQLException e) {
            System.out.println("Can not create connection. Reason: " + e.getMessage());
        }
    }

    public long create(String name){
        try{
            newClient.setString(1, name);
            newClient.executeUpdate();

            ResultSet generatedKeys = newClient.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getLong(1);
            }
        } catch (SQLException e){
            System.out.println("Can not create client. Reason:" + e.getMessage());
        }
        return -1;
    }

    public String getById(long id){
        try {
            this.searchByIDClient.setLong(1,id);
            try(ResultSet resultSet = searchByIDClient.executeQuery()){
                if (resultSet.next()) {
                    return resultSet.getString("name");
                }
            } catch (SQLException e) {
                System.out.println("Can not create Statements. Reason:" + e.getMessage());
            }
            return "There is no name by this id";
        }catch (SQLException e) {
            System.out.println("Select client exception. Reason: " + e.getMessage());
        }
        return "There is no name by this id";
    }

    public void setName(long id, String name){
        try{
            this.updateClientByID.setString(1, name);
            this.updateClientByID.setLong(2,id);

            this.updateClientByID.executeUpdate();
        }catch (SQLException e) {
            System.out.println("Update client exception. Reason: " + e.getMessage());
        }
    }

    public void deleteById(long id){
        try{
            this.deleteClientOnID.setLong(1,id);
            this.deleteClientOnID.executeUpdate();
        }catch (SQLException e) {
            System.out.println("Delete client exception. Reason: " + e.getMessage());
        }
    }

    public List<Clients> listAll(){
        List<Clients> clients = new ArrayList<>();
        try(ResultSet resultSet = this.selectAllClients.executeQuery()) {
            while(resultSet.next()) {
                Clients client = new Clients(resultSet.getLong("id"),
                        resultSet.getString("name"));
                clients.add(client);
            }
        } catch(SQLException e) {
            System.out.println("Select ALL clients exception. Reason: " + e.getMessage());
        }
        return clients;
    }
}
