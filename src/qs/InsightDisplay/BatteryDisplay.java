/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.InsightDisplay;

import InsightLTDisplay.DecimalData;
import qs.GeneralModules.AvianceRobot;
import qs.ThreadSetup.AvianceThread;

/**
 *
 * @author Darvin
 */
public class BatteryDisplay {
   static DecimalData disp_batteryVoltage;
    static float battVoltage = (float)AvianceRobot.driverStation.getBatteryVoltage();
    static int zonenumber = 1;
static    {
         disp_batteryVoltage = new DecimalData("Batt:");
        disp_batteryVoltage.setData(battVoltage);   
    }
   
}
