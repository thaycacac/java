/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Thaycacac
 */
@WebService(serviceName = "sumService")
public class sumService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "sum")
    public int sum(@WebParam(name = "a") int a, @WebParam(name = "b") int b) {
        return a + b;
    }
}
