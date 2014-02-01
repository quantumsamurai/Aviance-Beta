/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.sensors;

import qs.GeneralModules.AvianceRobot;
import qs.RobotHardware.Hardware;
import qs.RobotHardware.TimeClass;
import qs.ThreadSetup.AvianceThread;
import qs.ThreadSetup.AvianceThreadManager;

/**
 *
 * @author admin
 */
public class EncoderTesting extends AvianceThread{
public EncoderTesting(){
AvianceThreadManager.getInstance().addThread(AvianceRobot.teleopThreads, this);
}    
double RPS;
double pulses = Hardware.encoder_front_left.getRate();
double PPR = 360;

protected void iteration(){

RPS = pulses / PPR;
System.out.println("Left Encoder Rate: " + RPS);

}
private void RPM(){
    {
    pulses = Hardware.encoder_front_left.getRate();
    TimeClass.Time(1);
    } RPS = pulses / PPR;
}
protected void reset(){}
}
