package org.example;

import org.example.wrappers.ClientService;

public class Main {
    public static void main(String[] args) {
        ClientService clientService = new ClientService();

        System.out.println("ID of the created client is: "+clientService.create("Igor"));
        System.out.println("Client: "+clientService.getById(2));
        clientService.setName(3,"George");
        clientService.deleteById(7);

        System.out.println("All clients: "+clientService.listAll().toString());
    }
}