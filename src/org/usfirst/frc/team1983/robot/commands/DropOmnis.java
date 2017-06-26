package org.usfirst.frc.team1983.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1983.robot.subsystems.OmniWheels;

public class DropOmnis extends Command
{
    private OmniWheels omniWheels;
    
    public DropOmnis(OmniWheels omniWheels)
    {
        this.omniWheels = omniWheels;
        requires(omniWheels);
    }
    
    protected void initialize()
    {
        omniWheels.setLowered(!omniWheels.isLowered());
    }
    
    protected void execute()
    {
        
    }
    
    protected boolean isFinished()
    {
        return true;
    }
    
    protected void end()
    {
        
    }
    
    protected void interrupted()
    {
        super.interrupted();
    }
}
