package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCommand extends CommandBase {
    private final IntakeSubsystem intakeSubsystem;
    private final Joystick operatorStick;

    public IntakeCommand(IntakeSubsystem subsystem, Joystick stick) {
        intakeSubsystem = subsystem;
        operatorStick = stick;
        addRequirements(subsystem);
    }

    @Override
    public void execute() {
        if (operatorStick.getRawButton(1)) {
            intakeSubsystem.setIntake(0.4);  // Intake in
        } else if (operatorStick.getRawButton(2)) {
            intakeSubsystem.setIntake(-0.4); // Intake out
        } else {
            intakeSubsystem.setIntake(0);    // Will apply stall based on last direction
        }
    }
}