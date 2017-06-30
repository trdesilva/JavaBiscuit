package org.usfirst.frc.team1983.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1983.robot.Oi;
import org.usfirst.frc.team1983.robot.RobotMap;
import org.usfirst.frc.team1983.robot.subsystems.Drivebase;

public class TankDrive extends Command
{
    private Drivebase drivebase;
    private Oi oi;
    
    public TankDrive(Drivebase drivebase, Oi oi)
    {
        this.drivebase = drivebase;
        this.oi = oi;
        
        requires(drivebase);
    }
    
    protected void initialize()
    {
        drivebase.setLeftSpeed(0);
        drivebase.setRightSpeed(0);
    }
    
    protected void execute()
    {
        double leftSpeed = oi.getJoystick().getRawAxis(RobotMap.Oi.DRIVEBASE_LEFT_AXIS);
        drivebase.setLeftSpeed(scaleInput(leftSpeed));
    
        double rightSpeed = oi.getJoystick().getRawAxis(RobotMap.Oi.DRIVEBASE_RIGHT_AXIS);
        drivebase.setRightSpeed(scaleInput(rightSpeed));
    
        System.out.printf("left %f\tright %f\n", leftSpeed, rightSpeed);
    }
    
    protected boolean isFinished()
    {
        return false;
    }
    
    protected void end()
    {
        drivebase.setLeftSpeed(0);
        drivebase.setRightSpeed(0);
    }
    
    protected void interrupted()
    {
        super.interrupted();
    }
    
    private double scaleInput(double input)
    {
        if(Math.abs(input) > RobotMap.Oi.DRIVEBASE_DEADBAND)
        {
            if(input > 0)
            {
                return input*input;
            }
            else
            {
                return -input*input;
            }
        }
        
        return 0;
    }
}
