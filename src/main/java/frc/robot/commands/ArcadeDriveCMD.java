// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class ArcadeDriveCMD extends CommandBase {
  /** Creates a new ArcadeDriveCMD. */
  private final DriveSubsystem driveSubsystem;
  private final Joystick joystick;

  public ArcadeDriveCMD(DriveSubsystem subsystem, Joystick joystick) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driveSubsystem = subsystem;
    this.joystick = joystick;
    addRequirements(driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double forward = -joystick.getRawAxis(1);
    double turn = -joystick.getRawAxis(4);

    double cappedForward = Math.max(Math.min(forward, 0.7), -0.7);
    double cappedTurn = Math.max(Math.min(turn, 0.8), -0.8);

    driveSubsystem.driveArcade(cappedForward, cappedTurn);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveSubsystem.driveArcade(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
