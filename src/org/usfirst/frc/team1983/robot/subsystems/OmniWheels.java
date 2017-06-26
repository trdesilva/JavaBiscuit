package org.usfirst.frc.team1983.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1983.robot.RobotMap;

public class OmniWheels extends Subsystem
{
    private boolean isLowered;
    private DoubleSolenoid solenoid1;
    private DoubleSolenoid solenoid2;
    
    public OmniWheels(int forwardPort1, int reversePort1, int forwardPort2, int reversePort2)
    {
        isLowered = false;
        solenoid1 = new DoubleSolenoid(RobotMap.PCM_ID, forwardPort1, reversePort1);
        solenoid2 = new DoubleSolenoid(RobotMap.PCM_ID, forwardPort2, reversePort2);
    }
    
    public void setLowered(boolean isLowered)
    {
        this.isLowered = isLowered;
        System.out.printf("setting omniwheels to %s\n", isLowered ? "down" : "up");
        solenoid1.set(isLowered ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
        solenoid2.set(isLowered ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
    }
    
    public boolean isLowered()
    {
        return isLowered;
    }
    
    @Override
    protected void initDefaultCommand()
    {
    
    }
}

