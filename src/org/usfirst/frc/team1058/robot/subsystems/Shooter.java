package org.usfirst.frc.team1058.robot.subsystems;

import org.usfirst.frc.team1058.robot.RobotMap;
import org.usfirst.frc.team1058.robot.commands.DoNothingCommand;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class Shooter extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Solenoid shooterSolenoid = new Solenoid(RobotMap.shooterSolenoidChannel);
	public Solenoid shooterSolenoid2 = new Solenoid(RobotMap.shooterSolenoidChannel2);
	public Solenoid flashlightControl = new Solenoid(RobotMap.flashlightChannel);
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DoNothingCommand());
    }
    public void shoot(){
    	shooterSolenoid.set(true);
    	shooterSolenoid2.set(true);
    }
    public void retract(){
    	shooterSolenoid.set(false);
    	shooterSolenoid2.set(false);
    }
    public void flashlightOn(){
    	flashlightControl.set(true);
    }
    public void flashlightOff(){
    	flashlightControl.set(false);
    }
}

