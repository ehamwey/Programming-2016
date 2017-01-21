package org.usfirst.frc.team1058.robot.subsystems;

import org.usfirst.frc.team1058.robot.RobotMap;

import org.usfirst.frc.team1058.robot.commands.ExampleCommand;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {
    
	Solenoid climberFirstStage = new Solenoid(RobotMap.climberExtendSolenoidChannel);
	Solenoid climberSecondStage = new Solenoid(RobotMap.climberHookSolenoidChannel);
	com.ctre.CANTalon climberWinch = new com.ctre.CANTalon(RobotMap.climberWinch);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ExampleCommand());
    }
    public void extendFirstStage(){
    	climberFirstStage.set(true);
    }
    public void retractFirstStage(){
    	climberFirstStage.set(false);
    }
    public void extendSecondStage(){
    	climberSecondStage.set(true);
    }
    public void retractSecondStage(){
    	climberSecondStage.set(false);
    }
	public void winch() {
		climberWinch.set(-1); // slow atm because we don't know the direction
	}
	public void stopWinch(){
		climberWinch.set(0);
	}
}

