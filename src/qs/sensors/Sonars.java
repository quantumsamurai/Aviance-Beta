/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.sensors;

import qs.GeneralModules.AvianceRobot;
import qs.RobotHardware.Hardware;
import qs.ThreadSetup.AvianceThread;
import qs.ThreadSetup.AvianceThreadManager;

/**
 *
 * @author admin
 */
public class Sonars extends AvianceThread {
 public Sonars(){
 AvianceThreadManager.getInstance().addThread(AvianceRobot.teleopThreads, this);
 }    
 public static double sonarVoltage1;
 protected void iteration(){
sonarVoltage1 = Hardware.sonar1.getVoltage();
 double sonarVoltage2 = Hardware.sonar2.getAverageVoltage() /98;
 System.out.println("Analog " + sonarVoltage1);
 }
 
 protected void reset(){}
}
