
package org.usfirst.frc.team1058.robot.subsystems;

import org.usfirst.frc.team1058.robot.Robot;
import org.usfirst.frc.team1058.robot.RobotMap;
import org.usfirst.frc.team1058.robot.commands.DriveTankDefault;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveBase extends Subsystem {
    
	 com.ctre.CANTalon lDTOne = new com.ctre.CANTalon(RobotMap.leftMotorOne);
	com.ctre.CANTalon lDTTwo = new com.ctre.CANTalon(RobotMap.leftMotorTwo);
	 com.ctre.CANTalon rDTOne = new com.ctre.CANTalon(RobotMap.rightMotorOne);
	com.ctre.CANTalon rDTTwo = new com.ctre.CANTalon(RobotMap.rightMotorTwo);
	double p = 1;
	double i = 0;
	double d = 0; // TODO: Tune these!
	Solenoid driveBaseShifter = new Solenoid(RobotMap.driveBaseShiftSolenoid);
    int shiftState;
	public DriveBase(){
    	shiftState = 1; // set the shift state to zero because the position of the shifter is unknown
    }
	// Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void initDriveBase(double driveBaseState){ // changes the mode of the CANTalon. Send a 1 for auto, 2 for tele
		if(driveBaseState == 1){
			lDTOne.changeControlMode(com.ctre.CANTalon.TalonControlMode.Position);
			lDTTwo.changeControlMode(com.ctre.CANTalon.TalonControlMode.Follower);
			lDTTwo.set(RobotMap.leftMotorOne);
			rDTOne.changeControlMode(com.ctre.CANTalon.TalonControlMode.Position);
			rDTTwo.changeControlMode(com.ctre.CANTalon.TalonControlMode.Follower);
			
			rDTTwo.set(RobotMap.rightMotorOne);
			lDTOne.setFeedbackDevice(com.ctre.CANTalon.FeedbackDevice.QuadEncoder);
			rDTOne.setFeedbackDevice(com.ctre.CANTalon.FeedbackDevice.QuadEncoder);
			lDTOne.setPID(p, i, d);
			rDTOne.setPID(p, i, d);
			
		}
		if(driveBaseState == 2){
			lDTOne.changeControlMode(com.ctre.CANTalon.TalonControlMode.PercentVbus);
			lDTTwo.changeControlMode(com.ctre.CANTalon.TalonControlMode.Follower);
			rDTOne.changeControlMode(com.ctre.CANTalon.TalonControlMode.PercentVbus);
			rDTTwo.changeControlMode(com.ctre.CANTalon.TalonControlMode.Follower);
		}
	}
	public void driveTank(double leftSpeed, double rightSpeed){


	if(Robot.oi.driverGamepad.getLeftTrigger()){
		lDTOne.set(0.5*leftSpeed);
		lDTTwo.set(RobotMap.leftMotorOne);
		rDTOne.set(0.5*-rightSpeed);
		rDTTwo.set(RobotMap.rightMotorOne);
		Robot.shooter.flashlightOn();
	}
	else{
		lDTOne.set(leftSpeed);
		lDTTwo.set(RobotMap.leftMotorOne);
		rDTOne.set(-rightSpeed);
		rDTTwo.set(RobotMap.rightMotorOne);
		Robot.shooter.flashlightOff();
	}
	if(Robot.oi.driverGamepad.getRightTrigger()){
		driveBaseShifter.set(true);
	}
	else{
		driveBaseShifter.set(false);
	}

	}
	
	public void driveToEncPosition(double encPosition){
		lDTOne.setSetpoint(encPosition);
		lDTTwo.set(RobotMap.leftMotorOne);
		rDTOne.setSetpoint(encPosition);
		lDTTwo.set(RobotMap.rightMotorOne);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveTankDefault());
    }
    public void shift(){
  
    }
}


