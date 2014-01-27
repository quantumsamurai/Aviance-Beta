/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.FrameworkEntered;

import qs.RobotHardware.Hardware;
import qs.GeneralModules.AvianceRobot;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 * @author Darvin
 */
public class FailSafeRobot {




    Talon front_left = ((Talon) Hardware.pwm[Hardware.talon_front_left]);
  //  Talon back_left = ((Talon) Hardware.pwm[Hardware.talon_back_left]);
    Talon front_right = ((Talon) Hardware.pwm[Hardware.talon_front_right]);
    //Talon back_right = ((Talon) Hardware.pwm[Hardware.talon_back_right]);
   
    

   static DriverStation driverStation = DriverStation.getInstance();
    
    public static void main(String[] args){

        System.out.println("FAILSAFE ROBOT HAS BEEN STARTED"); 
        boolean disabled = driverStation.isDisabled(); //
        boolean autonomous = driverStation.isAutonomous(); // so these guys report the state of the bot upon entering of the loop and apply for this iteration     
        boolean teleoperated = driverStation.isOperatorControl();   
        boolean fms = driverStation.isFMSAttached();     
        
        if(disabled){
                    while(driverStation.isDisabled())
                     disabled();
                }
                
                else if (autonomous){
                    
                    
                    while(driverStation.isEnabled())
                   autonomous() ;
                }
                
                else if (teleoperated){
                  
                    while(driverStation.isEnabled())
                   teleoperated() ;
                }
     
        

    }
    public static void teleoperated(){ System.out.println("In Teleoperated");}
    public static void autonomous(){System.out.println("In Autonomous");}
    public static void disabled(){}
    

}
