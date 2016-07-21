package org.usfirst.frc.team1058.robot.commands;

import org.usfirst.frc.team1058.robot.Gamepad;
import org.usfirst.frc.team1058.robot.Robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class IntakeDefaultCommand extends Command {
static double timesRun = 0;
    public IntakeDefaultCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intake);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timesRun ++;
    	if(timesRun < 2){
        	Robot.intake.initializeMotors();
        	Robot.intake.intakeAngleTalon.enableControl();
        	System.out.println("intakeenabled");
    	}
    	else{
        	Robot.intake.intakeAngleTalon.enableControl();

    	}
    	
    }
    

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.oi.operatorGamepad.getAButton() || Robot.oi.operatorGamepad.getBButton() || Robot.oi.operatorGamepad.getXButton() || Robot.oi.operatorGamepad.getYButton()){
    		
    	}
    	else{
    		if(Robot.oi.operatorGamepad.getRightStickY() > 0.1 || Robot.oi.operatorGamepad.getRightStickY() < -0.1){
        		Robot.intake.setIntakeAngle((-Robot.oi.operatorGamepad.getRightStickY()*60)+Robot.intake.intakeAngleTalon.getSetpoint());

    		}
    		else{
    			
    		}
    	}
    	SmartDashboard.putNumber("Intake Angle Encoder Val", Robot.intake.intakeAngleTalon.getPosition());
    	SmartDashboard.putNumber("Intake Angle Setpoint Val", Robot.intake.intakeAngleTalon.getSetpoint());
    	SmartDashboard.putNumber("Intake Angle Output Val", Robot.intake.intakeAngleTalon.getOutputVoltage());


    }
    
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
