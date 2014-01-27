/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.RobotHardware;

import InsightLTDisplay.InsightLT;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.image.CriteriaCollection;
import edu.wpi.first.wpilibj.image.NIVision;

/**
 *
 * @author Darvin
 */
public class Hardware {
    // hardware will be accessed depending on type
    
    //Analog
   public static AnalogChannel sonar1 = new AnalogChannel(2);
   public static AnalogChannel sonar2 = new AnalogChannel(3);
    // PWM ports for each element
    public static final int talon_front_left = 1; //oops we need to give it actual values
    public static final int talon_front_right = 2;

    public static final int talon_indexer = 4;
    public static final int talon_arm = 3;
    
    
    //relay ports
    public static final int relay_defense = 1;
    //toggle variables
     private static boolean motorStatus;
private static boolean previousButton = false;
private static boolean currentButton = false;
     
    //ADXL345 Accelerometer I2C
    public static final int accelerometerI2CPort = 1;
   
    //Axis Camera Variables
   public static AxisCamera camera;
   public static CriteriaCollection cc;
   public static     final int AREA_MINIMUM = 150;
    public static final String CamIP = "10.16.1.11";

 
    //Digital I/O ports
    
    
    //joystick buttons for features
    public static final int joystickSwapButton = 6;
    public static final int joystickArm = 7;
    public static final int joystickWinch = 8;
    public static final int joystickGyro = 5;
    
    //array representation of I/O
    public static final PWM[] pwm = new PWM[10]; //the hardware needs to be initialized...  (an empty array, no objects) how may ports are there?? 10
    public static final Relay[] relays = new Relay[8]; // empty relay array
    
    //Individualized hardware
    public static Joystick joystick1 = new Joystick(1); // joysticks are NOT FINAL; this allows the JoystickSwapper to swap them
    public static Joystick joystick2 = new Joystick(2); //we can make them non-final and create a module that listens for a button to swap them and then swaps them
    
    //joystick Deadband
                     public static double deadband = .1;

    
    public static final Encoder encoder_front_left = new Encoder(2,1);  //this is a more concise way of doing things even though it's slightly inconsistent
    public static final Encoder encoder_front_right = new Encoder(3,4);
    
    //encoder pulse test
    static double pulse = 0.0357142857142857;
    static double pulse1 = (4*Math.PI) / 360;
          

       public static final int gyro_port = 1;
    public static final InsightLT display = new InsightLT(InsightLT.FOUR_ZONES); // InsightLT Constructor
    public static final String Active ="Active";
    public static final String Diasbled = "Disabled";
    
    // we need to start the ecoders literally
   /***
    * This is responsible for initializing hardware that isn't already when the class is loaded into the VM
    */
    static{
        
        //this is going to be slighlty more involved..
        //actually, its not going to be difficult at all..
        System.out.println("Initializing Hardware...");
        
         camera = AxisCamera.getInstance(CamIP);  // get an instance of the camera
        cc = new CriteriaCollection();      // create the criteria for the particle filter
        cc.addCriteria(NIVision.MeasurementType.IMAQ_MT_AREA, AREA_MINIMUM, 65535, false);
        
        encoder_front_left.setDistancePerPulse(pulse);
        encoder_front_right.setDistancePerPulse(pulse);
        
        encoder_front_left.reset();
        encoder_front_right.reset();
        
        encoder_front_left.start();
        encoder_front_right.start();

     
    }
      public static boolean toggleJoystick1(int buttonnumber){
      previousButton = currentButton;
currentButton = Hardware.joystick1.getRawButton(buttonnumber);

if (currentButton && !previousButton) 
{motorStatus = motorStatus ? false : true;

}

return motorStatus;
    }
        public static boolean toggleJoystick2(int buttonnumber){
      previousButton = currentButton;
currentButton = Hardware.joystick2.getRawButton(buttonnumber);

if (currentButton && !previousButton) 
{motorStatus = motorStatus ? false : true;

}

return motorStatus;
    }
}
