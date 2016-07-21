package org.usfirst.frc.team1058.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class LowBarHighGoal extends CommandGroup {
    
    public  LowBarHighGoal() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
     	addParallel(new SetIntakeAngle(1850));
    	addSequential(new WaitCommand(1));
    	addSequential(new DriveTankAutonomously(-0.3,-0.4,0,false,8.6));
    	addSequential(new DriveTankAutonomously(0.0, -0.65,0,false,2));
    	addParallel(new SetIntakeAngle(-1000));
    	addSequential(new DriveTankAutonomously(-0.5,-0.65,0,false,0.9));
    	
    	addParallel(new DriveTankAutonomously(-0.1, -0.1,0,false,1));
    	
    	addSequential(new WaitCommand(0.3));
    	addSequential(new ShootingLoop());
    	addSequential(new DriveTankAutonomously(0,0,0,false,1));
    }
}
