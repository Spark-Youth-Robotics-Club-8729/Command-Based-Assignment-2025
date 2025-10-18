package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.DriveSubsystem;

public class ArcadeDriveCommand extends CommandBase {
    private final DriveSubsystem driveSubsystem;
    private final Joystick driverStick;

    public ArcadeDriveCommand(DriveSubsystem subsystem, Joystick stick) {
        driveSubsystem = subsystem;
        driverStick = stick;
        addRequirements(subsystem);
    }

    @Override
    public void execute() {
        double forward = -driverStick.getRawAxis(1) * 0.7; // Cap at 0.7
        double turn = driverStick.getRawAxis(4) * 0.8; // Cap at 0.8
        driveSubsystem.arcadeDrive(forward, turn);
    }
}