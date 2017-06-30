package org.usfirst.frc.team1983.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1983.robot.RobotMap;

public class Shifter extends Subsystem
{
    private boolean isShifted;
    private DoubleSolenoid solenoid;
    
    public Shifter(int port1, int port2)
    {
        isShifted = false;
        solenoid = new DoubleSolenoid(RobotMap.Modules.PCM_ID, port1, port2);
    }
    
    public void setShifted(boolean isShifted)
    {
        this.isShifted = isShifted;
        System.out.printf("setting SHIFTER to %s\n", isShifted ? "shifted" : "unshifted");
        solenoid.set(isShifted ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
    }
    
    public boolean isShifted()
    {
        return isShifted;
    }
    
    @Override
    protected void initDefaultCommand()
    {
    
    }
}

