package org.usfirst.frc.team1058.robot.subsystems;

import org.usfirst.frc.team1058.robot.RobotMap;
import org.usfirst.frc.team1058.robot.commands.DriveIntakeRoller;
import org.usfirst.frc.team1058.robot.commands.IntakeRollerDefault;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeRoller extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public CANTalon intakeRollerTalon = new CANTalon(RobotMap.intakeRollerCANTalon);
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new IntakeRollerDefault());
    }
    public void initializeMotors(){
    	intakeRollerTalon.changeControlMode(CANTalon.TalonControlMode.PercentVbus);

    }
    public void setIntakeSpeed(double intakeSpeed){
    	intakeRollerTalon.set(intakeSpeed);
    }
}

