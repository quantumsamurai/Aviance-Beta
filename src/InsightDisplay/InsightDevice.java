/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InsightDisplay;

import qs.sensors.AccelerometerReadings;
import qs.ThreadSetup.AvianceThread;
import qs.ThreadSetup.AvianceThreadManager;
import edu.wpi.first.wpilibj.ADXL345_I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import qs.GeneralModules.AvianceRobot;
import qs.RobotHardware.Hardware;

/**
 *
 * @author Darvin
 */
public class InsightDevice  extends AvianceThread{
    public InsightDevice(){
    //    System.out.println("Insight Thread");
    AvianceThreadManager.getInstance().addThread(AvianceRobot.teleopThreads, this);
    
    
    }
    
  
    
  
    protected void iteration(){
        SmartDashboard.putString("Insight", Hardware.Active);
       // System.out.println(battVoltage);
        Hardware.display.startDisplay();
  

        
        Hardware.display.registerData(GyroAngleDisplay.gyroangle, GyroAngleDisplay.zonenumber);
        Hardware.display.registerData(BatteryDisplay.disp_batteryVoltage, BatteryDisplay.zonenumber);
        Hardware.display.registerData(AccelerometerDisplay.accelerometer, AccelerometerDisplay.zonenumber);
        
        
       
    
    }
    protected void reset(){
        SmartDashboard.putString("Insight", Hardware.Diasbled);
        Hardware.display.stopDisplay();
  //  System.out.println("Insight Thread Interrupted");
    }
    
}
