package org.usfirst.frc.team1983.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivebase extends Subsystem
{
    private Talon left1;
    private Talon left2;
    private Talon left3;
    private Talon right1;
    private Talon right2;
    private Talon right3;
    
    public Drivebase(int leftPort1, int leftPort2, int leftPort3, int rightPort1, int rightPort2, int rightPort3)
    {
        left1 = new Talon(leftPort1);
        left1.setInverted(true);
        left2 = new Talon(leftPort2);
        left2.setInverted(true);
        left3 = new Talon(leftPort3);
        left3.setInverted(true);
        
        right1 = new Talon(rightPort1);
        right2 = new Talon(rightPort2);
        right3 = new Talon(rightPort3);
    }
    
    public void setLeftSpeed(double speed)
    {
        left1.set(speed);
        left2.set(speed);
        left3.set(speed);
    }
    
    public void setRightSpeed(double speed)
    {
        right1.set(speed);
        right2.set(speed);
        right3.set(speed);
    }
    
    @Override
    protected void initDefaultCommand()
    {
    
    }
}

