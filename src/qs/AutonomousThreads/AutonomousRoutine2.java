/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.AutonomousThreads;

import qs.DriveModules.AvianceTankDrive;
import qs.ThreadSetup.AvianceThread;
import qs.Vision.AdvancedVision;

/**
 *
 * @author Darvin
 */
public class AutonomousRoutine2 extends AvianceThread{
    boolean HotGoal;
protected void iteration(){
(new AdvancedVision()).start();
HotGoal = AdvancedVision.HotGoal;
    if(HotGoal == true){
    if(AdvancedVision.Distance >= 10){AvianceTankDrive.front_left.set(1); AvianceTankDrive.front_right.set(1);}
    else{AvianceTankDrive.front_left.set(0); AvianceTankDrive.front_right.set(0);}
    
    }

}
    
    
}
