/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.DriveModules;

import qs.GeneralModules.AvianceRobot;
import qs.RobotHardware.Joystick1Simplify;
import qs.ThreadSetup.AvianceThread;
import qs.ThreadSetup.AvianceThreadManager;

/**
 *
 * @author Darvin
 */
public class GyroTurn extends AvianceThread{
    public GyroTurn(){
    AvianceThreadManager.getInstance().addThread(AvianceRobot.teleopThreads, this);
    }
    protected void iteration(){
    double currentAngle = AvianceTankDrive.gyro.getAngle();
    double desiredAngle = 90;
    
    if(Joystick1Simplify.getRightBackButton()){
        double delta = desiredAngle - currentAngle;
        double speed = delta * .3;
        if(delta > 0){
       AvianceTankDrive.front_left.set(speed); AvianceTankDrive.front_right.set(-speed);
       }else if (delta < 0){ AvianceTankDrive.front_left.set(-speed); AvianceTankDrive.front_right.set(speed); }
    
            }
    
    
    }
    protected void reset(){
    
    }
}
