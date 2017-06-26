package org.usfirst.frc.team1983.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1983.robot.subsystems.Shifter;

public class Shift extends Command
{
    private Shifter shifter;
    
    public Shift(Shifter shifter)
    {
        this.shifter = shifter;
    }
    
    protected void initialize()
    {
        shifter.setShifted(!shifter.isShifted());
    }
    
    protected void execute()
    {
        
    }
    
    protected boolean isFinished()
    {
        return false;
    }
    
    protected void end()
    {
        
    }
    
    protected void interrupted()
    {
        super.interrupted();
    }
}
