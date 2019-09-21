/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WMSGUI;

/**
 *
 * @author jsommute
 */
import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;
 
public class WMSReadScale {
 
   public static void main(String[] args) {
      // get computer serial ports names
      String[] portNames = SerialPortList.getPortNames();
      for (String port : portNames) {
         System.out.println(port);
      
 
      // inicialization with selecting port for communication
//      SerialPort serialPort = new SerialPort("COM14");
      SerialPort serialPort = new SerialPort(port);
      
      if (port.equals("COM5") ) {
          
      try {
         // open port for communication
          System.out.println("Open PORT:" + port);
         serialPort.openPort();
         // baundRate, numberOfDataBits, numberOfStopBits, parity
         serialPort.setParams(9600, 8, 1, 0);
         // byte data transfer
//         serialPort.writeBytes("text to tranfer".getBytes());
         // String data transfer
       serialPort.writeString("text to tranfer");
       serialPort.closePort();
       
       
//         ReadString
       serialPort.openPort();
         // baundRate, numberOfDataBits, numberOfStopBits, parity
         serialPort.setParams(9600, 8, 1, 0);
         String FCom = serialPort.readString();
          System.out.println("Read PORT: " + port + " Respond String:" + FCom);
         // close port
         
         serialPort.closePort();
      } catch (SerialPortException ex) {
         System.out.println(ex);
      }
      }
     }
   }
}