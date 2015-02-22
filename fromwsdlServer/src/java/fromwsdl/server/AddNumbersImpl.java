/*
 * AddNumbersImplService.java
 *
 * Created on Oct 6, 2007, 1:23:38 PM
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fromwsdl.server;

import javax.jws.WebService;

// The following pacakge needs to be added
// since the generated files are created
// under this package - Sang Shin.
import org.example.duke.*;

/**
 *
 * @author sang
 */
@WebService(serviceName = "AddNumbersService", portName = "AddNumbersPort", endpointInterface = "org.example.duke.AddNumbersPortType", targetNamespace = "http://duke.example.org", wsdlLocation = "WEB-INF/wsdl/AddNumbersImplService/AddNumbers.wsdl")
public class AddNumbersImpl implements AddNumbersPortType {

    /**
     * @param number1
     * @param number2
     * @return The sum
     * @throws AddNumbersException
     *             if any of the numbers to be added is negative.
     */
    public int addNumbers(int number1, int number2) throws AddNumbersFault_Exception {
        if (number1 < 0 || number2 < 0) {
            String message = "Negative number cant be added!";
            String detail = "Numbers: " + number1 + ", " + number2;
            AddNumbersFault fault = new AddNumbersFault();
            fault.setMessage(message);
            fault.setFaultInfo(detail);
            throw new AddNumbersFault_Exception(message, fault);
        }
        return number1 + number2;
    }

    /*
     * Simple one-way method that takes an integer.
     */
    public void oneWayInt(int number) {
        System.out.println("Service received: " + number);
    }
}