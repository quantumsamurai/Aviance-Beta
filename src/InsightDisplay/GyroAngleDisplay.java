/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InsightDisplay;


import InsightLTDisplay.DecimalData;
import qs.DriveModules.AvianceTankDrive;
import qs.GeneralModules.AvianceRobot;

/**
 *
 * @author Darvin
 */
public class GyroAngleDisplay {
static DecimalData gyroangle;
static float gyroAngle = (float)AvianceTankDrive.gyro.getAngle();
static int zonenumber = 2;
static{
gyroangle = new DecimalData("Gyro Angle");
gyroangle.setData(gyroAngle);
} 
}
