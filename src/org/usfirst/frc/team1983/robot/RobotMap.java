package org.usfirst.frc.team1983.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
    
    // MOTORS
    public static final int LEFT_PORT_1 = 3;
    public static final int LEFT_PORT_2 = 4;
    public static final int LEFT_PORT_3 = 5;
    public static final int RIGHT_PORT_1 = 0;
    public static final int RIGHT_PORT_2 = 1;
    public static final int RIGHT_PORT_3 = 2;
    
    // SOLENOIDS
    public static final int OMNI_PORT_1 = 0;
    public static final int OMNI_PORT_2 = 1;
    public static final int OMNI_PORT_3 = 2;
    public static final int OMNI_PORT_4 = 3;
    
    public static final int SHIFTER_PORT_1 = 6;
    public static final int SHIFTER_PORT_2 = 7;
    
    // MODULES
    public static final int PCM_ID = 1;
}
