/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.RobotHardware;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import qs.GeneralModules.AvianceRobot;
import qs.ThreadSetup.AvianceThread;
import qs.ThreadSetup.AvianceThreadManager;

/**
 *
 * @author Darvin
 */
public class SystemsController extends AvianceThread{
    public SystemsController(){
        AvianceThreadManager.getInstance().addThread(AvianceRobot.systemThreadGroup, this);
    }
  boolean operator1;
  boolean operator2;
  boolean operator3;
  public static String Operator;
    protected void iteration(){
       operator1 = SmartDashboard.getBoolean("Operator 1");
       operator2 = SmartDashboard.getBoolean("Operator 2");
       operator3 = SmartDashboard.getBoolean("Operator 3");
       
       if(operator1 == true){Operator = "Naresh";}
       if(operator2 == true){Operator = "Nelson";}
       if(operator3 == true){Operator = "Sahir";}
    
    }
    protected void reset(){}
}
