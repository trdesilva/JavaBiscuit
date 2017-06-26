package org.usfirst.frc.team1983.robot.commands;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.usfirst.frc.team1983.robot.Oi;
import org.usfirst.frc.team1983.robot.subsystems.Drivebase;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class UT_TankDrive
{
    @Mock
    private Drivebase drivebase;
    
    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private Oi oi;
    
    private TankDrive tankDrive;
    
    
    @Before
    public void setup()
    {
        initMocks(this);
        
        tankDrive = new TankDrive(drivebase, oi);
    }
    
    @Test
    public void initializeStopsMotors()
    {
        tankDrive.initialize();
        
        verify(drivebase).setLeftSpeed(0);
        verify(drivebase).setRightSpeed(0);
    }
    
    @Test
    public void endStopsMotors()
    {
        tankDrive.end();
        
        verify(drivebase).setLeftSpeed(0);
        verify(drivebase).setRightSpeed(0);
    }
    
    @Test
    public void executeHasDeadband()
    {
        when(oi.getJoystick().getRawAxis(anyInt())).thenReturn(0.04);
        
        tankDrive.execute();
    
        when(oi.getJoystick().getRawAxis(anyInt())).thenReturn(-0.04);
    
        tankDrive.execute();
    
        verify(drivebase, times(2)).setLeftSpeed(0);
        verify(drivebase, times(2)).setRightSpeed(0);
    }
    
    @Test
    public void executeSquaresInputsWithCorrectSigns()
    {
        when(oi.getJoystick().getRawAxis(anyInt())).thenReturn(0.5);
    
        tankDrive.execute();
    
        verify(drivebase).setLeftSpeed(0.5*0.5);
        verify(drivebase).setRightSpeed(0.5*0.5);
    
        when(oi.getJoystick().getRawAxis(anyInt())).thenReturn(-0.5);
    
        tankDrive.execute();
    
        verify(drivebase).setLeftSpeed(-0.5*0.5);
        verify(drivebase).setRightSpeed(-0.5*0.5);
    }
}
