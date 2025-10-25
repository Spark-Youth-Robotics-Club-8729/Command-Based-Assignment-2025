package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class ArcadeDriveCommand extends Command {
  private final DriveSubsystem driveSubsystem;
  private final Joystick driverJoystick;
  private final double MAX_FORWARD_SPEED = 0.7;
  private final double MAX_TURN_SPEED = 0.8;

  public ArcadeDriveCommand(DriveSubsystem driveSubsystem, Joystick driverJoystick) {
    this.driveSubsystem = driveSubsystem;
    this.driverJoystick = driverJoystick;
    addRequirements(driveSubsystem);
  }

  @Override
  public void execute() {
    double forward = -driverJoystick.getRawAxis(1) * MAX_FORWARD_SPEED;
    double turn = driverJoystick.getRawAxis(4) * MAX_TURN_SPEED;
    driveSubsystem.arcadeDrive(forward, turn);
  }

  @Override
  public void end(boolean interrupted) {
    driveSubsystem.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
