package org.usfirst.frc.team1058.robot.subsystems;

import org.usfirst.frc.team1058.robot.Robot;
import org.usfirst.frc.team1058.robot.RobotMap;

import org.usfirst.frc.team1058.robot.commands.IntakeDefaultCommand;
import org.usfirst.frc.team1058.robot.commands.SetIntakeAngle;
import org.usfirst.frc.team1058.robot.commands.ShootingLoop;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Intake extends Subsystem {
    
    public Intake() {
	}

	// Put methods for controlling this subsystem
    // here. Call these from Commands.
	public CANTalon intakeAngleTalon = new CANTalon(RobotMap.intakeAngleCANTalon);

	
	public double timesRun;
	double p = 1;
	double i = 0;
	double d = 0;
	
    public void initDefaultCommand() {
    
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new IntakeDefaultCommand());
    }
    
    public void initializeMotors(){
    	intakeAngleTalon.changeControlMode(CANTalon.TalonControlMode.Position);
    	intakeAngleTalon.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
    	intakeAngleTalon.reverseOutput(true);
    	intakeAngleTalon.setPosition(0);
    	intakeAngleTalon.setSetpoint(0);
    	intakeAngleTalon.configMaxOutputVoltage(6);
    	
    	intakeAngleTalon.setSafetyEnabled(false);
    	intakeAngleTalon.setPID(p, i, d);
    	SmartDashboard.putBoolean("initmotors", true);

    	
    }
    
    public void setIntakeAngle(double intakeAngle){ // send the encoder count of the desired intake angle 
    	intakeAngleTalon.setSetpoint(intakeAngle);

}		
    
    	public void voltageOnlyFrance(){
    		intakeAngleTalon.changeControlMode(CANTalon.TalonControlMode.Voltage);
    		intakeAngleTalon.set(-0.5);
    		new WaitCommand(0.5);
    		intakeAngleTalon.set(0);
    		intakeAngleTalon.changeControlMode(CANTalon.TalonControlMode.Position);
    	}
    	
    
    

    
    public void shoot(){

    }

}

