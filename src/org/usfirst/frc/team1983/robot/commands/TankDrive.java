package org.usfirst.frc.team1983.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1983.robot.Oi;
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
        double leftSpeed = oi.getJoystick().getRawAxis(1);
        drivebase.setLeftSpeed(scaleInput(leftSpeed));
        
        double rightSpeed = oi.getJoystick().getRawAxis(5);
        drivebase.setRightSpeed(scaleInput(rightSpeed));
        
        System.out.printf("left %f\tright%f\n", leftSpeed, rightSpeed);
    }
    
    protected boolean isFinished()
    {
        // TODO: Make this return true when this Command no longer needs to run execute()
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
        if(Math.abs(input) > 0.05)
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
