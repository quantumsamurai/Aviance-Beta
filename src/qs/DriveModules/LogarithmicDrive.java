/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.DriveModules;

import com.sun.squawk.util.MathUtils;
import qs.GeneralModules.AvianceRobot;
import qs.RobotHardware.Joystick1Simplify;
import qs.ThreadSetup.AvianceThread;
import qs.ThreadSetup.AvianceThreadManager;

/**
 *
 * @author Darvin
 */
public class LogarithmicDrive extends AvianceThread{
    double Magnitude, curve;
    public LogarithmicDrive(){
    AvianceThreadManager.getInstance().addThread(AvianceRobot.teleopThreads, this);
    }
    protected void iteration(){
        Magnitude = Joystick1Simplify.LeftJoystickYAxis();
        curve = Joystick1Simplify.RightJoystickYAxis();
    logdrive(Magnitude, curve);    
    
    }
    protected void reset(){
    
    }
public void logdrive(double JoystickMag, double JoystickCurve){
    double m_sensitivity = .5;
    double leftOutput;
    double rightOutput;
        if (curve < 0) {
            double value = MathUtils.log(-curve);
            double ratio = (value - m_sensitivity) / (value + m_sensitivity);
            if (ratio == 0) {
                ratio = .0000000001;
            }
         leftOutput = JoystickMag / ratio;
           rightOutput = JoystickMag;
        } else if (curve > 0) {
            double value = MathUtils.log(curve);
            double ratio = (value - m_sensitivity) / (value + m_sensitivity);
            if (ratio == 0) {
                ratio = .0000000001;
            }
            leftOutput = JoystickMag;
            rightOutput = JoystickMag / ratio;
        } else {
            leftOutput = JoystickMag;
            rightOutput = JoystickMag;
        }
        AvianceTankDrive.front_left.set(leftOutput);
        AvianceTankDrive.front_right.set(rightOutput);
}
}
