package org.usfirst.frc.team1058.robot.commands;

import org.usfirst.frc.team1058.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class IntakeRollerDefault extends Command {

    public IntakeRollerDefault() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intakeRoller);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.intakeRoller.initializeMotors();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.oi.operatorGamepad.getLeftStickY() > 0.1 || Robot.oi.operatorGamepad.getLeftStickY() < -0.1){
        	Robot.intakeRoller.setIntakeSpeed(-0.75*Robot.oi.operatorGamepad.getLeftStickY());
        	SmartDashboard.putBoolean("iszeromode", false);
    	}
    	else{
    		Robot.intakeRoller.setIntakeSpeed(0);
    		SmartDashboard.putBoolean("iszeromode", true);
    	}
    	SmartDashboard.putNumber("Intake Roller Current", Robot.intakeRoller.intakeRollerTalon.getOutputCurrent());

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
    	end();
    }
}
