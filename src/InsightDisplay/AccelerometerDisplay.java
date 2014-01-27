/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InsightDisplay;

import InsightLTDisplay.DecimalData;
import edu.wpi.first.wpilibj.ADXL345_I2C;
import qs.sensors.AccelerometerReadings;

/**
 *
 * @author Darvin
 */
public class AccelerometerDisplay {
    static DecimalData accelerometer;
    static float acceleromterX = (float)AccelerometerReadings.accelerometer.getAcceleration(ADXL345_I2C.Axes.kX);
    static int zonenumber = 3;
    static{
    accelerometer = new DecimalData("Acceleromter: ");
    accelerometer.setData(acceleromterX);
    
    }
}
