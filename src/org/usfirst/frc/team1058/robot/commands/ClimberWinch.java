
package org.usfirst.frc.team1058.robot.commands;

import org.usfirst.frc.team1058.robot.Robot;
import org.usfirst.frc.team1058.robot.subsystems.Climber;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimberWinch extends Command {
boolean stopc;
    public ClimberWinch(boolean stop) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	stopc = stop;
    	requires(Robot.climber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute(){
    	if(stopc){
    		Robot.climber.stopWinch();
    	}
    	else{
    	Robot.climber.winch();
    	}
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
