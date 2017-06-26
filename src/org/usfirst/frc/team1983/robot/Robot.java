package org.usfirst.frc.team1983.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team1983.robot.commands.TankDrive;
import org.usfirst.frc.team1983.robot.subsystems.Drivebase;
import org.usfirst.frc.team1983.robot.subsystems.OmniWheels;
import org.usfirst.frc.team1983.robot.subsystems.Shifter;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot
{
    private static final Robot INSTANCE = new Robot();
    
    private final Drivebase DRIVEBASE = new Drivebase(RobotMap.LEFT_PORT_1, RobotMap.LEFT_PORT_2, RobotMap.LEFT_PORT_3,
                                                      RobotMap.RIGHT_PORT_1, RobotMap.RIGHT_PORT_2, RobotMap.RIGHT_PORT_3);
    private final Shifter SHIFTER = new Shifter(RobotMap.SHIFTER_PORT_1, RobotMap.SHIFTER_PORT_2);
    private final OmniWheels OMNI_WHEELS = new OmniWheels(RobotMap.OMNI_PORT_1, RobotMap.OMNI_PORT_2,
                                                                RobotMap.OMNI_PORT_3, RobotMap.OMNI_PORT_4);
    private final Compressor COMPRESSOR = new Compressor(RobotMap.PCM_ID);
    private Oi OI;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit()
    {
        OI = new Oi();
        System.out.println("Foo");
    }
    
    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    @Override
    public void disabledInit()
    {
        COMPRESSOR.stop();
    }
    
    @Override
    public void disabledPeriodic()
    {
        Scheduler.getInstance().run();
    }
    
    /**
     * This autonomous (along with the chooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable
     * chooser code works with the Java SmartDashboard. If you prefer the
     * LabVIEW Dashboard, remove all of the chooser code and uncomment the
     * getString code to get the auto name from the text box below the Gyro
     * <p>
     * You can add additional auto modes by adding additional commands to the
     * chooser code above (like the commented example) or additional comparisons
     * to the switch structure below with additional strings & commands.
     */
    @Override
    public void autonomousInit()
    {
        // schedule the autonomous command (example)
    }
    
    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic()
    {
        Scheduler.getInstance().run();
    }
    
    @Override
    public void teleopInit()
    {
        Scheduler.getInstance().add(new TankDrive(Robot.getInstance().getDrivebase(), Robot.getInstance().getOi()));
        COMPRESSOR.start();
    }
    
    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic()
    {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    @Override
    public void testPeriodic()
    {
        LiveWindow.run();
    }
    
    public static Robot getInstance()
    {
        return INSTANCE;
    }
    
    public Drivebase getDrivebase()
    {
        return DRIVEBASE;
    }
    
    public Shifter getShifter()
    {
        return SHIFTER;
    }
    
    public OmniWheels getOmniWheels()
    {
        return OMNI_WHEELS;
    }
    
    public Oi getOi()
    {
        return OI;
    }
}
