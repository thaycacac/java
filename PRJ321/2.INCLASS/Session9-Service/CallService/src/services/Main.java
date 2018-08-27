package services;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Thaycacac
 */
public class Main {

    public static void main(String[] args) {
        SumService_Service manager = new SumService_Service();
        SumService service = manager.getSumServicePort();
        int c = service.sum(10, 15);
        System.out.println(c);
    }
}
