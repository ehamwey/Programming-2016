package org.usfirst.frc.team1058.robot;

import edu.wpi.first.wpilibj.buttons.Button;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team1058.robot.commands.AutoAimNFwdBack;
import org.usfirst.frc.team1058.robot.commands.AutoAimNFwdBackTwo;
import org.usfirst.frc.team1058.robot.commands.ClimberFirstStageExtend;
import org.usfirst.frc.team1058.robot.commands.ClimberFirstStageRetract;
import org.usfirst.frc.team1058.robot.commands.ClimberSecondStageExtend;
import org.usfirst.frc.team1058.robot.commands.ClimberSecondStageRetract;
import org.usfirst.frc.team1058.robot.commands.ClimberWinch;
import org.usfirst.frc.team1058.robot.commands.ExampleCommand;
import org.usfirst.frc.team1058.robot.commands.PrepareToShoot;
import org.usfirst.frc.team1058.robot.commands.SetIntakeAngle;
import org.usfirst.frc.team1058.robot.commands.ShiftDriveBase;
import org.usfirst.frc.team1058.robot.commands.ShootingLoop;
import org.usfirst.frc.team1058.robot.commands.ShootingLoopTeleWatcher;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    public Gamepad driverGamepad = new Gamepad(0);
    public Gamepad operatorGamepad = new Gamepad(1);
    
	public OI(){

	new JoystickButton(operatorGamepad, 5).whenPressed(new ShootingLoop());
    new JoystickButton(operatorGamepad, 1).whenPressed(new SetIntakeAngle(0)); // straight up, for calibration
    new JoystickButton(operatorGamepad, 3).whenPressed(new SetIntakeAngle(-2000)); // intake/cdf prepare position
    new JoystickButton(operatorGamepad, 4).whenPressed(new SetIntakeAngle(-1009)); // shooting position
    new JoystickButton(operatorGamepad, 2).whenPressed(new SetIntakeAngle(1750)); // ball hold position
    new JoystickButton(operatorGamepad, 7).whenPressed(new ClimberFirstStageExtend());
    new JoystickButton(operatorGamepad, 7).whenReleased(new ClimberFirstStageRetract());
    new JoystickButton(operatorGamepad, 6).whenPressed(new ClimberSecondStageExtend());
    new JoystickButton(operatorGamepad, 6).whenReleased(new ClimberSecondStageRetract());
    new JoystickButton(driverGamepad, 8).whileHeld(new AutoAimNFwdBack(false));
    new JoystickButton(driverGamepad, 7).whileHeld(new AutoAimNFwdBackTwo(false));
    new JoystickButton(operatorGamepad, 8).whileHeld(new ClimberWinch(false));
    new JoystickButton(operatorGamepad, 8).whenReleased(new ClimberWinch(true));
	}
    
	
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
 
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

